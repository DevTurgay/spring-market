package com.market.market.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class MarketResponseDto {
    Long id;
    String name;

    List<BranchResponseDto> branches;
}
