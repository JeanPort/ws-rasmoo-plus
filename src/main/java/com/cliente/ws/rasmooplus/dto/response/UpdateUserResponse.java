package com.cliente.ws.rasmooplus.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UpdateUserResponse(
        Long id,
        String name,
        String email,
        String phone,
        String cpf,
        LocalDate dtSubscription
) {
}
