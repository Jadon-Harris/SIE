package com.uta.sie.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wangpeng
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tutorcomments
{
    @JsonSerialize(using= ToStringSerializer.class)
long tId;
String tName;
String image;
String tComment;
}
