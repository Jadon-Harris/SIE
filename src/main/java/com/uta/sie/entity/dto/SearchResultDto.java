package com.uta.sie.entity.dto;

import java.util.List;

import com.uta.sie.entity.Club;
import com.uta.sie.entity.Merchandise;
import com.uta.sie.entity.Tutor;

import lombok.Data;

/**
 * @author Jadon
 */
@Data
public class SearchResultDto {
    private List<Club> clubs;
    private List<Merchandise> merchandises;
    private List<Tutor> tutors;

    private Integer clubCount;
    private Integer merchandiseCount;
    private Integer tutorCount;

    private Integer allCount;
}
