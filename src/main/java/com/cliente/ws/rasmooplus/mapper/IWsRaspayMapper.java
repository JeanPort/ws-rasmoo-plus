package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PaymentProcessRequest;
import com.cliente.ws.rasmooplus.dto.request.UserPaymentInfoDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.CreditCardDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserPaymentInfo;

public interface IWsRaspayMapper {

    CustomerDto toCustomerDto(User user);
    OrderDto toOrderDto(CustomerDto customer, PaymentProcessRequest paymentProcessRequest);
    PaymentDto toPaymentDto(OrderDto order, UserPaymentInfoDto userPaymentInfoDto, String documentoNumber);
    CreditCardDto toCreditCardDto(UserPaymentInfoDto userPaymentInfoDto, String documentNumber);
    UserPaymentInfo toUserPaymentInfo(User user, UserPaymentInfoDto paymentInfoDto);
}
