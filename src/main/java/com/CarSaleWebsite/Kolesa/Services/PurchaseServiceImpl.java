package com.CarSaleWebsite.Kolesa.Services;

import com.CarSaleWebsite.Kolesa.DTO.AjaxResponseBody;
import com.CarSaleWebsite.Kolesa.DTO.OrderForm;
import com.CarSaleWebsite.Kolesa.Models.Order;
import com.CarSaleWebsite.Kolesa.Repositories.*;
import com.CarSaleWebsite.Kolesa.Services.interfaces.ProductService;
import com.CarSaleWebsite.Kolesa.Services.interfaces.PurchaseService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final OrderProductServiceImpl orderProductService;
    private final ProductService productService;
    private final UsersRepository usersRepository;
    private final OrderServiceImpl orderService;
    private final OrderFoodRepository orderFoodRepository;
    private final OrderRepository orderRepository;
    private final DiningTablesRepository diningTablesRepository;
    private final DiningTableTrackRepository diningTableTrackRepository;

    public PurchaseServiceImpl(OrderProductServiceImpl orderProductService, ProductService productService, UsersRepository usersRepository, OrderServiceImpl orderService, OrderFoodRepository orderFoodRepository, OrderRepository orderRepository, DiningTablesRepository diningTablesRepository, DiningTableTrackRepository diningTableTrackRepository) {
        this.orderProductService = orderProductService;
        this.productService = productService;
        this.usersRepository = usersRepository;
        this.orderService = orderService;
        this.orderFoodRepository = orderFoodRepository;
        this.orderRepository = orderRepository;
        this.diningTablesRepository = diningTablesRepository;
        this.diningTableTrackRepository = diningTableTrackRepository;
    }

    @Override
    public AjaxResponseBody purchaseOrder(OrderForm form) {
        return null;
    }
}
