package com.stackroute.MuzixApplication.JavaConfig;

//import com.stackroute.MuzixApplication.repository.TrackRepository;
//import org.h2.server.web.WebServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.annotation.WebServlet;

@Configuration
@EnableSwagger2
@PropertySource("classpath:application.properties")
//@EnableMongoRepositories(basePackageClasses = TrackRepository.class)
public class WebConfiguration
{
//    @Bean
//    ServletRegistrationBean h2ServletRegistration()
//        {
//            ServletRegistrationBean registrationBean=new ServletRegistrationBean(new WebServlet());
//            registrationBean.addUrlMappings("/console/*");
//            return registrationBean;
//        }

}
