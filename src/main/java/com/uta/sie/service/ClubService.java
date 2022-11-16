package com.uta.sie.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Club;
import com.uta.sie.entity.dto.ClubNameAndDescriptionDto;

/**
 * @author Jadon
 */

public interface ClubService extends IService<Club> {

    ResponseResult<Page<Club>> page(int page, int pageSize, String name);

    ResponseResult<Club> saveClub(Club club);

    ResponseResult<List<Club>> getClubs(Long userId);

    ResponseResult<List<ClubNameAndDescriptionDto>> getAllClubNameAndDescription();
}
