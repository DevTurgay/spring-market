package com.market.market.controllers;

import com.market.market.config.AppConfiguration;
import com.market.market.dto.request.market.MarketRequestDto;
import com.market.market.dto.request.market.MarketUpdateDto;
import com.market.market.dto.response.MarketResponseDto;
import com.market.market.models.Market;
import com.market.market.services.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/markets")
@RequiredArgsConstructor
public class MarketController {

    private final AppConfiguration appConfiguration;
    private final MarketService marketService;

    @GetMapping("")
    public List<MarketResponseDto> getMarkets()
    {
        return marketService.findAll();
    }

    @GetMapping("/{market}")
    public MarketResponseDto getMarket(@PathVariable Market market)
    {
        return appConfiguration.getMapper().map(market, MarketResponseDto.class);
    }

    @PostMapping("")
    public MarketResponseDto createMarket(@RequestBody MarketRequestDto request)
    {
        return marketService.create(request);
    }

    @PutMapping("/{market}")
    public MarketResponseDto updateMarket(@PathVariable Market market, @RequestBody MarketUpdateDto request)
    {
        return marketService.update(market, request);
    }

    @DeleteMapping("/{market}")
    public ResponseEntity<Object> deleteMarket(@PathVariable Market market)
    {
        marketService.delete(market);
        Map<String, String> map = new HashMap<String, String>();
        map.put("status","success");
        map.put("message","Market deleted successfully");
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
