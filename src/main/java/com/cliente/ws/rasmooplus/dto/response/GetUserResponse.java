package com.cliente.ws.rasmooplus.dto.response;

import java.time.LocalDate;

public record GetUserResponse(
        Long id,
        String name,
        String email,
        String phone,
        String cpf,
        LocalDate dtSubscription,
        LocalDate dtExpiration,
        Long userTypeId,
        Long subscriptionTypeId
) {
}
