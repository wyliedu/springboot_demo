package com.wylie.springboot.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wylie.springboot.service.services.LocaleMessageSourceService;

@Controller
public class ThymeleafController {
	
	@Autowired
	private LocaleMessageSourceService localeMessageSourceService;
	
    @RequestMapping("/hi")
	public String hello(Locale locale, Model model) {
		String msg = localeMessageSourceService.getMessage("product.detail.general_product");
		model.addAttribute("greeting", msg);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
		String formattedDate = dateFormat.format(date);
		model.addAttribute("currentTime", formattedDate);

		return "hello";
	}

    @RequestMapping("/changelanguage/{lang}")
    public String changeSessionLanauage(HttpServletRequest request,HttpServletResponse response,@PathVariable String lang){
              System.out.println(lang);
       LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
       if("zh".equals(lang)){
           localeResolver.setLocale(request, response, new Locale("zh", "CN"));
       }else if("en".equals(lang)){
           localeResolver.setLocale(request, response, new Locale("en", "US"));
       }
       return "redirect:/hi";
    }
}