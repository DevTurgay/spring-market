package com.market.market.services.impl;

import com.market.market.config.AppConfiguration;
import com.market.market.dto.request.BranchRequestDto;
import com.market.market.dto.response.BranchResponseDto;
import com.market.market.models.Address;
import com.market.market.models.Branch;
import com.market.market.models.Market;
import com.market.market.repositories.BranchRepository;
import com.market.market.repositories.MarketRepository;
import com.market.market.services.AddressService;
import com.market.market.services.BranchService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final MarketRepository marketRepository;
    private final AppConfiguration appConfiguration;
    private final AddressService addressService;
    @Override
    public void attachBranchesToMarket(Market market) {
        market.getBranches().forEach(branch -> {
            branch.setMarket(market);
            if(branch.getAddresses() != null){
                addressService.attachAddressesToBranch(branch);
            }
        });
    }

    @Override
    public List<BranchResponseDto> getAllBranches() {
        return branchRepository.findAll().stream()
            .map(branch -> appConfiguration.getMapper().map(branch, BranchResponseDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public BranchResponseDto create(BranchRequestDto request) {

        System.out.println(appConfiguration.getMapper().map(request, Branch.class));
        // ;;

//        Market market = marketRepository.findById(request.getMarketId()).orElseThrow(()->
//            new EntityNotFoundException("Market ID should be set and valid. Given id:" + request.getMarketId())
//        );
//        List<Address> addresses = List.of();
//        if(request.getAddresses() != null) {
//            addresses = request.getAddresses().stream().map(
//                    addressRequestDto -> appConfiguration.getMapper().map(addressRequestDto, Address.class)
//            ).collect(Collectors.toList());
//        }
//        Branch branch = Branch.builder()
//                .name(request.getName())
//                .market(market)
//                .addresses(addresses)
//                .build();
//
//        branch = branchRepository.save(branch);
//        return appConfiguration.getMapper().map(branch, BranchResponseDto.class);
        return null;
    }
}
