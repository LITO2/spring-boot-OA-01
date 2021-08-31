package com.example.springbootoa01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request){
        //获取请求中的语言参数
        String language =request.getParameter("l");

        System.out.println("Debug===>"+language);

        //如果没有则使用默认的
        if(!StringUtils.hasText(language)){
            Locale locale = Locale.getDefault();
            return locale;
        }
        //如果请求的连接携带了国际化的参数
        else{
            //zh_CN
            String[] split =language.split("_");
            //国家，地区
            return  new Locale(split[0],split[1]);
        }

    }
    //返回
    @Override
    public void setLocale (HttpServletRequest request,HttpServletResponse response,Locale locale){

    }
}
