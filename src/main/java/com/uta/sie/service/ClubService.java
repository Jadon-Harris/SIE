package com.uta.sie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Club;

/**
 * @author Jadon
 */

public interface ClubService extends IService<Club> {

    ResponseResult<Page<Club>> page(int page, int pageSize, String name);

    ResponseResult<Club> saveClub(Club club);

}
