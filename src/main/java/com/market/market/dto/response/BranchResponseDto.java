package com.market.market.dto.response;

import com.market.market.models.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchResponseDto {
    Long id;
    String name;

    List<AddressResponseDto> addresses;
}
