package com.uta.sie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.User;
import com.uta.sie.service.ClubMembersService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jadon
 */
@Slf4j
@RestController
@RequestMapping("/club/member")
@AllArgsConstructor
public class ClubMemberController {
    private final ClubMembersService clubMembersService;


    @GetMapping("/{clubId}")
    public ResponseResult<Page<User>> page(@PathVariable Long clubId, int page, int pageSize, String name) {
        return clubMembersService.page(clubId,page, pageSize, name);
    }
}
