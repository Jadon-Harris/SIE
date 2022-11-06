package com.uta.sie.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubMember;
import com.uta.sie.entity.User;

/**
 * @author Jadon
 */
public interface ClubMemberService extends IService<ClubMember> {

    ResponseResult<List<User>> getAllMembers(Long clubId, String name);

    ResponseResult<String> quitClub(Long userId);

    ResponseResult<String> joinClub(ClubMember clubMember);
}
