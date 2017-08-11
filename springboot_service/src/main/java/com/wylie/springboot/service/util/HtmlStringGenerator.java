package com.wylie.springboot.service.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


/**
 * Html string generator
 * 
 * @author Kevin GUO Jul 14, 2016
 */
public class HtmlStringGenerator {
	/**
	 * Generate html string
	 * 
	 * @param template
	 * @param variables
	 * @return generated html string
	 * @throws IOException
	 * @throws TemplateException
	 * @author Kevin GUO
	 */
	public static String generate(String template, Map<String, Object> variables) throws IOException, TemplateException {
		BufferedWriter writer = null;
		String htmlContent = "";
		Configuration config = FreemarkerConfiguration.getConfiguation();
		Template tp = config.getTemplate(template);
		StringWriter stringWriter = new StringWriter();
		writer = new BufferedWriter(stringWriter);

		tp.setEncoding("UTF-8");
		tp.process(variables, writer);
		htmlContent = stringWriter.toString();
		writer.flush();
		writer.close();
		return htmlContent;
	}
}
