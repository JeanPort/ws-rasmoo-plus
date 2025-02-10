package com.cliente.ws.rasmooplus.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PostUserTypeRequest(
        @NotBlank(message = "O campo 'name' não pode ser nulo ou em branco")
        String name,
        @NotBlank(message = "O campo 'description' não pode ser nulo ou em branco")
        String description) {
}
