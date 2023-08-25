package com.market.market.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchRequestDto {
    String name;
    Long marketId;
    List<AddressRequestDto> addresses;
}
