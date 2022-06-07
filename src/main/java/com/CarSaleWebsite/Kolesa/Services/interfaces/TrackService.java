package com.CarSaleWebsite.Kolesa.Services.interfaces;

import com.CarSaleWebsite.Kolesa.Models.DiningTableTrack;

import java.util.List;

public interface TrackService {
    List<DiningTableTrack> getReadyOrders();
}
