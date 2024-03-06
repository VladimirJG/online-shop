package ru.danilov.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danilov.model.User;
import ru.danilov.model.Views;
import ru.danilov.service.OrderService;
import ru.danilov.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public ShopController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @JsonView(Views.UserSummary.class)
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @JsonView(Views.UserDetails.class)
    @GetMapping("/{id}")
    public User getUserBuId(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }
}
