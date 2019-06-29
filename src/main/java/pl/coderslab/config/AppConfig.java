package pl.coderslab.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.converter.ChildConverter;
import pl.coderslab.converter.TeacherConverter;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.coderslab.repository")
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("KinderGardenUnit");
        return emfb; }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm; }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedOrigins("*");
//                .allowedOrigins("http://localhost");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver; }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getChildConverter());
        registry.addConverter(getTeacherConverter());
    }
    @Bean
    public ChildConverter getChildConverter() {
        return new ChildConverter();
    }
    @Bean
    public TeacherConverter getTeacherConverter(){return new TeacherConverter();}


//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(getAuthorConverter());
//        registry.addConverter(getCategoryConverter());
//    }
//    @Bean
//    public AuthorConverter getAuthorConverter() {
//        return new AuthorConverter();
//    }
//
//    @Bean
//    public CategoryConverter getCategoryConverter() {
//        return new CategoryConverter();
//    }
//

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}
