package com.cliente.ws.rasmooplus.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
    private Double price;
    private Integer instalments;
    @Column(name = "dt_payment")
    private LocalDateTime dtPayment;

}
