package cn.cloudtop.zone;

import cn.cloudtop.zone.interceptors.UnitedErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by jackie on 16-4-24
 */
@EnableSwagger2
@Configuration
public class ApiDocsConfig {

    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("zone")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/zone.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("zone service")
                .description("provide country,province,city,district/country.")
                .contact("jackie.han@cloudtopcn.com")
                .version("1.0")
                .build();
    }
}
