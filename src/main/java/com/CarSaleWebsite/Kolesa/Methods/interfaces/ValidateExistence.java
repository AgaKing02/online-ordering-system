package com.CarSaleWebsite.Kolesa.Methods.interfaces;

import com.CarSaleWebsite.Kolesa.DTO.OrderProductDto;
import com.CarSaleWebsite.Kolesa.Services.interfaces.ProductService;

import java.util.List;

public interface ValidateExistence {
     void validateExistence(List<OrderProductDto> orderProducts, ProductService productService);
}
