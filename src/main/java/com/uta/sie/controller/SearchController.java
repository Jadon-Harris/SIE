package com.uta.sie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.dto.SearchResultDto;
import com.uta.sie.service.SearchService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jadon
 */
@RestController
@RequestMapping("/search")
@AllArgsConstructor
@Slf4j
public class SearchController {
    private final SearchService searchService;

    @GetMapping
    public ResponseResult<SearchResultDto> search(String name){
        return searchService.search(name);
    }
}
