package com.vdc.ims.configuration;

import com.vdc.ims.common.logger.LoggerInterceptor;
import com.vdc.ims.common.logger.SessionInterceptor;
import com.vdc.ims.common.resolver.ArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //JsonView
    @Bean
    public MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }

    //Interceptor
    @Bean
    public SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/img/**", "/css/**", "/webfonts/**", "/js/**", "/favicon.ico", "/stt/ub/excel/**", "/manual/**")
                .excludePathPatterns("/stt/ub/excel/total", "/stt/ub/excel/total_head", "/stt/ub/excel/time", "/stt/ub/excel/time_agent")
                .excludePathPatterns("/", "/login", "/loginchk", "/logout", "/pwd", "/pwdchg", "/blank","/mntng/dash/no/")
                .excludePathPatterns("/cmm/api/call/data/", "/mng/ivr/service/request", "/cmm/api/getDeptFromDnis");

        registry.addInterceptor(new LoggerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/img/**", "/css/**", "/webfonts/**", "/js/**", "/favicon.ico");
    }

    //parameter Resolver
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ArgumentResolver());
    }

    //index Page
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addRedirectViewController("/", "login");
    }

}
