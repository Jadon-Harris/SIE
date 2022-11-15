package com.uta.sie.entity.dto;

import com.uta.sie.entity.Merchandise;
import com.uta.sie.entity.User;
import lombok.Data;


@Data
public class MerchandiseDto extends Merchandise {
    private User buyers;
}
