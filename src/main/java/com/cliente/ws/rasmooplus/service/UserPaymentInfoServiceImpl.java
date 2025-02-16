package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.request.PaymentProcessRequest;
import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.exception.BusinessException;
import com.cliente.ws.rasmooplus.exception.NotFoundExcption;
import com.cliente.ws.rasmooplus.integration.IWsRaspayIntegrationService;
import com.cliente.ws.rasmooplus.mapper.IWsRaspayMapper;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserPaymentInfo;
import com.cliente.ws.rasmooplus.repository.UserPaymentInfoRepository;
import com.cliente.ws.rasmooplus.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserPaymentInfoServiceImpl implements IUserPaymentInfoService{

    private final UserRepository userRepository;
    private final UserPaymentInfoRepository paymentInfoRepository;
    private final IWsRaspayIntegrationService wsRaspayIntegrationService;
    private final IWsRaspayMapper mapper;

    public UserPaymentInfoServiceImpl(UserRepository userRepository, UserPaymentInfoRepository paymentInfoRepository, IWsRaspayIntegrationService wsRaspayIntegrationService, IWsRaspayMapper mapper) {
        this.userRepository = userRepository;
        this.paymentInfoRepository = paymentInfoRepository;
        this.wsRaspayIntegrationService = wsRaspayIntegrationService;
        this.mapper = mapper;
    }

    @Override
    public Boolean processPayment(PaymentProcessRequest request) {

        var user = userRepository.findById(request.getUserPaymentInfo().getUserId()).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        if (user.getSubscriptionType() != null) {
            throw  new BusinessException("Subscription ja existe");
        }

        var customerDto = mapper.toCustomerDto(user);
        customerDto = wsRaspayIntegrationService.createCustomer(customerDto);

        var orderDto = mapper.toOrderDto(customerDto, request);
        orderDto = wsRaspayIntegrationService.createOrder(orderDto);

        var payment = mapper.toPaymentDto(orderDto,request.getUserPaymentInfo(), user.getCpf());
        Boolean process = wsRaspayIntegrationService.processPayment(payment);

        if (process) {
            var userPaymentInfo = mapper.toUserPaymentInfo(user, request.getUserPaymentInfo());
            paymentInfoRepository.save(userPaymentInfo);
        }

        return null;
    }
}
