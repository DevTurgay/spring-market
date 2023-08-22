package com.market.market.services.impl;

import com.market.market.config.AppConfiguration;
import com.market.market.controllers.dto.request.MarketRequestDto;
import com.market.market.models.Market;
import com.market.market.repositories.BranchRepository;
import com.market.market.repositories.MarketRepository;
import com.market.market.services.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.internal.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MarketServiceImpl implements MarketService {
    private final AppConfiguration appConfiguration;
    private final MarketRepository marketRepository;
    private final BranchRepository branchRepository;

    public Market create(MarketRequestDto request) {
        Market market = marketRepository.save(
            appConfiguration.getMapper().map(request, Market.class)
        );
        if(request.getBranches() != null){
            market.getBranches().forEach(branch -> {
                branch.setMarket(market);
                branchRepository.save(branch);
            });
        }
        return market;
    }
}
