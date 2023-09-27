package com.beehyv.payment.service;

import com.beehyv.payment.dto.RegisterMerchantRequest;
import org.springframework.http.ResponseEntity;

public interface MerchantService {
    ResponseEntity<String> createMerchant(RegisterMerchantRequest request);
}
