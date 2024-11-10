package com.neusoft.elmboot.po.domain_plus.po;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "有效期内的赚取与消费的积分明细表")
public class EfficientCredit {
    @Schema(description = "表id")
    private Integer id;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "渠道id")
    private Integer channelId;

    @Schema(description = "类型id")
    private Integer typeId;

    @Schema(description = "交易涉及积分数量")
    private Integer credit;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "过期时间")
    private LocalDateTime expiredTime;

    @Schema(description = "是否过期")
    private Integer efficient;
}
