package com.market.market.controllers;

import com.market.market.config.AppConfiguration;
import com.market.market.dto.request.BranchRequestDto;
import com.market.market.dto.response.BranchResponseDto;
import com.market.market.models.Branch;
import com.market.market.services.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
@RequiredArgsConstructor
public class BranchController {

    private final AppConfiguration appConfiguration;
    private final BranchService branchService;

    @GetMapping
    public List<BranchResponseDto> getBranches()
    {
        return branchService.getAllBranches();
    }

    @GetMapping("/{branch}")
    public BranchResponseDto getBranch(@PathVariable Branch branch)
    {
        return appConfiguration.getMapper().map(branch, BranchResponseDto.class);
    }

    @PostMapping
    public BranchResponseDto createBranch(@RequestBody BranchRequestDto request)
    {
        return branchService.create(request);
    }
}
