package com.wylie.springboot.web.freemaker.method;

import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.wylie.springboot.service.constant.Constants;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;


/**
 * Convert long to date according to the given timezone
 */
@Component("longToDate")
public class LongToDateMethod implements TemplateMethodModelEx {
	@Override
	public Object exec(@SuppressWarnings("rawtypes") final List arguments) throws TemplateModelException {
		if (arguments.size() != 1) {
			throw new TemplateModelException("Wrong arguments");
		}
		if (null == arguments.get(0)) {
			return "";
		}
		return DateFormatUtils.format(((SimpleNumber) arguments.get(0)).getAsNumber().longValue(), Constants.DATE_FORMAT_PATTERN, LocaleContextHolder.getTimeZone());
	}

}
