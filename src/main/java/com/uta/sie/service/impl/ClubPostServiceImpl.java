package com.uta.sie.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.ClubPost;
import com.uta.sie.entity.User;
import com.uta.sie.entity.dto.ClubPostDto;
import com.uta.sie.mapper.ClubPostMapper;
import com.uta.sie.mapper.UserMapper;
import com.uta.sie.service.ClubPostService;

import lombok.AllArgsConstructor;

/**
 * @author Jadon
 */
@Service
@AllArgsConstructor
public class ClubPostServiceImpl extends ServiceImpl<ClubPostMapper, ClubPost> implements ClubPostService {
    private final ClubPostMapper clubPostMapper;

    private final UserMapper userMapper;

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
    public ResponseResult<List<ClubPostDto>> getAllPosts(Long clubId) {
        final LambdaQueryWrapper<ClubPost> clubPostLambdaQueryWrapper = new LambdaQueryWrapper<>();
        clubPostLambdaQueryWrapper.eq(ClubPost::getClubId, clubId).orderByDesc(ClubPost::getId);

        final List<ClubPost> clubPosts = clubPostMapper.selectList(clubPostLambdaQueryWrapper);

        final List<ClubPostDto> clubPostDtoList = clubPosts.stream().map(clubPost -> {
            final User user = userMapper.selectById(clubPost.getStudentId());
            final ClubPostDto clubPostDto = new ClubPostDto();
            BeanUtils.copyProperties(clubPost, clubPostDto);
            clubPostDto.setStudentName(user.getName());
            return clubPostDto;
        }).collect(Collectors.toList());

        return new ResponseResult<>(HttpStatus.OK.value(), "Get all post success.", clubPostDtoList);
    }
}
