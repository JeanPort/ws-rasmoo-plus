package com.cliente.ws.rasmooplus.dto.wsraspay;

public class OrderDto {

    private String id;
    private String customerId;
    private Integer discount;
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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getProductAcronym() {
        return productAcronym;
    }

    public void setProductAcronym(String productAcronym) {
        this.productAcronym = productAcronym;
    }
}
