package com.cliente.ws.rasmooplus.dto.request;

import java.math.BigDecimal;

public class PaymentProcessRequest {

    private String productKey;
    private BigDecimal discount;
    private UserPaymentInfoPostRequest userPaymentInfo;

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public UserPaymentInfoPostRequest getUserPaymentInfo() {
        return userPaymentInfo;
    }

    public void setUserPaymentInfo(UserPaymentInfoPostRequest userPaymentInfo) {
        this.userPaymentInfo = userPaymentInfo;
    }
}
