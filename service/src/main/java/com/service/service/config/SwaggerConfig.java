/**
 *
 */
package com.service.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴方宇
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List<Parameter> pars = new ArrayList<>();
        pars.add(buildParamter("projectId", "项目Id", "string"));
        pars.add(buildParamter("employeeId", "员工Id", "string"));
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex(ApiUriTemplate.APP_ROOT_PATH + "/.*"))
                .build()
                .globalOperationParameters(pars);
    }

    private Parameter buildParamter(String name, String desc, String type) {
        ParameterBuilder builder = new ParameterBuilder();
        builder.name(name).description(desc).modelRef(new ModelRef(type)).parameterType("header").required(false);
        return builder.build();
    }
}
