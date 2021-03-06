package com.CarSaleWebsite.Kolesa.Controllers;

import com.CarSaleWebsite.Kolesa.DTO.AjaxResponseBody;
import com.CarSaleWebsite.Kolesa.Models.DiningTableTrack;
import com.CarSaleWebsite.Kolesa.Models.Order;
import com.CarSaleWebsite.Kolesa.Models.OrderFood;
import com.CarSaleWebsite.Kolesa.Repositories.DiningTableTrackRepository;
import com.CarSaleWebsite.Kolesa.Repositories.OrderFoodRepository;
import com.CarSaleWebsite.Kolesa.Repositories.OrderRepository;
import com.CarSaleWebsite.Kolesa.Services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;


    private static final String emoji = "ð ð ð ð ð ð ð ð ð ð ð ð ðĨ­ ð ðĨĨ ðĨ ð ð ðĨ ðĨĶ ðĨŽ ðĨ ðķ ð― ðĨ ð§ ð§ ðĨ ð  ðĨ ðĨŊ ð ðĨ ðĨĻ ð§ ðĨ ðģ ð§ ðĨ ð§ ðĨ ðĨĐ ð ð ðĶī ð­ ð ð ð ðĨŠ ðĨ ð§ ðŪ ðŊ ðĨ ðĨ ðĨŦ ð ð ðē ð ðĢ ðą ðĨ ðĶŠ ðĪ ð ð ð ðĨ ðĨ  ðĨŪ ðĒ ðĄ ð§ ðĻ ðĶ ðĨ§ ð§ ð° ð ðŪ ð­ ðŽ ðŦ ðŋ ðĐ ðŠ ð° ðĨ ðŊ ðĨ ðž â ðĩ ð§ ðĨĪ ðķ ðš ðŧ ðĨ ð· ðĨ ðļ ðđ ð§ ðū ð§ ðĨ ðī ð― ðĨĢ ðĨĄ ðĨĒ ð§";


    @GetMapping("/orders")
    public String list(Principal principal, Model model) {
        Iterable<Order> orders = orderService.getMyOrder(principal.getName());
        model.addAttribute("orders", orders);
        model.addAttribute("emoji", Arrays.asList(emoji.split("\\s+")));
        return "order-page";

    }

    @GetMapping("/orders/view/{id}")
    public String getMyOrder(Principal principal, Model model, @PathVariable(name = "id") Order order) {
        if (!order.getUser().getUsername().equals(principal.getName())) {
            return "redirect:/orders";
        }
        model.addAttribute("o", order);
        return "orders-details";

    }

    @GetMapping("/orders/status/{id}")
    public @ResponseBody
    ResponseEntity<?> getMyOrderStatus(Principal principal, @PathVariable(name = "id") Long id) {
        Order order = orderRepository.findByIdAndUserUsername(id, principal.getName());

        if (!order.getUser().getUsername().equals(principal.getName())) {
            return ResponseEntity.badRequest().body(new AjaxResponseBody("ERROR"));
        }
        return ResponseEntity.badRequest().body(order);
    }

    @PostMapping("/orders/remove/{order}")
    public String deleteOrder(Principal principal, @PathVariable(name = "order") Long id) {
        orderService.deleteTheOrder(id, principal.getName());
        return "redirect:/orders";
    }

}
