package com.beehyv.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMerchantRequest {
    private Long merchantId;
    private String name;
    private String email;
    private String businessType;
    private String address;
    private String phone;
}

