package com.neusoft.elmboot.controller.plus;

import com.neusoft.elmboot.po.domain_plus.vo.EfficientCreditVo;
import com.neusoft.elmboot.po.domain_plus.vo.ExpiredCreditVo;
import com.neusoft.elmboot.service.plus.CreditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plus/CreditController")
@CrossOrigin
@Tag(name = "积分系统controller")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping("/addCreditByDateById")
    @Operation(summary = "签到增加用户积分")
    public int addCreditByDateById(@RequestParam("userId") String userId){
        return creditService.addCreditByDateById(userId);
    }

    @PostMapping("/credit2money")
    @Operation(summary = "积分兑换")
    public int credit2money(@RequestParam("userId") String userId,@RequestParam("credit") Integer credit){
        return creditService.credit2money(userId,credit);
    }

    @GetMapping("/getCreditById")
    @Operation(summary = "查询总积分")
    public int getCreditById(@RequestParam("userId") String userId){
        return creditService.getCreditById(userId);
    }

    @GetMapping("/listEfficientCreditById")
    @Operation(summary = "查询有效积分明细")
    public List<EfficientCreditVo> listEfficientCreditById(@RequestParam("userId") String userId,
                                                           @RequestParam("pageNum") Integer pageNum,
                                                           @RequestParam("pageSize") Integer pageSize){
        return creditService.listEfficientCreditById(userId,pageNum,pageSize);
    }

    @GetMapping("/listExpiredCreditById")
    @Operation(summary = "查询过期积分明细")
    public List<ExpiredCreditVo> listExpiredCreditById(@RequestParam("userId") String userId,
                                                       @RequestParam("pageNum") Integer pageNum,
                                                       @RequestParam("pageSize") Integer pageSize){
        return creditService.listExpiredCreditById(userId,pageNum,pageSize);
    }

    @GetMapping("/listEfficientGetCreditById")
    @Operation(summary = "查询有效的获得的积分明细")
    public List<EfficientCreditVo> listEfficientGetCreditById(@RequestParam("userId") String userId,
                                                              @RequestParam("pageNum") Integer pageNum,
                                                              @RequestParam("pageSize") Integer pageSize){
        return creditService.listEfficientGetCreditById(userId,pageNum,pageSize);
    }

    @GetMapping("/listCredit2MoneyById")
    @Operation(summary = "查询兑换的积分明细")
    public List<EfficientCreditVo> listCredit2MoneyById(@RequestParam("userId") String userId,
                                                        @RequestParam("pageNum") Integer pageNum,
                                                        @RequestParam("pageSize") Integer pageSize){
        return creditService.listCredit2MoneyById(userId,pageNum,pageSize);
    }
}
