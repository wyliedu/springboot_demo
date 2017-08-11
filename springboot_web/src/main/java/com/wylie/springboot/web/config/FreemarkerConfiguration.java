package com.wylie.springboot.web.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;


/**
 * Overrides the default spring-boot configuration to allow adding shared variables to the freemarker context
 */
@Configuration
public class FreemarkerConfiguration extends FreeMarkerAutoConfiguration.FreeMarkerWebConfiguration implements BeanFactoryAware {
	private BeanFactory beanFactory;

	@Override
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		final Environment env = (Environment) beanFactory.getBean("environment");
		final FreeMarkerConfigurer configurer = super.freeMarkerConfigurer();

		final Map<String, Object> sharedVariables = new HashMap<String, Object>();
		sharedVariables.put("longToDate", beanFactory.getBean("longToDate"));
		sharedVariables.put("encodeURL", beanFactory.getBean("encodeURL"));
		final String myRootPath = env.getProperty("my.domain.url", String.class);
		sharedVariables.put("myRootPath", myRootPath);
		configurer.setFreemarkerVariables(sharedVariables);

		return configurer;
	}

	/**
	 * Inject an BeansWrapper. This is the way BeansWrapperBuilder suggests.
	 *
	 * @return An singleton Beans Wrapper.
	 */
	@Bean
	public BeansWrapper beansWrapper() {
		final BeansWrapper beansWrapper = new BeansWrapperBuilder(freemarker.template.Configuration.VERSION_2_3_25).build();
		return beansWrapper;
	}

	@Override
	public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnEnabledResourceChain
	public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
		return new ResourceUrlEncodingFilter();
	}
}
