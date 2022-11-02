package com.uta.sie.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.entity.ClubPost;
import com.uta.sie.mapper.ClubPostMapper;
import com.uta.sie.service.ClubPostService;

/**
 * @author Jadon
 */
@Service
public class ClubPostServiceImpl extends ServiceImpl<ClubPostMapper, ClubPost> implements ClubPostService {
}
