package com.beehyv.payment.service.impl;


import com.beehyv.payment.dto.RegisterMerchantRequest;
import com.beehyv.payment.entity.Merchant;
import com.beehyv.payment.repository.MerchantRepository;
import com.beehyv.payment.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public ResponseEntity<String> createMerchant(RegisterMerchantRequest request) {
        Merchant merchant = new Merchant(request.getMerchantId(), request.getName(), request.getPhone(), request.getEmail(), request.getBusinessType(), request.getAddress(),request.getPhone());
        merchantRepository.save(merchant);
        return ResponseEntity.ok("Merchant registered successfully.");
    }
}

