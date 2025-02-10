package com.cliente.ws.rasmooplus.dto.response;

public record GetUserResponse(
        Long id,
        String name,
        String email,
        String phone,
        String cpf,
        Long userTypeId,
        Long subscriptionTypeId
) {
}
