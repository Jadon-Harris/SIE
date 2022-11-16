package com.uta.sie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.Club;
import com.uta.sie.entity.dto.ClubNameAndDescriptionDto;
import com.uta.sie.service.ClubService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jadon
 */
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/club")
public class ClubController {
    private final ClubService clubService;

    /**
     * 查询分页club.
     * url: /page?page=1&pageSize=5&name=shooting 或者 /page?page=1&pageSize=5
     * @param page page.
     * @param pageSize pageSize.
     * @param name club name 用于模糊搜索。
     * @return response.
     */
    @GetMapping("/page")
    public ResponseResult<Page<Club>> page(int page, int pageSize, String name) {
        return clubService.page(page, pageSize, name);
    }


    /**
     * 新建club.
     * @param club club object.
     * @return response.
     */
    @PostMapping
    public ResponseResult<Club> save(@RequestBody Club club) {
        return clubService.saveClub(club);
    }

    /**
     * 更改club.
     * @param club club object
     * @return response.
     */
    @PutMapping
    public ResponseResult<Club> update(@RequestBody Club club){
        clubService.updateById(club);
        return new ResponseResult<>(HttpStatus.OK.value(), "Update the club success.", club);
    }

    @GetMapping("/{userId}")
    public ResponseResult<List<Club>> getClubs(@PathVariable Long userId){
        return clubService.getClubs(userId);
    }

    @GetMapping("/nameAndDescription")
    public ResponseResult<List<ClubNameAndDescriptionDto>> getAllClubNameAndDescription(){
        return clubService.getAllClubNameAndDescription();
    }
}
