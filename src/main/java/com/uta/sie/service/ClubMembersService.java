package com.uta.sie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubMembers;
import com.uta.sie.entity.User;

/**
 * @author Jadon
 */
public interface ClubMembersService extends IService<ClubMembers> {

    ResponseResult<Page<User>> page(Long clubId, int page, int pageSize, String name);
}
