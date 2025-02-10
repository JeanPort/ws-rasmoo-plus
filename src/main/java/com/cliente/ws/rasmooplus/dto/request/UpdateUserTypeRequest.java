package com.cliente.ws.rasmooplus.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserTypeRequest(
        @NotNull(message = "O campo 'id' não pode ser nulo ou em branco")
        Long id,
        @NotBlank(message = "O campo 'name' não pode ser nulo ou em branco")
        String name,
        @NotBlank(message = "O campo 'description' não pode ser nulo ou em branco")
        String description) {
}
