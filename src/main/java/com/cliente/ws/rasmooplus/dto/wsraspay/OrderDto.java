package com.cliente.ws.rasmooplus.dto.wsraspay;

import java.math.BigDecimal;

public class OrderDto {

    private String id;
    private String customerId;
    private BigDecimal discount;
    private String productAcronym;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getProductAcronym() {
        return productAcronym;
    }

    public void setProductAcronym(String productAcronym) {
        this.productAcronym = productAcronym;
    }
}
