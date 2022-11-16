package com.uta.sie.service;

import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.dto.SearchResultDto;

/**
 * @author Jadon
 */
public interface SearchService {

    ResponseResult<SearchResultDto> search(String name);
}
