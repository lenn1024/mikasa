package ai.code.mikasa.spring.config;

import ai.code.mikasa.spring.beans.BusinessMan;
import ai.code.mikasa.spring.beans.GovermentMan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfiguration {

    @Bean
    public BusinessMan businessMan(){
        return new BusinessMan();
    }

    @Bean
    public GovermentMan govermentMan(){
        return new GovermentMan();
    }
}
