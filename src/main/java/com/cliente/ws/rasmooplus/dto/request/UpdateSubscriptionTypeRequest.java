package com.cliente.ws.rasmooplus.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateSubscriptionTypeRequest(
        @NotNull(message = "O campo 'id' não pode ser nulo")
        Long id,
        @NotBlank(message = "O campo 'name' não pode ser nulo ou em branco")
        String name,
        @Max(value = 12, message = "O campo accessMonth não pode ser maior que 12")
        Integer accessMonth,
        @NotNull(message = "O campo 'price' não pode ser nulo")
        BigDecimal price,
        @NotBlank(message = "O campo 'productKey' não pode ser nulo ou em branco")
        String productKey
) {
}
