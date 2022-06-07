package com.CarSaleWebsite.Kolesa.Services.interfaces;

import com.CarSaleWebsite.Kolesa.DTO.AjaxResponseBody;
import com.CarSaleWebsite.Kolesa.DTO.OrderForm;
import com.CarSaleWebsite.Kolesa.Models.Order;

public interface PurchaseService {
    AjaxResponseBody purchaseOrder(OrderForm form);
}
