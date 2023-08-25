package com.market.market.services;

import com.market.market.dto.request.market.MarketRequestDto;
import com.market.market.dto.request.market.MarketUpdateDto;
import com.market.market.dto.response.MarketResponseDto;
import com.market.market.models.Market;

import java.util.List;

public interface MarketService {
    MarketResponseDto create(MarketRequestDto request);

    List<MarketResponseDto> findAll();

    void delete(Market market);

    MarketResponseDto update(Market market, MarketUpdateDto request);
}
