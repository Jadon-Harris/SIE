package com.uta.sie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uta.sie.common.R;
import com.uta.sie.entity.Tutor;
import com.uta.sie.service.TutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Wangpeng
 */
@Slf4j
@RestController
@RequestMapping("/tutor")
public class TutorController
{
    @Autowired
    private TutorService tutorService;

    @PostMapping
    public R<String> save(@RequestBody Tutor tutor)
    {
        tutorService.save(tutor);
        return R.success("Select tutor services successfully!");
    }

    @GetMapping("/page")
    public R<Page>page(Integer page, Integer pageSize, String name, String categoryName)
    {
        log.info("page:{}, pageSize:{}, name: {}, categoryName:{}",page, pageSize,name,categoryName);
        //分页构造器
        Page<Tutor>pagInfo=new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Tutor> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Tutor::getTName);
        queryWrapper.like(name!=null,Tutor::getTName,name);
        queryWrapper.like(categoryName!=null,Tutor::getTCategory,categoryName);
        tutorService.page(pagInfo,queryWrapper);
        return R.success(pagInfo);
    }


}
