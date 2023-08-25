package com.market.market.exceptions.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class CustomErrorResponse {
    String status;
    String message;
}
