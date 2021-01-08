package com.mezo.athena.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import freemarker.template.TemplateException;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qzrs
 */
@Configuration
@ComponentScan(basePackages = { "com.mezo.athena" })
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return super.preHandle(request, response, handler);
            }
        }).addPathPatterns("");

    }
    /**
     * 配置格式化器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
    }
    /**
     * 配置跨域路径映射
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT,POST,GET,DELETE").allowedHeaders("*");
    }
    /**
     * 静态资源处理器配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        //addResourceHandler 项目路径  addResourceLocations 本地路径
        registry.addResourceHandler("/resources/freemarker/**").addResourceLocations ("classpath:/resources/");
        registry.addResourceHandler("/resources/mappers/**").addResourceLocations ("classpath:/resources/");
    }

    /**
     * 消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fjc = new FastJsonHttpMessageConverter();
        FastJsonConfig fj = new FastJsonConfig();
        fj.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);
        fjc.setFastJsonConfig(fj);
        converters.add(fjc);
    }

    /**
     * 视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);

    }
    /**
     * FreeMarker 视图解析器配置
     * @return
     */
    @Bean
    public FreeMarkerViewResolver templateResolver() {
        FreeMarkerViewResolver viewResolver =new FreeMarkerViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        viewResolver.setCache(false);
        viewResolver.setContentType("text/html;chareset=UTF-8");
        viewResolver.setRequestContextAttribute("requestContext");
        viewResolver.setOrder(0);
        viewResolver.setExposeRequestAttributes(true);
        viewResolver.setExposeSessionAttributes(true);
        return viewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setDefaultEncoding("UTF-8");
        configurer.setTemplateLoaderPath("classpath:/templates");
        try {
            freemarker.template.Configuration configuration = configurer.createConfiguration();
            configuration.setDefaultEncoding("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("rootContextPath",System.getProperty("root.context.path"));
        configurer.setFreemarkerVariables(map);
        return configurer;
    }


    /**
     * 消息源配置
     * @return
     */
    @Bean(name = "messageSource")
    public MessageSource configureMessageSource () {
        ReloadableResourceBundleMessageSource messageSource =new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(5);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
