package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final DiscountCalculator discountCalculator;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public Order placeOrder(Long customerId, int orderNumber) {
        Customer customer = customerService.getCustomerById(customerId);
        double discount = discountCalculator.calculateDiscount(customer.getOrderCount());

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderNumber(orderNumber);
        order.setDiscount(discount);
        customer.setOrderCount(customer.getOrderCount() + 1);
        customerRepository.save(customer);
        return orderRepository.save(order);
    }

    public Order createDraft(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
