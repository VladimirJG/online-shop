package ru.danilov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.danilov.model.Order;
import ru.danilov.repository.OrderRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrdersByUserId(int id) {
        return orderRepository.findAllByOwnerId(id);
    }

    @Transactional
    public void addNewOrder(Order order) {
        orderRepository.save(order);
    }
}
