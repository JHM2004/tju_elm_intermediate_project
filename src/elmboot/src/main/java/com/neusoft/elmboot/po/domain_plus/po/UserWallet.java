package com.neusoft.elmboot.po.domain_plus.po;

import com.neusoft.elmboot.mapper.plus.VirtualWalletMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "用户钱包")
@Component
public class UserWallet {

    @Autowired
    private VirtualWalletMapper virtualWalletMapper;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "余额")
    private BigDecimal balance;

    @Schema(description = "是否冻结")
    private String freeze;

    @Schema(description = "上次更新时间")
    private LocalDateTime updateLast;

    public void unFreeze(){
        this.setFreeze("1");
    }
}
