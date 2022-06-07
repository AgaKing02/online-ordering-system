package com.CarSaleWebsite.Kolesa.Services;

import com.CarSaleWebsite.Kolesa.Learning.PredictingModel;
import com.CarSaleWebsite.Kolesa.Models.Order;
import com.CarSaleWebsite.Kolesa.Models.OrderFood;
import com.CarSaleWebsite.Kolesa.Services.interfaces.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {
    @Autowired
    private PredictingModel predictingModel;
    private final Integer numOfCooks = 3;

    @Override
    public Order setPredictedDate(Order order, Integer numOfOrdersBefore) throws Exception {
        List<Integer> predictions = new ArrayList<>();
        for (OrderFood orderFood : order.getOrderProducts()) {
            predictions.add(predictingModel.predictFood(orderFood, numOfOrdersBefore, numOfCooks));
        }
        Integer max = Collections.max(predictions);
        order.setPredictedDate(order.getPurchaseDate().plusSeconds(max));
        return order;
    }

}
