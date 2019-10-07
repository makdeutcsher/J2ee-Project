package com.smartgen.smartgen;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan
public class RConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/upload/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/upload/");
    registry.addResourceHandler("/js/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/js/");
    registry.addResourceHandler("/css/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/css/");
    registry.addResourceHandler("/multitag/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/multitag/");
    registry.addResourceHandler("/images/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/images/");
    registry.addResourceHandler("/fonts/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/fonts/");
    registry.addResourceHandler("/admin/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/admin/");
    registry.addResourceHandler("/custom/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/custom/");
    registry.addResourceHandler("/apa_docs/**").addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/apa_docs/");

    
    
  }
}