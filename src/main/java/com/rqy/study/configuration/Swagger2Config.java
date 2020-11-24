package com.rqy.study.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import  org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import  springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import  springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger2的配置文件：访问方式
 *
 *      swagger2原始ui
 *      http://localhost:8080/swagger-ui.html
 *
 *      swagger-ui-layer访问ui
 *      http://localhost:8080/docs.html
 *
 * @Author renqingyang
 * @create 2020/9/18 5:45 PM
 */

//swagger2的配置文件，在项目的启动类的同级文件建立
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger.enable}")
    private boolean isSwaggerEnable;
    // swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(isSwaggerEnable)
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.rqy.study.controller")).paths(PathSelectors.any())
                .build();
    }
    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("Spring Boot 测试使用 Swagger2 构建RESTful API")
                // 创建人信息
                .contact(new Contact("任清阳",  "https://www.cnblogs.com/rqy0526/",  "qingyang_ren@126.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }
}
