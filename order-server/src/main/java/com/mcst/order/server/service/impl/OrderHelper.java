package com.mcst.order.server.service.impl;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.mcst.merchant.api.dto.MerchantInfoDto;
import com.mcst.merchant.server.repository.IMerchantInfoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class OrderHelper {

    private static LoadingCache<String, MerchantInfoDto> merchantInfoCache;
    @Resource
    private IMerchantInfoRepository merchantInfoRepository;

    @PostConstruct
    public void init() {
        merchantInfoCache = Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .refreshAfterWrite(5, TimeUnit.MINUTES)
                .build(key -> merchantInfoRepository.queryById(key));
    }


    public MerchantInfoDto getMerchantInfo(String merchantId) {
        return merchantInfoCache.get(merchantId);
    }
}
