package com.cliente.ws.rasmooplus.exception;

import java.util.List;

public record ErrorResponseList(List<String> messages) {
}
