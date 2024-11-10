package com.neusoft.elmboot.po.domain_plus.po;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "钱包流水记录")
public class WalletLog {
    @Schema(description = "流水号")
    private Integer id;
    @Schema(description = "用户ID")
    private String userId;
    @Schema(description = "业务类型")
    private Integer targetType;
    @Schema(description = "对方ID")
    private String targetId;
    @Schema(description = "变动金额")
    private BigDecimal fee;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
