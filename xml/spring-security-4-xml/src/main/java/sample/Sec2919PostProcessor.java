package sample;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;

public class Sec2919PostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
			throws BeansException {
		String[] beanDefinitionNames = registry.getBeanDefinitionNames();
		for(String name : beanDefinitionNames) {
			BeanDefinition beanDefinition = registry.getBeanDefinition(name);
			if(beanDefinition.getBeanClassName().equals(DefaultSecurityFilterChain.class.getName())) {
				List<Object> filters = (List<Object>) beanDefinition.getConstructorArgumentValues().getArgumentValue(1, List.class).getValue();
				Iterator<Object> iFilters = filters.iterator();
				while(iFilters.hasNext()) {
					Object f = iFilters.next();
					if(f instanceof BeanDefinition) {
						BeanDefinition bean = (BeanDefinition) f;
						if(bean.getBeanClassName().equals(DefaultLoginPageGeneratingFilter.class.getName())) {
							iFilters.remove();
						}
					}
				}
			}
		}
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
	}
}