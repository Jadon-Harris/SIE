package com.uta.sie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubMember;
import com.uta.sie.entity.User;
import com.uta.sie.service.ClubMemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jadon
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/club/member")
public class ClubMemberController {
    private final ClubMemberService clubMemberService;


    /**
     * 根据clubId获取用户姓名中包含name的所用参加了该club的用户。
     * name可以为空
     * url: 127.0.0.1:8080/club/member/1588843026719801346?page=1&pageSize=5&name=ad  or 127.0.0.1:8080/club/member/1588843026719801346?page=1&pageSize=5
     *
     * @param clubId   club id.
     * @return page of res.
     */
    @GetMapping("/{clubId}")
    public ResponseResult<List<User>> getAllMembers(@PathVariable Long clubId,String name) {
        return clubMemberService.getAllMembers(clubId,name);
    }


    /**
     * 退出俱乐部.
     *
     * @param userId user id.
     * @return response.
     */
    @DeleteMapping("/{userId}")
    public ResponseResult<String> quitClub(@PathVariable Long userId) {
        return clubMemberService.quitClub(userId);
    }


    /**
     * join club
     * url:/user/member  post body中传入club member对象的json.
     *
     * @param clubMember club member object.
     * @return response.
     */
    @PostMapping
    public ResponseResult<String> joinClub(@RequestBody ClubMember clubMember) {
        return clubMemberService.joinClub(clubMember);
    }
}
