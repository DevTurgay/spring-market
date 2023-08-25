package com.market.market.dto.request.market;

import com.market.market.dto.request.BranchRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class MarketRequestDto {
    String name;

    List<BranchRequestDto> branches;
}
