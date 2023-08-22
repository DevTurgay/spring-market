package com.market.market.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    public ModelMapper getMapper()
    {
        return new ModelMapper();
    }
}
