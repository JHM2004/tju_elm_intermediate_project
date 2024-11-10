package com.neusoft.elmboot.po.domain_plus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Component
@Schema(description = "金额消息DTO")
public class MessageMoneyDto implements Serializable {
    private static final long serialVersionUID = 1L; // 定义序列化ID

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "金额")
    private BigDecimal amount;

}
