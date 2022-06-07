package com.CarSaleWebsite.Kolesa.Controllers;

import com.CarSaleWebsite.Kolesa.Models.Order;
import com.CarSaleWebsite.Kolesa.Models.enums.OrderStatus;
import com.CarSaleWebsite.Kolesa.Repositories.OrderFoodRepository;
import com.CarSaleWebsite.Kolesa.Repositories.OrderRepository;
import com.CarSaleWebsite.Kolesa.Services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.ZonedDateTime;
import java.util.List;

@Controller
@RequestMapping("/indent")
public class IndentController {
    @Autowired
    private final OrderService orderService;
    @Autowired
    private final OrderRepository orderRepository;

    public IndentController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/general", method = RequestMethod.GET)
    public String getGeneralOrders(Model model) {
        List<Order> orderList = orderRepository.findGeneralOrders();
        model.addAttribute("orders", orderList);
        return "indent-page";
    }

    @RequestMapping(value = "/general", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> getDone(@RequestParam Integer order_id, HttpServletRequest request, HttpServletResponse response, Model model) {
        orderService.setDone(order_id);
        return ResponseEntity.ok("Success");
    }

}
