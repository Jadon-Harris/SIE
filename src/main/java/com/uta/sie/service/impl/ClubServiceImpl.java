package com.uta.sie.service.impl;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Club;
import com.uta.sie.entity.ClubMembers;
import com.uta.sie.mapper.ClubMapper;
import com.uta.sie.mapper.ClubMembersMapper;
import com.uta.sie.service.ClubService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jadon
 */
@Service
@AllArgsConstructor
@Slf4j
public class ClubServiceImpl extends ServiceImpl<ClubMapper, Club> implements ClubService {
    private final ClubMapper clubMapper;
    private final ClubMembersMapper clubMembersMapper;

    @Override
    public ResponseResult<Page<Club>> page(int page, int pageSize, String name) {
        final Page<Club> clubPage = new Page<>(page, pageSize);

        final LambdaQueryWrapper<Club> clubLambdaQueryWrapper = new LambdaQueryWrapper<>();
        clubLambdaQueryWrapper.like(StringUtils.hasLength(name),Club::getName,name);

        return new ResponseResult<>(HttpStatus.OK.value(), "page success.",clubMapper.selectPage(clubPage,clubLambdaQueryWrapper));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<Club> saveClub(Club club) {
        final LambdaQueryWrapper<Club> clubLambdaQueryWrapper = new LambdaQueryWrapper<>();
        clubLambdaQueryWrapper.eq(Club::getName,club.getName());
        final Club clubExisted = clubMapper.selectOne(clubLambdaQueryWrapper);

        if (!Objects.isNull(clubExisted)){
            return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), "There is already a club names "+club.getName(),null);
        }else {
            clubMapper.insert(club);
            ClubMembers clubMembers = new ClubMembers();
            clubMembers.setClubId(club.getId());
            clubMembers.setStudentId(club.getStudentId());
            clubMembersMapper.insert(clubMembers);
            return new ResponseResult<>(HttpStatus.OK.value(), "Set up the club success.",club);
        }
    }

}
