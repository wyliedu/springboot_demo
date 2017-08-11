package com.wylie.springboot.web.freemaker.directives;

import java.io.IOException;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;


/**
 * BaseDirective that all Directives must extends in b2bbuyer
 */
public abstract class BaseDirective implements TemplateDirectiveModel {

	private final BeansWrapper beansWrapper;


	/**
	 * @param beansWrapper
	 */
	public BaseDirective(final BeansWrapper beansWrapper) {
		super();
		this.beansWrapper = beansWrapper;
	}

	/**
	 * @return BeansWrapper
	 */
	public BeansWrapper getBeansWrapper() {
		return beansWrapper;
	}


	protected void setVariable(final String name, final Object value, final Environment env, final TemplateDirectiveBody body) throws TemplateException, IOException {
		env.setVariable(name, beansWrapper.wrap(value));
	}

}
