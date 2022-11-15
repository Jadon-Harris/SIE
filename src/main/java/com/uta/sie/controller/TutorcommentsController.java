package com.uta.sie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uta.sie.common.R;
import com.uta.sie.entity.Tutorcomments;
import com.uta.sie.service.TutorcommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wangpeng
 */
@Slf4j
@RestController
@RequestMapping("/tutorcomments")
public class TutorcommentsController
{
    @Autowired
    TutorcommentsService tutorcommentsService;
    @GetMapping("/page")
    public R<Page> getById(Integer page, Integer pageSize,Long id)
    {
        //分页构造器
        Page<Tutorcomments> pagInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Tutorcomments> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Tutorcomments::getTName);
        queryWrapper.like(id!=null,Tutorcomments::getTId,id);
        tutorcommentsService.page(pagInfo,queryWrapper);

         return R.success(pagInfo);
    }
}

