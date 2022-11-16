package com.uta.sie.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uta.sie.common.R;
import com.uta.sie.entity.Send;
import com.uta.sie.service.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/send")
public class SendController
{
    @Autowired
    SendService sendservice;

    //对应发送邮件（草稿箱）
    @PostMapping("/add")
    public R<String> add(@RequestBody JSONObject jsonObject)
    {
//        String id=jsonObject.getString("sendId");
//        Long sendId=Long.parseLong(id);
        String sendUser=jsonObject.getString("sendUser");
        String sendContent=jsonObject.getString("sendContent");
        String sendSubject=jsonObject.getString("sendSubject");
        String sendTime=jsonObject.getString("sendTime");
        String state=jsonObject.getString("sendState");
        Integer sendState=Integer.parseInt(state);
        String sendEmail=jsonObject.getString("sendEmail");
        String receiveUser=jsonObject.getString("receiveUser");
        String receiveName=jsonObject.getString("receiveName");

        Send send=new Send();
        send.setSendUser(sendUser);
        send.setSendEmail(sendEmail);
        send.setSendContent(sendContent);
        send.setSendSubject(sendSubject);
        send.setSendTime(sendTime);
        send.setSendState(sendState);
        send.setReceiveUser(receiveUser);
        send.setReceiveName(receiveName);
        boolean flag=sendservice.save(send);
        if(flag)
        {
            return R.success("send success");
        }else {
            return R.error("send error");
        }
    }
    //查看某一具体的已发送（或草稿箱）内容，根据id唯一标识
    @GetMapping("/{sendId}")
    public R<Send>getById(@PathVariable String sendId)
    {
     log.info("根据id查询已发送或草稿箱");
     Long sendId1=Long.parseLong(sendId);
     Send send=sendservice.getById(sendId1);
     if(send!=null)
     {
         return R.success(send);
     }
     else {
         return R.error("view error");
     }
    }
    //查询所有的已发送的内容
    @GetMapping("/view")
    public R<Page>view(Integer page,Integer pageSize,String sendUser)
    {
        log.info("查询已发送的内容");
        log.info("page:{},pageSize:{}",page,pageSize);
        Page<Send>pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Send> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Send::getSendTime);
        queryWrapper.eq(Send::getSendState,1);//状态标志位为1
        queryWrapper.eq(Send::getSendUser,sendUser);
        sendservice.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
    //查看草稿箱中的内容
    @GetMapping("/view1")
    public R<Page>view1(Integer page,Integer pageSize,String sendUser)
    {
        log.info("查询草稿箱的内容");
        log.info("page:{},pageSize:{}",page,pageSize);
        Page<Send>pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Send>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Send::getSendTime);
        queryWrapper.eq(Send::getSendState,0);//状态标志位0
        queryWrapper.eq(Send::getSendUser,sendUser);
        sendservice.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
    @GetMapping("/view2")
    public R<Page>view2(Integer page,Integer pageSize)
    {
        log.info("查询删除箱的内容");
        log.info("page:{},pageSize:{}",page,pageSize);
        Page<Send>pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Send>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Send::getSendTime);
        queryWrapper.eq(Send::getSendState,3);//状态标志位0
        sendservice.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    //删除已发送或者草稿箱的内容,将标志位改为3
    @DeleteMapping("/delete")
    public R<String>delete(@RequestBody JSONObject jsonObject)
    {
        String id=jsonObject.getString("sendId");
        Long sendID=Long.parseLong(id);
        LambdaQueryWrapper<Send>queryWrapper=new LambdaQueryWrapper<>();

        queryWrapper.eq(sendID!=null,Send::getSendId,sendID);
        Send one = sendservice.getOne(queryWrapper);
        one.setSendState(3);
        boolean flag = sendservice.updateById(one);
        if(flag==true)
        {
            return R.success("delete success");
        }else {
            return R.error("delete error");
        }
    }
    //查看自己收到的所有邮件
    @GetMapping("/select")
    public R<Page>select(Integer page,Integer pageSize,String receiveName)
    {
        log.info("查看自己收到的所有邮件");
        log.info("page:{},pageSize:{}",page,pageSize);
        Page<Send>pageInfo=new Page<>();
        LambdaQueryWrapper<Send>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Send::getSendState,1);
        queryWrapper.eq(Send::getReceiveName,receiveName);
        sendservice.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    //批量删除，根据邮件id删,将状态置位3
    @PostMapping("/delete1")
    public R<String>delete1(@RequestBody Map<String,Object> map)
    {
        List<String> ids = null;
        for(String key : map.keySet()) {
            ids = (List<String>) map.get(key);
        }
       // List<Long>ids1=new ArrayList<>();
        for(int i=0;i<ids.size();i++)
        {
         //   ids1.add(Long.parseLong(ids.get(i)));
            LambdaUpdateWrapper<Send> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.set(Send::getSendState,3);
            lambdaUpdateWrapper.eq(Send::getSendId,Long.parseLong(ids.get(i)));
            sendservice.update(lambdaUpdateWrapper);

        }
       return R.success("batch delete success");
//        queryWrapper.in(Send::getSendId,ids1);
//        boolean flag=sendservice.remove(queryWrapper);
//        if(flag==true)
//        {
//            return R.success("delete success");
//        }else {
//            return R.error("delete error");
//        }
    }

    //批量增加，发送多个邮件
    @PostMapping("/add1")
    public R<String>add1(@RequestBody JSONObject jsonObject,@RequestParam List<String>receiveUsers,@RequestParam List<String>receiveNames)
    {
        String sendUser=jsonObject.getString("sendUser");
        String sendContent=jsonObject.getString("sendContent");
        String sendSubject=jsonObject.getString("sendSubject");
        String sendTime=jsonObject.getString("sendTime");
        String state=jsonObject.getString("sendState");
        Integer sendState=Integer.parseInt(state);
        String sendEmail=jsonObject.getString("sendEmail");
       // List<Long>ids1=new ArrayList<>();

        int len=receiveUsers.size();
        for(int i=0;i<len;i++)
        {

            String receiveUser=receiveUsers.get(i);
            String receiveName=receiveNames.get(i);
            Send send=new Send();

            send.setSendUser(sendUser);
            send.setSendEmail(sendEmail);
            send.setSendContent(sendContent);
            send.setSendSubject(sendSubject);
            send.setSendTime(sendTime);
            send.setSendState(sendState);
            send.setReceiveUser(receiveUser);
            send.setReceiveName(receiveName);
        }
        return R.success("Batch Add success");
    }

    //统计用户已发送的个数
   @GetMapping("/count")
    public R<Integer>count(String sendUser)
    {
        LambdaQueryWrapper<Send>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Send::getSendUser,sendUser);
        queryWrapper.eq(Send::getSendState,1); //已发送状态为1
        long count = sendservice.count(queryWrapper);
        Integer count1=(int)count;
        return R.success(count1);
    }
    //统计草稿箱的个数
    @GetMapping("/count1")
    public R<Integer>count1(String sendUser)
    {
        LambdaQueryWrapper<Send>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Send::getSendUser,sendUser);
        queryWrapper.eq(Send::getSendState,0); //草稿箱状态为0
        long count = sendservice.count(queryWrapper);
        Integer count1=(int)count;
        return R.success(count1);

    }
  //统计接收邮件的个数
    @GetMapping("/count2")
    public R<Integer>count2(String receiveName)
    {
        LambdaQueryWrapper<Send>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Send::getReceiveName,receiveName);
        queryWrapper.eq(Send::getSendState,1);
        long count=sendservice.count(queryWrapper);
        Integer count2=(int)count;
        return R.success(count2);
    }
   //统计删除的个数
    @GetMapping("/count3")
    public R<Integer>count3()
    {
        LambdaQueryWrapper<Send>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Send::getSendState,3);
        long cont=sendservice.count(queryWrapper);
        Integer count3=(int)cont;
        return R.success(count3);
    }


}
