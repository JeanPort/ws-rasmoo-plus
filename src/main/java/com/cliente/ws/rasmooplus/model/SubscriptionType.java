package com.cliente.ws.rasmooplus.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "subscriptions_type")
public class SubscriptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    private Long id;
    private String name;
    @Column(name = "access_months")
    private Integer accessMonth;
    private BigDecimal price;
    @Column(name = "product_key")
    private String productKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccessMonth() {
        return accessMonth;
    }

    public void setAccessMonth(Integer accessMonth) {
        this.accessMonth = accessMonth;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionType that = (SubscriptionType) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(accessMonth, that.accessMonth) && Objects.equals(price, that.price) && Objects.equals(productKey, that.productKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accessMonth, price, productKey);
    }

    @Override
    public String toString() {
        return "SubscriptionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accessMonth=" + accessMonth +
                ", price=" + price +
                ", productKey='" + productKey + '\'' +
                '}';
    }
}
