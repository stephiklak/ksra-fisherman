package com.ksra.fisherman.service;

import com.ksra.fisherman.model.Payment;
import com.ksra.fisherman.model.ServiceRequest;
import com.ksra.fisherman.model.User;
import com.ksra.fisherman.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment createPayment(User customer, ServiceRequest serviceRequest, Double amount) {
        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setServiceRequest(serviceRequest);
        payment.setAmount(amount);
        return paymentRepository.save(payment);
    }
}
