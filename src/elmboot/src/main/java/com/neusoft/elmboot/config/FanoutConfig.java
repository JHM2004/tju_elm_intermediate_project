package com.neusoft.elmboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    //------------------------------(recharge to credit)----------------------------------
    //声明FanoutExchange
    @Bean
    public FanoutExchange fanoutExchange1() {
        return new FanoutExchange("recharge.fanout");
    }
    //声明充值->积分队列
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("recharge.credit");
    }
    //绑定队列fanoutQueue1与交换机fanoutExchange
    @Bean
    public Binding bindingQueue1(Queue fanoutQueue1, FanoutExchange fanoutExchange1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange1);
    }


    //------------------------------(pay to credit)----------------------------------
    @Bean
    public FanoutExchange fanoutExchange2() {
        return new FanoutExchange("pay.fanout");
    }
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("pay.credit");
    }
    @Bean
    public Binding bindingQueue2(Queue fanoutQueue2, FanoutExchange fanoutExchange2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange2);
    }


    //------------------------------(pay to credit)----------------------------------
    @Bean
    public FanoutExchange fanoutExchange3() {
        return new FanoutExchange("remark.fanout");
    }
    @Bean
    public Queue fanoutQueue3() {
        return new Queue("remark.credit");
    }
    @Bean
    public Binding bindingQueue3(Queue fanoutQueue3, FanoutExchange fanoutExchange3) {
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange3);
    }
}
