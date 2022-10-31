package com.uta.sie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uta.sie.entity.User;

/**
 * @author Jadon
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
