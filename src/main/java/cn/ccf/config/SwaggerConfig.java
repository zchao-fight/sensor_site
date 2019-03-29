package cn.ccf.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Configuration作用于类上，相当于一个xml配置文件
 * @Bean作用于方法上，相当于xml配置中的<bean>
 */


@Configuration
@EnableSwagger2 //@EnableSwagger2则是用来启动Swagger支持，表示这是一个Spring Swagger的配置文件。
public class SwaggerConfig {

    /**
     * 定义了一个Bean方法createRestApi，Spring中名字并不重要，重要的是它返回一个Docket类，DocumentationType.SWAGGER_2作为Docket构造方法的参数，指定了所用的swagger版本2.0，官网上已经在预告3.0版本了。而之后的apiInfo则是调用接下来的apiInfo函数，来创建Docket的信息。apiInfo函数采用ApiInfoBuilder来创建ApiInfo类。
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("cn.ccf.controller")) // 对所有api进行监控  RequestHandlerSelectors.any()
                .paths(PathSelectors.any()) // 对所有路径进行监
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Srping中使用Swagger2构建RESTFUL APIS")
                .termsOfServiceUrl("http://航天长峰/军工事业部/边海防")//自定义你想要的网址
                .description("springmvc swagger2")
                .contact(new Contact("张超", "http://航天长峰/军工事业部/边海防", "915749631@qq.com"))
                .version("1.1")
                .build();
    }
}
/**
 private ApiInfo apiInfo()
 {
 ApiInfo apiInfo = new ApiInfo(
 "springmvc搭建swagger",
 "spring-API swagger测试",
 "My Apps API terms of service",
 "534560449@qq.com",
 "web app",
 "My Apps API License URL");
 return apiInfo;
 }
 **/

