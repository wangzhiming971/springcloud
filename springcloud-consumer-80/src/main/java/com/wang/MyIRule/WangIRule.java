package com.wang.MyIRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WangIRule {

     @Bean
     public IRule MyIRule(){
        return new WangRandomRule();//默认是轮询,现在我们定义为WangRandomRule
   }
}
