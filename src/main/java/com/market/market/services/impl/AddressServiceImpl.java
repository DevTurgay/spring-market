package com.market.market.services.impl;

import com.market.market.models.Branch;
import com.market.market.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public void attachAddressesToBranch(Branch branch) {
        branch.getAddresses().forEach(address -> {
            address.setBranches(List.of(branch));
        });
    }
}
