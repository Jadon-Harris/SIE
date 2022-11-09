package com.uta.sie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubPost;
import com.uta.sie.entity.dto.ClubPostDto;
import com.uta.sie.service.ClubPostService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jadon
 */
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/club/post")
public class ClubPostController {
    private final ClubPostService clubPostService;

    /**
     * 获取某个俱乐部的所有post.
     * url: localhost:8080/club/post?clubId=xxxxxx
     * @param clubId club id
     * @return response.
     */
    @GetMapping
    public ResponseResult<List<ClubPostDto>> getAllPosts(Long clubId){
        return clubPostService.getAllPosts(clubId);
    }

    /**
     * 发布post
     * url: localhost:8080/club/post
     * body中加入ClubPost的json.
     * @param clubPost club post object.
     * @return response.
     */
    @PostMapping
    public ResponseResult<ClubPost> post(@RequestBody ClubPost clubPost){
        return clubPostService.post(clubPost);
    }

    /**
     * 删除post,发送delete请求
     * url: localhost:8080/club/post/xxxxxxx(club的id)
     * @param postId post id.
     * @return response
     */
    @DeleteMapping("/{postId}")
    public ResponseResult<ClubPost> deletePost(@PathVariable Long postId){
        return clubPostService.deletePost(postId);
    }
}
