package com.cliente.ws.rasmooplus.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserTypeResponse(
        Long id,
        String name,
        String description) {
}
