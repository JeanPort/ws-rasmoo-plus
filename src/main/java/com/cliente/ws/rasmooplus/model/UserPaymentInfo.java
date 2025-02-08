package com.cliente.ws.rasmooplus.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "user_payment_info")
public class UserPaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_payment_info_id")
    private Long id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_excpiration_month")
    private Integer cardExcpirationMonth;
    @Column(name = "card_excpiration_year")
    private Integer cardExcpirationYear;
    @Column(name = "card_security_code")
    private String cardSecurityCode;
    private BigDecimal price;
    private Integer instalments;
    @Column(name = "dt_payment")
    private LocalDate dtPayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserPaymentInfo that = (UserPaymentInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(cardNumber, that.cardNumber) && Objects.equals(cardExcpirationMonth, that.cardExcpirationMonth) && Objects.equals(cardExcpirationYear, that.cardExcpirationYear) && Objects.equals(cardSecurityCode, that.cardSecurityCode) && Objects.equals(price, that.price) && Objects.equals(instalments, that.instalments) && Objects.equals(dtPayment, that.dtPayment) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cardExcpirationMonth, cardExcpirationYear, cardSecurityCode, price, instalments, dtPayment, user);
    }

    @Override
    public String toString() {
        return "UserPaymentInfo{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardExcpirationMonth=" + cardExcpirationMonth +
                ", cardExcpirationYear=" + cardExcpirationYear +
                ", cardSecurityCode='" + cardSecurityCode + '\'' +
                ", price=" + price +
                ", instalments=" + instalments +
                ", dtPayment=" + dtPayment +
                ", user=" + user +
                '}';
    }
}
