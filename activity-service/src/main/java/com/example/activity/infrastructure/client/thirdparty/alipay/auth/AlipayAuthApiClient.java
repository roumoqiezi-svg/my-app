package com.example.activity.infrastructure.client.thirdparty.alipay.auth;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "alipay-auth" , url = "http://alipay.com/auth/")
public interface AlipayAuthApiClient {
}
