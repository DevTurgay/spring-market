package com.market.market.services.impl;

import com.market.market.config.AppConfiguration;
import com.market.market.dto.request.market.MarketRequestDto;
import com.market.market.dto.request.market.MarketUpdateDto;
import com.market.market.dto.response.MarketResponseDto;
import com.market.market.models.Market;
import com.market.market.repositories.MarketRepository;
import com.market.market.services.BranchService;
import com.market.market.services.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MarketServiceImpl implements MarketService {
    private final AppConfiguration appConfiguration;
    private final MarketRepository marketRepository;
    private final BranchService branchService;

    public MarketResponseDto create(MarketRequestDto request) {
        Market market = appConfiguration.getMapper().map(request, Market.class);
        if(market.getBranches() != null){
            branchService.attachBranchesToMarket(market);
        }

        return appConfiguration.getMapper().map(marketRepository.save(market),MarketResponseDto.class);
    }

    @Override
    public List<MarketResponseDto> findAll() {
        List<Market> markets = marketRepository.findAll();
        return markets.stream()
                .map(market -> appConfiguration.getMapper().map(market, MarketResponseDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Market market) {
        marketRepository.delete(market);
    }

    @Override
    public MarketResponseDto update(Market market, MarketUpdateDto request) {
        market.setName(request.getName());
        return appConfiguration.getMapper().map(marketRepository.save(market),MarketResponseDto.class);
    }


}
