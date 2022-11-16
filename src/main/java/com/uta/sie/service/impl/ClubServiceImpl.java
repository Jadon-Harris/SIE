package com.uta.sie.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Club;
import com.uta.sie.entity.ClubMember;
import com.uta.sie.entity.dto.ClubNameAndDescriptionDto;
import com.uta.sie.mapper.ClubMapper;
import com.uta.sie.mapper.ClubMemberMapper;
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
    private final ClubMemberMapper clubMemberMapper;

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
            ClubMember clubMember = new ClubMember();
            clubMember.setClubId(club.getId());
            clubMember.setStudentId(club.getStudentId());
            clubMemberMapper.insert(clubMember);
            return new ResponseResult<>(HttpStatus.OK.value(), "Set up the club success.",club);
        }
    }

    @Override
    public ResponseResult<List<Club>> getClubs(Long userId) {
        final LambdaQueryWrapper<ClubMember> clubMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        clubMemberLambdaQueryWrapper.eq(ClubMember::getStudentId,userId);
        final List<ClubMember> clubMembers = clubMemberMapper.selectList(clubMemberLambdaQueryWrapper);
        final List<Club> clubs = clubMapper.selectBatchIds(clubMembers.stream().map(ClubMember::getClubId).collect(Collectors.toList()));
        return new ResponseResult<>(HttpStatus.OK.value(),"",clubs);
    }

    @Override
    public ResponseResult<List<ClubNameAndDescriptionDto>> getAllClubNameAndDescription() {
        final List<Club> clubs = clubMapper.selectList(null);
        final List<ClubNameAndDescriptionDto> clubNameAndDescriptionDtos = clubs.stream().map(club -> {
            final ClubNameAndDescriptionDto clubNameAndDescriptionDto = new ClubNameAndDescriptionDto();
            clubNameAndDescriptionDto.setValue(club.getName());
            clubNameAndDescriptionDto.setDescription(club.getDescription());
            return clubNameAndDescriptionDto;
        }).collect(Collectors.toList());
        return new ResponseResult<>(HttpStatus.OK.value(), null,clubNameAndDescriptionDtos);
    }
}
