package com.uta.sie.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubPost;

/**
 * @author Jadon
 */
public interface ClubPostService extends IService<ClubPost> {
    ResponseResult<ClubPost> post(ClubPost clubPost);

    ResponseResult<ClubPost> deletePost(Long postId);

    ResponseResult<List<ClubPost>> getAllPosts(Long clubId);
}
