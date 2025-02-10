package com.cliente.ws.rasmooplus.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UserPostRequest(
        @NotBlank(message = "O campo 'name' não pode ser nulo ou em branco")
        String name,
        @NotBlank(message = "O campo 'email' não pode ser nulo ou em branco")
        @Email(message = "Email invalido")
        String email,
        @NotBlank(message = "O campo 'phone' não pode ser nulo ou em branco")
        String phone,
        @NotBlank(message = "O campo 'cpf' não pode ser nulo ou em branco")
        @CPF(message = "cpf invalido")
        String cpf,
        @NotNull(message = "O campo 'userTypeId' não pode ser nulo")
        Long userTypeId,
        Long subscriptionTypeId
) {
}
