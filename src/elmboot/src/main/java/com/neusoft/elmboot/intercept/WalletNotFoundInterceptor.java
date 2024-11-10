package com.neusoft.elmboot.intercept;

import com.neusoft.elmboot.mapper.plus.VirtualWalletMapper;
import com.neusoft.elmboot.po.domain_plus.dto.WalletFlowDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class WalletNotFoundInterceptor implements HandlerInterceptor {
    @Autowired
    private VirtualWalletMapper virtualWalletMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userId = request.getParameter("userId");

        if (!(userId == null || userId.isEmpty())) {
            int flag = virtualWalletMapper.getCountById(userId);
            if(flag==0){
                throw new Exception();
            }
            return true;
        }
        WalletFlowDto walletFlowDto = (WalletFlowDto) request.getAttribute("walletFlowDto");
        if (walletFlowDto != null) {
            userId = walletFlowDto.getUserId();
            int flag = virtualWalletMapper.getCountById(userId);
            if(flag==0){
                throw new Exception();
            }
            return true;
        }
        return true;
    }

}
