package com.neusoft.elmboot.service.impl;

import java.util.List;

import com.neusoft.elmboot.mapper.plus.CreditMapper;
import com.neusoft.elmboot.po.domain_plus.po.EfficientCredit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.neusoft.elmboot.mapper.RemarkMapper;
import com.neusoft.elmboot.po.Remark;
import com.neusoft.elmboot.service.RemarkService;
import com.neusoft.elmboot.util.CommonUtil;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class RemarkServiceImpl implements RemarkService{

	 @Autowired
	 private RemarkMapper remarkMapper;

	@Autowired
	private CreditMapper creditMapper;

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public List<Remark> listRemarksByBusinessId(Integer businessId) {
		
		return remarkMapper.listRemarksByBusinessId(businessId);
	}

	@Override
	@Transactional
	@CachePut(cacheNames = "getCreditById", key = "#remark.getUserId()")
	public int saveRemarks(Remark remark) {
		//核心业务
		remark.setRemarkDate(CommonUtil.getCurrentDate());
//		/*------------------------------------------------------------------------------------
//		 * 评论一条获得1积分，每天评论超过10条后取消积分奖励，即：每天通过评论最多获得10积分封顶
//		 * */
//		//获取当日已经评论的条数
//		// 可以将下面的评论加积分的功能做成异步通信调用，提升性能（已经完成）
//		int count = remarkMapper.getAmountByDayById(remark.getUserId());
//		if(count<10){
//			//积分+1
//			EfficientCredit efficientCredit = new EfficientCredit();
//			efficientCredit.setUserId(remark.getUserId());
//			efficientCredit.setChannelId(2);
//			efficientCredit.setTypeId(0);
//			efficientCredit.setCredit(1);
//			creditMapper.addCreditRecharge(efficientCredit);
//			creditMapper.addCreditById(efficientCredit.getUserId(), 1);
//		}
//		//------------------------------------------------------------------------------------
		try {
			//交换机的名字
			String exchangeName = "remark.fanout";
			//发送消息
			rabbitTemplate.convertAndSend(exchangeName, "",remark.getUserId());
		} catch (Exception e) {
			log.error("评论的消息发送失败，用户id详情：{}",remark.getUserId());
		}
		//返回值是评论编号
		remarkMapper.saveRemarks(remark);
		return creditMapper.getCreditAllById(remark.getUserId());
	}
	
	@Override
	public int removeOneRemark(Remark remark) {
		return remarkMapper.removeOneRemark(remark);
	}
	
	
	@Override
	public List<Remark> removeAllRemarksByUserId(String userId) {
		return remarkMapper.removeAllRemarksByUserId(userId);
	}
	
}
