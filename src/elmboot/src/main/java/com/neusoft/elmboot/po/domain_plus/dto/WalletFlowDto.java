package com.neusoft.elmboot.po.domain_plus.dto;

import com.neusoft.elmboot.po.domain_plus.po.EfficientCredit;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Schema(description = "钱包流水")
public class WalletFlowDto{

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "金额")
    private BigDecimal amount;

    @Schema(description = "对方ID")
    private String targetId;
}
