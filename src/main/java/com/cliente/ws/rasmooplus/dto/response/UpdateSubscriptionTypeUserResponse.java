package com.cliente.ws.rasmooplus.dto.response;

import java.math.BigDecimal;

public record UpdateSubscriptionTypeUserResponse(
        Long id,
        String name,
        Integer accessMonth,
        BigDecimal price,
        String productKey
) {
}
