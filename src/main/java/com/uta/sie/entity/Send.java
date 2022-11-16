package com.uta.sie.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wang peng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Send
{
    String sendUser; //发件人
    String sendEmail; //发送邮件
    String sendContent; //发送内容
    String sendSubject; //发送主题
    String sendTime;  //发送时间
    Integer sendState;   //状态
    Long sendId;  //发送id，唯一标识
    String receiveUser;//收件人
    String receiveName;//收件人用户名
}
