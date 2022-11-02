package com.uta.sie.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubMembers;
import com.uta.sie.entity.User;
import com.uta.sie.mapper.ClubMembersMapper;
import com.uta.sie.mapper.UserMapper;
import com.uta.sie.service.ClubMembersService;

import lombok.AllArgsConstructor;

/**
 * @author Jadon
 */
@Service
@AllArgsConstructor
public class ClubMembersServiceImpl extends ServiceImpl<ClubMembersMapper, ClubMembers> implements ClubMembersService {
    private final UserMapper userMapper;
    private final ClubMembersMapper clubMembersMapper;
    @Override
    public ResponseResult<Page<User>> page(Long clubId, int page, int pageSize, String name) {
        // TODO
        return null;
    }
}
