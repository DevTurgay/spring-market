package com.market.market.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MarketDto {
    Long id;
    String name;

}
