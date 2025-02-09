package com.cliente.ws.rasmooplus.dto.request;

import java.math.BigDecimal;

public record PostSubscriptionTypeRequest(
        String name,
        Integer accessMonth,
        BigDecimal price,
        String productKey
) {
}
