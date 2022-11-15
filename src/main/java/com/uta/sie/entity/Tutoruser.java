package com.uta.sie.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wangpeng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tutoruser
{
    @JsonSerialize(using= ToStringSerializer.class)
    long tId; //教程id
    int tStatus;  //状态
    String tSchedule; //计划
    String tName;  //课程名
    double tPrices; //价格
    String tContents; //内容
    String image;  //图片
    String tCategory; //种类
    String tUser;//用户
}
