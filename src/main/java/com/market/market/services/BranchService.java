package com.market.market.services;

import com.market.market.dto.request.BranchRequestDto;
import com.market.market.dto.response.BranchResponseDto;
import com.market.market.models.Branch;
import com.market.market.models.Market;

import java.util.List;

public interface BranchService {

    void attachBranchesToMarket(Market market);

    List<BranchResponseDto> getAllBranches();

    BranchResponseDto create(BranchRequestDto request);
}
