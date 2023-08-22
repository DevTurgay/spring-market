package com.market.market.controllers.dto.request;

import com.market.market.models.Branch;
import lombok.Data;

import java.util.List;

@Data
public class MarketRequestDto {
    String name;

    List<BranchRequestDto> branches;
}
