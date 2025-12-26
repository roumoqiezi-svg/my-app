package com.example.activity.infrastructure.client.thirdparty.alipay.trade;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "alipay-trade" , url = "http://alipay.com/trade/")
public interface AlipayTradeApiClient {
}
