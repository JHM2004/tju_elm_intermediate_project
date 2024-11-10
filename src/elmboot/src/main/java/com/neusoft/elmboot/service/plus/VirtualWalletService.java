package com.neusoft.elmboot.service.plus;

import com.neusoft.elmboot.po.domain_plus.dto.WalletFlowDto;
import com.neusoft.elmboot.po.domain_plus.vo.WalletFlowVo;

import java.math.BigDecimal;
import java.util.List;

public interface VirtualWalletService {

    int addWalletById(String userId);

    int getWhetherEnabledById(String userId);

    int rechargeById(WalletFlowDto walletFlowDto);

    BigDecimal withdrawById(WalletFlowDto walletFlowDto);

    int pay(WalletFlowDto walletFlowDto);

    BigDecimal getBalanceById(String userId);

    List<WalletFlowVo> listWalletLogById(String userId);

    List<WalletFlowVo> listWalletLogIncomeById(String userId);

    List<WalletFlowVo> listWalletLogOutcomeById(String userId);

    int getFreeze(String userId);

    int freeze(String userId);

    int unFreeze(String userId);

    void rechargeByIdByCredit(String userId, int i);
}
