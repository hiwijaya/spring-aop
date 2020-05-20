package com.hiwijaya.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Happy Indra Wijaya
 */
@Configuration
@EnableAspectJAutoProxy     // <aop:aspectj-autoproxy/>
@ComponentScan("com.hiwijaya.aop")
public class AutomatedConfig {

}
