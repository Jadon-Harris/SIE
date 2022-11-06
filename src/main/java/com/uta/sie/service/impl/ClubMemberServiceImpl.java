package com.uta.sie.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubMember;
import com.uta.sie.entity.User;
import com.uta.sie.mapper.ClubMemberMapper;
import com.uta.sie.mapper.UserMapper;
import com.uta.sie.service.ClubMemberService;

import lombok.AllArgsConstructor;

/**
 * @author Jadon
 */
@Service
@AllArgsConstructor
public class ClubMemberServiceImpl extends ServiceImpl<ClubMemberMapper, ClubMember> implements ClubMemberService {
    private final UserMapper userMapper;
    private final ClubMemberMapper clubMemberMapper;

    @Override
    public ResponseResult<Page<User>> page(Long clubId, int page, int pageSize, String name) {
        // step1: 从club_member表中获取当前俱乐部所有成员的id。
        final Page<ClubMember> clubMemberPage = new Page<>(page, pageSize);
        final LambdaQueryWrapper<ClubMember> clubMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        clubMemberLambdaQueryWrapper.eq(ClubMember::getClubId, clubId);
        final List<ClubMember> clubMemberList = clubMemberMapper.selectPage(clubMemberPage, clubMemberLambdaQueryWrapper).getRecords();

        // step2: init user page to return.
        final Page<User> userPage = new Page<>(page, pageSize);

        // step3: 从user表中查询user详细信息。
        final List<User> clubMembers = clubMemberList.stream().map(clubMember -> {
            final LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getId, clubMember.getStudentId());
            userLambdaQueryWrapper.like(StringUtils.hasLength(name), User::getName, name);
            return userMapper.selectOne(userLambdaQueryWrapper);
        }).collect(Collectors.toList());

        // step4: 将user存入user page的records中
        userPage.setRecords(clubMembers);

        return new ResponseResult<>(HttpStatus.OK.value(), "Search success", userPage);
    }

    @Override
    public ResponseResult<String> quitClub(Long userId) {
        clubMemberMapper.deleteById(userId);
        return new ResponseResult<>(HttpStatus.OK.value(), "Quit club success", null);
    }

    @Override
    public ResponseResult<String> joinClub(ClubMember clubMember) {
        final LambdaQueryWrapper<ClubMember> clubMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        clubMemberLambdaQueryWrapper.eq(ClubMember::getClubId, clubMember.getClubId()).eq(ClubMember::getStudentId, clubMember.getStudentId());
        final ClubMember clubMemberExisted = clubMemberMapper.selectOne(clubMemberLambdaQueryWrapper);
        if (!Objects.isNull(clubMemberExisted)) {
            clubMemberMapper.insert(clubMember);
            return new ResponseResult<>(HttpStatus.OK.value(), "Join club success", null);
        } else {
            return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), "You have already joined this club.", null);
        }
    }
}
