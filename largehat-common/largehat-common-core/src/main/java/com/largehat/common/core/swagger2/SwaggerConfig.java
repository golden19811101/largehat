package com.largehat.common.core.swagger2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * api页面 /swagger-ui.html
 * @author Lion
 * @date 2018-11-23
 */

@Configuration
public class SwaggerConfig {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${swagger.enabled}")
    private Boolean enabled;

//    @Bean
//    public Docket createRestApi() {
//        ParameterBuilder ticketPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        ticketPar.name(tokenHeader).description("token")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .defaultValue("Bearer ")
//                .required(true)
//                .build();
//        pars.add(ticketPar.build());
//        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(enabled)
//                .apiInfo(apiInfo())
//                .select()
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .build()
//                .globalOperationParameters(pars);
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("接口文档")
//                .version("2.1")
//                .build();
//    }

}
