package com.neusoft.elmboot.controller.plus;

import com.neusoft.elmboot.mapper.plus.CreditMapper;
import com.neusoft.elmboot.po.domain_plus.dto.WalletFlowDto;
import com.neusoft.elmboot.po.domain_plus.vo.WalletFlowVo;
import com.neusoft.elmboot.service.plus.VirtualWalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plus/VirtualWalletController")
@CrossOrigin
@Tag(name = "虚拟钱包controller")
public class VirtualWalletController {

    @Autowired
    private VirtualWalletService virtualWalletService;

    @Autowired
    private CreditMapper creditMapper;

    @GetMapping("/addWalletById")
    @Operation(summary = "创建虚拟钱包")
    public int addWalletById(@RequestParam("userId") String userId){
        return virtualWalletService.addWalletById(userId);
    }

    @GetMapping("/getWhetherEnabledById")
    @Operation(summary = "用户是否开启了虚拟钱包功能")
    public int getWhetherEnabledById(@RequestParam("userId") String userId){
        return virtualWalletService.getWhetherEnabledById(userId);
    }

    @PostMapping("/rechargeById")
    @Operation(summary = "充值功能")
    @CachePut(cacheNames = "getCreditById", key = "#walletFlowDto.getUserId()")
    public int rechargeById(@RequestBody WalletFlowDto walletFlowDto){
        virtualWalletService.rechargeById(walletFlowDto);
        return creditMapper.getCreditAllById(walletFlowDto.getUserId());
    }

    @PostMapping("/withdrawById")
    @Operation(summary = "提现功能")
    public BigDecimal withdrawById(@RequestBody WalletFlowDto walletFlowDto){
        BigDecimal result = BigDecimal.valueOf(0);
        try {
            result = virtualWalletService.withdrawById(walletFlowDto);
        } catch (Exception e) {
            return BigDecimal.valueOf(0);
        }
        return result;
    }

    @PostMapping("/pay")
    @Operation(summary = "支付/转账功能")
    @CachePut(cacheNames = "getCreditById", key = "#userId")
    public int pay(@RequestBody WalletFlowDto walletFlowDto){
        try {
            virtualWalletService.pay(walletFlowDto);
        } catch (Exception e) {
            return 0;
        }
        return creditMapper.getCreditAllById(walletFlowDto.getUserId());
    }

    @GetMapping("/getBalanceById")
    @Operation(summary = "查询余额功能")
    public BigDecimal getBalanceById(@RequestParam String userId){
        return virtualWalletService.getBalanceById(userId);
    }

    @GetMapping("/listWalletLogById")
    @Operation(summary = "查询历史交易（流水）")
    public List<WalletFlowVo> listWalletLogById(@RequestParam String userId){
        return virtualWalletService.listWalletLogById(userId);
    }

    @GetMapping("/listWalletLogIncomeById")
    @Operation(summary = "查询历史收入（流水）")
    public List<WalletFlowVo> listWalletLogIncomeById(@RequestParam String userId){
        return virtualWalletService.listWalletLogIncomeById(userId);
    }

    @GetMapping("/listWalletLogOutcomeById")
    @Operation(summary = "查询历史支出（流水）")
    public List<WalletFlowVo> listWalletLogOutcomeById(@RequestParam String userId){
        return virtualWalletService.listWalletLogOutcomeById(userId);
    }

    @GetMapping("/getFreeze")
    @Operation(summary = "查询账号是否冻结")
    public int getFreeze(@RequestParam String userId){
        return virtualWalletService.getFreeze(userId);
    }

    @PostMapping("/freeze")
    @Operation(summary = "冻结用户的虚拟钱包")
    public int freeze(@RequestParam String userId){
        return virtualWalletService.freeze(userId);
    }

    @PostMapping("/unFreeze")
    @Operation(summary = "解冻用户的虚拟钱包")
    public int unFreeze(@RequestParam String userId){
        return virtualWalletService.unFreeze(userId);
    }
}
