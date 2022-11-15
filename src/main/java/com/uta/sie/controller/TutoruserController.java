package com.uta.sie.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uta.sie.common.R;
import com.uta.sie.entity.Tutoruser;
import com.uta.sie.service.TutoruserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/tutoruser")
public class TutoruserController
{
    @Autowired
    TutoruserService tutoruserService;
    @PostMapping("/add")
    public R<String> add(@RequestBody JSONObject jsonObject)
    {
       String tID= jsonObject.getString("tID");
       long tID1=Long.parseLong(tID);
        String tName=jsonObject.getString("tName");
        String tPrices=jsonObject.getString("tPrices");
        double tPrices1=Double.parseDouble(tPrices);
        String tCategory=jsonObject.getString("tCategory");
        String tSchedule=jsonObject.getString("tSchedule");
        String tContents=jsonObject.getString("tContents");
       String tStatus=jsonObject.getString("tStatus");
       int tStatus1=Integer.parseInt(tStatus);
        String image=jsonObject.getString("image");
       if(tStatus.equals("0"))
        {
           return R.error("This tutor is not in progress!");
       }
        //获取当前用户的用户名
        String currentName= SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(currentName);
       LambdaQueryWrapper<Tutoruser> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(tName!=null,Tutoruser::getTName,tName);
        queryWrapper.eq(currentName!=null,Tutoruser::getTUser,currentName);
        long count = tutoruserService.count(queryWrapper);
        if(count!=0)
       {
           return R.error("You have added!");
       }
       Tutoruser tutoruser=new Tutoruser();
       tutoruser.setTId(tID1);
       tutoruser.setTName(tName);
       tutoruser.setImage(image);
       tutoruser.setTContents(tContents);
       tutoruser.setTPrices(tPrices1);
       tutoruser.setTSchedule(tSchedule);
       tutoruser.setTCategory(tCategory);
       tutoruser.setTStatus(tStatus1);




    tutoruser.setTUser(currentName);
    Boolean flag=tutoruserService.save(tutoruser);
    if(flag==true)
    {
        return R.success("add successfully！");
    }else {
        return R.error("add Error");
    }
    }
    @GetMapping("/page")
    public R<Page>getTutorUser(Integer page, Integer pageSize, String name)
    {
        Page<Tutoruser>pagInfo=new Page<>(page,pageSize);
        //条件构造器
        String currentName= SecurityContextHolder.getContext().getAuthentication().getName();
        LambdaQueryWrapper<Tutoruser> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Tutoruser::getTName);

        queryWrapper.eq(currentName!=null,Tutoruser::getTUser,currentName);
        tutoruserService.page(pagInfo,queryWrapper);
        return R.success(pagInfo);
    }
    @DeleteMapping("/delete")
    public R<String>deleteTutorUser(@RequestBody JSONObject jsonObject)
    {
        String id1 = jsonObject.getString("id");

        System.out.println(id1);
        Long id=Long.parseLong(id1);
        LambdaQueryWrapper<Tutoruser>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Tutoruser::getTId,id);
        boolean b = tutoruserService.remove(queryWrapper);
        if(b==true){
            return R.success("delete successfully");
        }else{
            return R.error("delete fail!");
        }
    }

}
