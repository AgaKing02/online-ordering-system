package com.CarSaleWebsite.Kolesa.Controllers;

import com.CarSaleWebsite.Kolesa.DTO.ChargeRequest;
import com.CarSaleWebsite.Kolesa.Models.Order;
import com.CarSaleWebsite.Kolesa.Models.enums.OrderStatus;
import com.CarSaleWebsite.Kolesa.Repositories.OrderRepository;
import com.CarSaleWebsite.Kolesa.Services.StripeService;
import com.CarSaleWebsite.Kolesa.Services.interfaces.OrderService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.AuthenticationException;
import java.time.ZonedDateTime;

@Controller
public class ChargeController {

    @Autowired
    private StripeService paymentsService;
    @Autowired
    private OrderService orderService;


    @PostMapping("/charge/{order}")
    public String charge(@PathVariable(name = "order") Order order, ChargeRequest chargeRequest, Model model)
            throws StripeException {
        chargeRequest.setCurrency(ChargeRequest.Currency.KZT);
        Charge charge = null;
        try {
            charge = paymentsService.charge(chargeRequest);
            Order payTheOrder = orderService.payTheOrder(order);
            charge.setDescription("Charged entity : {}" + payTheOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("order", order.getId());
        model.addAttribute("id", charge != null ? charge.getId() : null);
        model.addAttribute("status", charge != null ? charge.getStatus() : null);
        model.addAttribute("chargeId", charge != null ? charge.getId() : null);
        model.addAttribute("balance_transaction", charge != null ? charge.getBalanceTransaction() : null);
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
