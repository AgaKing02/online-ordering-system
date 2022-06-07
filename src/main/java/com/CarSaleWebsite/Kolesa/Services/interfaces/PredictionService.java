package com.CarSaleWebsite.Kolesa.Services.interfaces;

import com.CarSaleWebsite.Kolesa.Models.Order;

public interface PredictionService {
    Order setPredictedDate(Order order,Integer numOfOrdersBefore) throws Exception;
}
