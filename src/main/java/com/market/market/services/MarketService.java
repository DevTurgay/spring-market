package com.market.market.services;

import com.market.market.controllers.dto.request.MarketRequestDto;
import com.market.market.models.Market;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface MarketService {
    public Market create(MarketRequestDto request);
}
