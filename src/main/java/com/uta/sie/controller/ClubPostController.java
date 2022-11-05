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

    @GetMapping
    public ResponseResult<List<ClubPost>> getAllPosts(Long clubId){
        return clubPostService.getAllPosts(clubId);
    }

    @PostMapping
    public ResponseResult<ClubPost> post(@RequestBody ClubPost clubPost){
        return clubPostService.post(clubPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseResult<ClubPost> deletePost(@PathVariable Long postId){
        return clubPostService.deletePost(postId);
    }
}
