package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class WebSecurityExpressionHandlerTests {

	@Autowired
	SecurityExpressionHandler<FilterInvocation> handler;

	@Autowired
	ApplicationContext context;

	@Test
	public void configLoads() {
	}

	@Configuration
	static class Config {
		@Bean
		public SecurityExpressionHandler<FilterInvocation> webSecurityExpressionHandler() {
			return new CustomWebSecurityExpressionHandler();
		}
	}

	static class CustomWebSecurityExpressionHandler implements
	SecurityExpressionHandler<FilterInvocation> {

		@Override
		public ExpressionParser getExpressionParser() {
			return null;
		}

		@Override
		public EvaluationContext createEvaluationContext(
				Authentication authentication, FilterInvocation invocation) {
			return null;
		}
	}
}
