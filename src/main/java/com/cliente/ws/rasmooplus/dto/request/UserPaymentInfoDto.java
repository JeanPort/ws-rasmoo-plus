package com.cliente.ws.rasmooplus.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UserPaymentInfoDto {

    private Long id;
    @Size(min = 16, max = 16, message = "O atributo 'cardNumber' deve conter 16 caracteres")
    private String cardNumber;
    private Integer cardExcpirationMonth;
    private Integer cardExcpirationYear;
    private String cardSecurityCode;
    private BigDecimal price;
    private Integer instalments;
    private LocalDate dtPayment = LocalDate.now();
    @NotNull(message = "O atributo 'userId' não pode ser nulo")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCardExcpirationMonth() {
        return cardExcpirationMonth;
    }

    public void setCardExcpirationMonth(Integer cardExcpirationMonth) {
        this.cardExcpirationMonth = cardExcpirationMonth;
    }

    public Integer getCardExcpirationYear() {
        return cardExcpirationYear;
    }

    public void setCardExcpirationYear(Integer cardExcpirationYear) {
        this.cardExcpirationYear = cardExcpirationYear;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getInstalments() {
        return instalments;
    }

    public void setInstalments(Integer instalments) {
        this.instalments = instalments;
    }

    public LocalDate getDtPayment() {
        return dtPayment;
    }

    public void setDtPayment(LocalDate dtPayment) {
        this.dtPayment = dtPayment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
