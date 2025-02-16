package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PaymentProcessRequest;
import com.cliente.ws.rasmooplus.dto.request.UserPaymentInfoDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.CreditCardDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserPaymentInfo;

public class WsRaspayMapperImpl implements IWsRaspayMapper{


    @Override
    public CustomerDto toCustomerDto(User user) {
        CustomerDto customer = new CustomerDto();
        var names = user.getName().split(" ");
        customer.setCpf(user.getCpf());
        customer.setEmail(user.getEmail());
        customer.setFirstName(names[0]);
        customer.setLastName(names[names.length - 1]);
        return customer;
    }

    @Override
    public OrderDto toOrderDto(CustomerDto customer, PaymentProcessRequest paymentProcessRequest) {
        OrderDto order = new OrderDto();

        if (customer == null || paymentProcessRequest == null) {
            return null;
        }

        order.setCustomerId(customer.getId());
        order.setDiscount(paymentProcessRequest.getDiscount());
        order.setProductAcronym(paymentProcessRequest.getProductKey());
        return order;
    }

    @Override
    public PaymentDto toPaymentDto(OrderDto order, UserPaymentInfoDto userPaymentInfoDto, String documentNumber) {
        PaymentDto payment = new PaymentDto();
        payment.setCreditCard(toCreditCardDto(userPaymentInfoDto, documentNumber));
        payment.setCustomerId(order.getCustomerId());
        payment.setOrderId(order.getId());
        return  null;
    }

    @Override
    public CreditCardDto toCreditCardDto(UserPaymentInfoDto userPaymentInfoDto, String documentNumber) {
        CreditCardDto card = new CreditCardDto();
        card.setCvv(Integer.parseInt(userPaymentInfoDto.getCardSecurityCode()));
        card.setInstallments(userPaymentInfoDto.getInstalments());
        card.setMonth(userPaymentInfoDto.getCardExcpirationMonth());
        card.setYear(userPaymentInfoDto.getCardExcpirationYear());
        card.setDocumentNumber(documentNumber);
        card.setNumber(userPaymentInfoDto.getCardNumber());
        return card;
    }

    @Override
    public UserPaymentInfo toUserPaymentInfo(User user, UserPaymentInfoDto paymentInfoDto) {
        UserPaymentInfo userPaymentInfo = new UserPaymentInfo();
        userPaymentInfo.setDtPayment(paymentInfoDto.getDtPayment());
        userPaymentInfo.setUser(user);
        userPaymentInfo.setInstalments(paymentInfoDto.getInstalments());
        userPaymentInfo.setCardNumber(paymentInfoDto.getCardNumber());
        userPaymentInfo.setCardExcpirationMonth(paymentInfoDto.getCardExcpirationMonth());
        userPaymentInfo.setCardExcpirationYear(paymentInfoDto.getCardExcpirationYear());
        userPaymentInfo.setCardSecurityCode(paymentInfoDto.getCardSecurityCode());
        userPaymentInfo.setPrice(paymentInfoDto.getPrice());
        return userPaymentInfo;
    }

}
