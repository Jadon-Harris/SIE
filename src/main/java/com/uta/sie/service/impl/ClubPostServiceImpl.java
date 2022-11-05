package com.uta.sie.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubPost;
import com.uta.sie.mapper.ClubPostMapper;
import com.uta.sie.service.ClubPostService;

import lombok.AllArgsConstructor;

/**
 * @author Jadon
 */
@Service
@AllArgsConstructor
public class ClubPostServiceImpl extends ServiceImpl<ClubPostMapper, ClubPost> implements ClubPostService {
    private final ClubPostMapper clubPostMapper;

    @Override
    public ResponseResult<ClubPost> post(ClubPost clubPost) {
        clubPostMapper.insert(clubPost);
        return new ResponseResult<>(HttpStatus.OK.value(), "Post success", clubPost);
    }

    @Override
    public ResponseResult<ClubPost> deletePost(Long postId) {
        clubPostMapper.deleteById(postId);
        return new ResponseResult<>(HttpStatus.OK.value(), "delete post success", null);
    }

    @Override
    public ResponseResult<List<ClubPost>> getAllPosts(Long clubId) {
        final LambdaQueryWrapper<ClubPost> clubPostLambdaQueryWrapper = new LambdaQueryWrapper<>();
        clubPostLambdaQueryWrapper.eq(ClubPost::getClubId,clubId).orderByDesc(ClubPost::getId);

        final List<ClubPost> clubPosts = clubPostMapper.selectList(clubPostLambdaQueryWrapper);

        return new ResponseResult<>(HttpStatus.OK.value(), "Get all post success.",clubPosts);
    }
}
