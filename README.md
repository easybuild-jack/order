# Order 订单管理模块

> 基于 `easyfk` 基础框架的**订单生命周期管理**模块，支持四种配送方式（快递、自提、上门、货柜），覆盖订单从创建到售后的完整流程，同时支持 **Spring Cloud（Feign）** 与 **Apache Dubbo** 两种远程调用方式，方便单体或微服务架构集成。

- **项目版本**：`<latest>`（请以实际发布的最新版本为准）
- **Maven Group**：`com.mcst`
- **构建工具**：Gradle（版本以根 `gradle/wrapper/gradle-wrapper.properties` 为准）
- **JDK**：Java 21+
- **框架**：Spring Boot 3.x、Spring Cloud OpenFeign、Apache Dubbo 3.x
- **辅助工具**：Lombok、MapStruct Plus、Hutool、Caffeine、Redisson

---

## 一、项目主要功能

1. **订单状态流转**
   - 待支付 → 已取消 / 待发货 → 待收货 → 已收货。

2. **四种配送方式**
   - 快递配送（OrderDeliver）、到店自提（OrderPickup）、送货上门、货柜自取（OrderContainer）。

3. **发货管理**
   - 支持物流发货与自配送，关联物流单号。

4. **自提管理**
   - 提货码生成，对接线下提货点。

5. **货柜配送**
   - 对接智能货柜，记录货柜 ID 与格子号。

6. **退款售后**
   - 申请 → 审核 → 退货物流 → 确认收货 → 退款回调，完整退款闭环。
   - 支持仅退款与退货退款两种模式。

7. **用户订单**
   - 我的订单列表、订单详情、全量详情（含商户信息、商品明细、金额拆分、支付信息）。

8. **多租户与数据隔离**
   - 内置 `agentId` / `merchantId` 字段，自动按代理商 / 商户维度过滤数据。

9. **国际化与可配置**
   - 多语言错误码（基于 `i18n/orderMessage_*.properties`）。

---

## 二、项目架构设计

### 2.1 模块划分

```
order
├── order-api          接口契约层：DTO / Req / Resp / Param / VO / Service API
├── order-server       服务实现层：Service + ApiServer 实现 + 工具类 + 配置 + 单测
├── order-prd          Web 表现层：Spring Boot Controller
│   ├── order-prd-client     C 端接口
│   └── order-prd-bms        后台管理接口
├── order-orm          持久化层
│   ├── order-orm-api         仓储接口定义（IRepository）
│   ├── order-orm-plus        MyBatis-Plus 实现
│   ├── order-orm-flex        MyBatis-Flex 实现
│   └── order-orm-hibernate   Hibernate/JPA 实现
├── order-remote       远程调用层（可选接入）
│   ├── order-cloud-api         Spring Cloud 客户端：Feign 接口 + Api 适配
│   ├── order-cloud-provider    Spring Cloud 服务端：暴露 /remote/order/** 的 Controller
│   ├── order-dubbo-api         Dubbo 接口 + Api 适配
│   └── order-dubbo-provider    Dubbo 服务端实现
└── doc               数据库脚本与映射规范说明
    ├── sql/order_mysql.sql
    └── sql/order_postgresql.sql
```

### 2.2 层次与调用关系

```
┌──────────────────────────────────────────────────────────────────────┐
│  客户端 / 调用方                                                       │
└──────────────────────────────────────────────────────────────────────┘
            │                           │                        │
            ▼                           ▼                        ▼
     ┌────────────┐               ┌────────────┐           ┌────────────┐
     │  order-prd │               │ order-     │           │ order-     │
     │ -client/-  │               │ cloud-api  │           │ dubbo-api  │
     │  bms       │               │ (Feign 客  │           │ (Dubbo 消  │
     │(Controller │               │ 户端+Api)  │           │ 费端+Api)  │
     └────────────┘               └────────────┘           └────────────┘
            │                           │                        │
            │                           │ HTTP                   │ Dubbo RPC
            ▼                           ▼                        ▼
                          ┌──────────────────────────────────────┐
                          │ order-cloud-provider / order-dubbo-   │
                          │ provider （统一委托给 order-server）  │
                          └──────────────────────────────────────┘
                                              │
                                              ▼
                              ┌──────────────────────────────┐
                              │          order-server         │
                              │   Service + ApiServer 实现   │
                              │   + Caffeine 本地缓存         │
                              │   + Redisson 分布式锁         │
                              └──────────────────────────────┘
                                              │
                                              ▼
                              ┌──────────────────────────────┐
                              │  order-orm-*（Plus/Flex/Hib） │
                              │   仓储接口 + 持久化实现        │
                              └──────────────────────────────┘
                                              │
                                              ▼
                                          数据库
```

### 2.3 关键设计点

- **接口与实现分离**：`order-api` 只暴露接口与数据模型；`order-server` 提供本地默认实现，通过 Spring Boot 自动装配以 `@ConditionalOnMissingBean` 形式暴露为 Bean，便于上层覆盖。
- **多 ORM 适配**：`order-orm` 把仓储接口抽到 `order-orm-api`，底层分别在 `order-orm-plus / order-orm-flex / order-orm-hibernate` 中提供实现，业务侧按需引入对应依赖即可切换 ORM。
- **远程调用可插拔**：`order-remote` 同时提供 Feign 和 Dubbo 两套客户端，每套又拆出 `-api`（消费端）与 `-provider`（服务端）。消费端把 `IOrderApi`、`IRefundApi` 等适配到远程 `Remote`，再通过 `@AutoConfiguration` 注册到容器；服务端把 `order-server` 的 `Service` 透出成 HTTP / Dubbo 接口。
- **统一参数模型**：遵循 `doc/实体对象映射关系调整指南.md` 中约定的流向（`Sub → Req → Dto → Entity` / `Entity → Dto → Resp`），结合 MapStruct Plus 的 `@AutoMapper` 自动转换。
- **订单数据拆分**：订单主信息、商品明细、金额拆分、支付记录、发货信息、退款信息各自独立建模，结构清晰。
- **多配送模型**：快递（OrderDeliver）、自提（OrderPickup）、货柜（OrderContainer）各有独立数据模型。
- **商户缓存**：通过 Caffeine 本地缓存高频访问的商户信息，减少跨模块调用。
- **事务保障**：创建、取消、支付回调等关键操作均有事务保护与幂等判断。
- **与 Trading 模块协同**：订单数据由 Trading 模块在确认下单后写入，本模块负责后续状态流转、发货、退款。
- **声明式权限控制**：BMS 端通过 `@AuthResource` / `@ResourceController` 注解自动注册菜单与按钮权限，与 Auth 模块联动。

### 2.4 数据模型

| 表名 | 说明 |
| --- | --- |
| `order_main` | 订单主表，含订单号、状态、用户、金额、租户等 |
| `order_item` | 订单商品明细表 |
| `order_amount_split` | 订单金额拆分表 |
| `order_pay_record` | 订单支付记录表 |
| `order_deliver` | 订单快递配送表 |
| `order_pickup` | 订单自提表 |
| `order_container` | 订单货柜配送表 |
| `order_refund` | 订单退款表 |
| `order_refund_logistics` | 退款退货物流表 |

完整建表脚本见 [doc/sql/order_mysql.sql](doc/sql/order_mysql.sql)、[doc/sql/order_postgresql.sql](doc/sql/order_postgresql.sql)。

---

## 三、模块详细说明

### 3.1 `order-api`
- 定义业务接口：`IOrderApi`、`IRefundApi`、`IOrderDeliverApi`、`IOrderPickupApi`、`IOrderContainerApi` 等，并继承 `IBaseApi` 提供通用 CRUD。
- 维护所有数据传输对象：`dto/`、`request/`、`response/`、`param/`、`vo/`。
- 业务接口方法示例：`queryByPage`、`queryById`、`queryByOrderNo`、`cancelOrder`、`confirmReceive`、`applyRefund`、`auditRefund`、`confirmRefund`、`queryUserOrders`、`queryOrderDetail` 等。

### 3.2 `order-server`
- `service/`：业务 Service 接口与实现（`OrderServiceImpl`、`RefundServiceImpl`、`OrderDeliverServiceImpl`、`OrderPickupServiceImpl`、`OrderContainerServiceImpl`）。
- `impl/`：`ApiServer` 实现，继承 `BaseApiServiceImpl`，把 Service 暴露为对应 API。
- `util/`：订单号生成、状态机转换、退款流程等工具类。
- `properties/`：`OrderProperties`（`easyfk.config.order`）。
- `config/OrderServerConfig`：Spring Boot 自动装配入口。
- `src/test/`：基于 JUnit 5 的单元测试。

### 3.3 `order-prd`
- 基于 `easyfk-web-prd` 的 Spring Boot Web 控制器层。
- 控制器清单：
  - `OrderBmsController`：`/api/bms/order/**`（订单查询、取消、发货、确认收货）
  - `RefundBmsController`：`/api/bms/refund/**`（退款审核、确认）
  - `OrderClientController`：`/api/client/order/**`（我的订单、订单详情、取消、确认收货）
  - `RefundClientController`：`/api/client/refund/**`（申请退款、查询退款）
- 通过 `@AuthResource` / `@ResourceController` 注解自动注册权限元数据。

### 3.4 `order-orm`
- `order-orm-api`：仓储接口（`IOrderRepository`、`IRefundRepository` 等）。
- `order-orm-plus`：基于 MyBatis-Plus 的实现 + 自动装配。
- `order-orm-flex`：基于 MyBatis-Flex 的实现 + 自动装配。
- `order-orm-hibernate`：基于 Hibernate/JPA 的实现 + 自动装配。

> 三个 ORM 实现互斥，按需在业务工程中只引入其中一个，避免冲突。

### 3.5 `order-remote`
- `order-cloud-api`：`FeignClient` 接口 + 继承 `BaseApiRemoteImpl` 的 `Api` 实现；通过 `OrderApiProperties`（`easyfk.config.remote.order.service-id/base-path`）读取服务地址。
- `order-cloud-provider`：`@RestController` 把 `order-server` 的 `Service` 暴露为 `/remote/order/**`。
- `order-dubbo-api`：Dubbo 接口 + `Api` 适配实现。
- `order-dubbo-provider`：Dubbo 服务实现。

### 3.6 `doc`
- `实体对象映射关系调整指南.md`：DTO/Entity/Req/Resp/Param/Sub 之间的 `@AutoMapper` 使用规范。
- `sql/`：MySQL、PostgreSQL 建表脚本。

---

## 四、使用方式

### 4.1 构建与发布

```bash
# 清理并编译全部模块
./gradlew clean build

# 发布到本地 Maven 仓库
./gradlew publishToMavenLocal

# 发布到远程 Nexus（在 build.gradle 中已配置 NexusRepository）
./gradlew publish
```

> Windows 环境可直接使用 `gradlew.bat`。模块统一版本：`<latest>`。

### 4.2 单体应用集成（最简方式）

```groovy
dependencies {
    implementation 'com.mcst:order-api:<latest>'
    implementation 'com.mcst:order-server:<latest>'
    // 选择一种 ORM：
    implementation 'com.mcst:order-orm:order-orm-plus:<latest>'
    // implementation 'com.mcst:order-orm:order-orm-flex:<latest>'
    // implementation 'com.mcst:order-orm:order-orm-hibernate:<latest>'

    // 暴露 HTTP 接口（按端选择）
    implementation 'com.mcst:order-prd:order-prd-bms:<latest>'
    implementation 'com.mcst:order-prd:order-prd-client:<latest>'
}
```

`order-server` 会通过 Spring Boot 自动装配把 `IOrderApi`、`IRefundApi` 等 Bean 注册到容器，Controller 可直接 `@Resource` 注入使用。

### 4.3 微服务集成（Spring Cloud）

**消费端：**

```groovy
dependencies {
    implementation 'com.mcst:order-api:<latest>'
    implementation 'com.mcst:order-remote:order-cloud-api:<latest>'
}
```

```yaml
easyfk:
  config:
    remote:
      order:
        service-id: order-server       # 对应服务在注册中心的服务名
        base-path: /remote              # 可选，默认 /remote
```

**服务端：** 启动 `order-server` 并加入 `order-remote:order-cloud-provider`，即可对外提供 `/remote/order/**` 接口。

### 4.4 微服务集成（Apache Dubbo）

```groovy
// 消费端
dependencies {
    implementation 'com.mcst:order-api:<latest>'
    implementation 'com.mcst:order-remote:order-dubbo-api:<latest>'
}

// 服务端
dependencies {
    implementation 'com.mcst:order-server:<latest>'
    implementation 'com.mcst:order-remote:order-dubbo-provider:<latest>'
}
```

### 4.5 关键配置项

| 配置项 | 含义 | 默认值 |
| --- | --- | --- |
| `easyfk.config.order.cancel.expire-minutes` | 未支付订单过期时间（分钟） | `15` |
| `easyfk.config.order.confirm.auto-receive-days` | 自动确认收货天数 | `15` |
| `easyfk.config.remote.order.service-id` | 远程调用目标服务名 | `order-server` |
| `easyfk.config.remote.order.base-path` | 远程调用基础路径 | `/remote` |

### 4.6 初始化数据库

```bash
# MySQL
mysql -u <user> -p <database> < doc/sql/order_mysql.sql

# PostgreSQL
psql -U <user> -d <database> -f doc/sql/order_postgresql.sql
```

### 4.7 主要 REST 接口一览

| 端 | 路径 | 方法 | 说明 |
| --- | --- | --- | --- |
| BMS | `/api/bms/order/queryPage` | GET | 分页查询 |
| BMS | `/api/bms/order/detail` | GET | 订单详情 |
| BMS | `/api/bms/order/cancel` | POST | 取消订单 |
| BMS | `/api/bms/order/deliver` | POST | 发货 |
| BMS | `/api/bms/order/confirmReceive` | POST | 确认收货 |
| BMS | `/api/bms/refund/audit` | POST | 审核退款 |
| BMS | `/api/bms/refund/confirm` | POST | 确认退款 |
| Client | `/api/client/order/myOrders` | GET | 我的订单 |
| Client | `/api/client/order/detail` | GET | 订单详情 |
| Client | `/api/client/order/cancel` | POST | 取消订单 |
| Client | `/api/client/order/confirmReceive` | POST | 确认收货 |
| Client | `/api/client/refund/apply` | POST | 申请退款 |
| Client | `/api/client/refund/list` | GET | 退款列表 |

> 接口均通过 Swagger OpenAPI 注解描述，可在启动后访问 `/swagger-ui.html` 查看完整文档。

---

## 五、扩展指引

- **新增业务字段**：在 `order-api` 的 `Dto` 中新增字段 → 在 `Entity` 中同步 → 选择对应 ORM 模块更新映射 → 视情况更新 `Resp`、`Req`、`VO`。
- **新增配送方式**：在 `OrderDeliverTypeEnum` 中新增枚举 → 新建对应 Service 与 ORM 映射 → 在 `IOrderApi` 中补充方法。
- **新增状态流转**：在 `OrderStatusEnum` 与 `OrderStatusMachine` 中扩展状态机 → 在 `OrderServiceImpl` 中补充流转逻辑。
- **新增业务接口**：在 `order-api` 暴露方法 → 在 `order-server` 的 `Service` 与 `ApiServer` 中实现 → 选择在 `order-prd` 增加 Controller 或在 `order-remote` 暴露远程能力。
- **切换 ORM**：只保留目标 ORM 模块的依赖（如只想用 MyBatis-Plus，则移除 `order-orm-flex`、`order-orm-hibernate` 依赖）。
- **国际化**：在 `order-server/src/main/resources/i18n/` 下追加语言键值即可。

---

## 六、目录速览

```
order
├── build.gradle                根构建脚本（统一版本、Java 21、Lombok、MapStruct Plus、Caffeine、Redisson）
├── settings.gradle             多模块声明
├── gradle/, gradlew, gradlew.bat
├── order-api/                  接口契约
├── order-server/               服务实现 + 单测
├── order-prd/
│   ├── order-prd-client/
│   └── order-prd-bms/
├── order-orm/
│   ├── order-orm-api/
│   ├── order-orm-plus/
│   ├── order-orm-flex/
│   └── order-orm-hibernate/
├── order-remote/
│   ├── order-cloud-api/
│   ├── order-cloud-provider/
│   ├── order-dubbo-api/
│   └── order-dubbo-provider/
└── doc/
    └── sql/
```
