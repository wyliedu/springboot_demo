package com.wylie.springboot.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wylie.springboot.service.entity.UserEntity;
import com.wylie.springboot.service.enums.UserSexEnum;
import com.wylie.springboot.service.services.LocaleMessageSourceService;

@Controller
public class ThymeleafController extends BasePageController{
	
	@Autowired
	private LocaleMessageSourceService localeMessageSourceService;
	
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
	private RedisTemplate redisTemplate;
	
    @RequestMapping("/hi")
	public String hello(Locale locale, Model model) throws InterruptedException {
        stringRedisTemplate.opsForValue().set("aaa", "111");
		String msg = localeMessageSourceService.getMessage("product.detail.general_product");
		model.addAttribute("greeting", msg);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
		String formattedDate = dateFormat.format(date);
		model.addAttribute("currentTime", formattedDate);
        String a = stringRedisTemplate.opsForValue().get("aaa");
        UserEntity user=new UserEntity("aa@126.com", "aa", UserSexEnum.MAN);
        ValueOperations<String, UserEntity> operations=redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists2=redisTemplate.hasKey("com.neox");
        boolean exists=redisTemplate.hasKey("com.neo.f");
        List<UserEntity> list2 = (List<UserEntity>) redisTemplate.opsForValue().get("allUser");
        String b = operations.get("com.neox").getUserName();
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