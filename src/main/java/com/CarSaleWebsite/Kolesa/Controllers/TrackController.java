package com.CarSaleWebsite.Kolesa.Controllers;

import com.CarSaleWebsite.Kolesa.Models.DiningTableTrack;
import com.CarSaleWebsite.Kolesa.Models.enums.OrderStatus;
import com.CarSaleWebsite.Kolesa.Repositories.DiningTableTrackRepository;
import com.CarSaleWebsite.Kolesa.Services.interfaces.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/table")
public class TrackController {
    @Autowired
    private TrackService trackService;


    @GetMapping("/track")
    public String getDoneOrders(Model model) {
        List<DiningTableTrack> diningTableTracks = trackService.getReadyOrders();
        model.addAttribute("tables", diningTableTracks);
        return "table-track-page";
    }
}
