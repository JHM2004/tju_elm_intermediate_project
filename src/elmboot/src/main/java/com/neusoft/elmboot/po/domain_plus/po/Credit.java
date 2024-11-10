package com.neusoft.elmboot.po.domain_plus.po;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户总积分表")
public class Credit {
    @Schema(description = "总积分表编号id")
    private Integer id;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "总积分数")
    private Integer credit_all;
}
