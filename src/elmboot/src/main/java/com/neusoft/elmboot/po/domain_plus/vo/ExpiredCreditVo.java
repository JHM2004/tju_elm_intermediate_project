package com.neusoft.elmboot.po.domain_plus.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "过期积分明细")
public class ExpiredCreditVo {
    @Schema(description = "流水号")
    private Integer id;
    @Schema(description = "用户ID")
    private String userId;
    @Schema(description = "赚取或消费的渠道")
    private Integer channelId;
    @Schema(description = "积分类型")
    private Integer typeId;
    @Schema(description = "变动积分量")
    private Integer credit;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "过期时间")
    private LocalDateTime expiredTime;
    @Schema(description = "是否过期")
    private int efficient;
}
