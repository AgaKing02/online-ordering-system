package com.CarSaleWebsite.Kolesa.Services;

import com.CarSaleWebsite.Kolesa.Models.DiningTableTrack;
import com.CarSaleWebsite.Kolesa.Models.enums.OrderStatus;
import com.CarSaleWebsite.Kolesa.Repositories.DiningTableTrackRepository;
import com.CarSaleWebsite.Kolesa.Services.interfaces.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private DiningTableTrackRepository repository;

    @Override
    public List<DiningTableTrack> getReadyOrders() {
        return repository.findAllByOrderidStatus(OrderStatus.DONE.name());
    }
}
