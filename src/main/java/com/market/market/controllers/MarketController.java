package com.market.market.controllers;

import com.market.market.config.AppConfiguration;
import com.market.market.controllers.dto.request.MarketRequestDto;
import com.market.market.models.Market;
import com.market.market.services.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/markets")
@RequiredArgsConstructor
public class MarketController {

    private final AppConfiguration appConfiguration;
    private final MarketService marketService;

    @GetMapping("")
    public void getMarkets()
    {

    }

    @PostMapping("")
    public Market createMarket(@RequestBody MarketRequestDto request)
    {
        return marketService.create(request);
    }
}
