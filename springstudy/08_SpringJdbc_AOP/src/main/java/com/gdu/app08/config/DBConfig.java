package com.gdu.app08.config;

import java.util.Collections;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/*
  @EnableTransactionManagement
  트랜잭션매니저를 허용하는 애너테이션
  
 */

@EnableTransactionManagement

@Configuration
public class DBConfig {

	// SpringJdbc 처리를 위한 DriverManagerDataSource와 JdbcTemplate을 Bean으로 등록한다.
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("SCOTT");
		dataSource.setPassword("TIGER");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());  // dataSource() 의존 관계 처리
	}
	
	// 트랙잭션 처리를 위한 TransactionManager를 Bean으로 등록한다.
	@Bean
	public TransactionManager transactionmanager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	// 트랜잭션 인터셉터를 Bean으로 등록한다.
	@Bean
	public TransactionInterceptor transactionInterceptor() {
		
		// 모든 Exception이 발생하면 Rollback을 수행하시오.
		RuleBasedTransactionAttribute attribute = new RuleBasedTransactionAttribute();
		attribute.setName("*");
		attribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		MatchAlwaysTransactionAttributeSource source = new MatchAlwaysTransactionAttributeSource();
		source.setTransactionAttribute(attribute);
		
		return new TransactionInterceptor(transactionmanager(), source);
	}
	
	// 트랜잭션 인터셉터를 advice로 등록하는 advisor를 bean으로 등록한다.
	
	@Bean
	public Advisor advisor() {
		
		// 언제 advice를 동작시킬 것인가?
		// 포인트컷(pointCut)을 결정해야한다.
		
		// 포인트컷 표현식
		
		/*
		  	1. 기본 형식
		  	execution(리턴타입 패키지.클래스.메소드(매개변수))
		  	
		  	2. 의미
		  		1) 리턴 타입
			  		(1) *
			  		(2) void
			  		(3) !void
		  		2) 매개변수
		  			(1) .. 모든 매개변수
		  			(2) * 1개의 모든 매개변수
		  			
		 */
		AspectJExpressionPointcut pointCut = new AspectJExpressionPointcut();
		pointCut.setExpression("execution(* com.gdu.app08.service.*Impl.*Transaction(..))");
		
		return new DefaultPointcutAdvisor(pointCut, transactionInterceptor()); // advice = transaction interceptor
		
	}
}
