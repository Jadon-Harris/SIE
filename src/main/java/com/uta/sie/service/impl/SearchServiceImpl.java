package com.uta.sie.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Club;
import com.uta.sie.entity.Merchandise;
import com.uta.sie.entity.Tutor;
import com.uta.sie.entity.dto.SearchResultDto;
import com.uta.sie.mapper.ClubMapper;
import com.uta.sie.mapper.MerchandiseMapper;
import com.uta.sie.mapper.TutorMapper;
import com.uta.sie.service.SearchService;

import lombok.AllArgsConstructor;

/**
 * @author Jadon
 */
@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final TutorMapper tutorMapper;
    private final ClubMapper clubMapper;
    private final MerchandiseMapper merchandiseMapper;
    @Override
    public ResponseResult<SearchResultDto> search(String name) {
        final SearchResultDto searchResultDto = new SearchResultDto();

        final LambdaQueryWrapper<Tutor> tutorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        final LambdaQueryWrapper<Club> clubLambdaQueryWrapper = new LambdaQueryWrapper<>();
        final LambdaQueryWrapper<Merchandise> merchandiseLambdaQueryWrapper = new LambdaQueryWrapper<>();

        tutorLambdaQueryWrapper.like(StringUtils.hasLength(name),Tutor::getTName,name);
        clubLambdaQueryWrapper.like(StringUtils.hasLength(name),Club::getName,name);
        merchandiseLambdaQueryWrapper.like(StringUtils.hasLength(name),Merchandise::getName,name);

        final List<Tutor> tutors = tutorMapper.selectList(tutorLambdaQueryWrapper);
        final List<Club> clubs = clubMapper.selectList(clubLambdaQueryWrapper);
        final List<Merchandise> merchandises = merchandiseMapper.selectList(merchandiseLambdaQueryWrapper);

        searchResultDto.setTutors(tutors);
        searchResultDto.setClubs(clubs);
        searchResultDto.setMerchandises(merchandises);

        return new ResponseResult<>(HttpStatus.OK.value(),"search success",searchResultDto);
    }
}
