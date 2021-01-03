package interview.spring.boot;

/**
 *  ->  Spring Boot auto-configuration automatically configure a Spring application based
 *      on the dependencies present on the classpath. Spring Boot detects classes in the
 *      classpath and auto-configuration mechanism will ensure to create and wires necessary
 *      beans for us. This is one of the most powerful feature of the Spring Boot and most
 *      of the work happens silently in the background.
 *  ->  Before we get into details of how Spring Boot auto-configuration works, let’s take
 *      a broader look at the @Conditional annotation. This annotation is the base and most
 *      annotations used by the Spring Boot auto-configuration are extensions of this annotation.
 *      The @Conditional annotation introduced in Spring 4 is an improvement to the Spring
 *      profile feature. It adds flexibility to the developer to register beans based on several
 *      conditions like:
 *      ->  A type-level annotation on any class directly or indirectly annotated with @Component,
 *          including @Configuration classes.
 *      ->  As a meta-annotation, for the purpose of building custom stereotype annotations.
 *      ->  Method-level annotation on any @Bean method.
 *  ->  Internally auto-configuration is achieved with @Configuration annotation. Let’s look at
 *      the out of the box JacksonAutoConfiguration for a further understanding:
 *                  @Configuration
 *                  @ConditionalOnClass({ObjectMapper.class})
 *                  public class JacksonAutoConfiguration {
 *                      // auto-configuration stuff
 *                  }
 *      Spring Boot, use the @Conditional annotations to determine if it require setting up
 *      auto-configuration for the configuration or not. Usually auto-configuration classes
 *      use the following conditional annotations but there are plenty:
 *      1.  @ConditionalOnClass : In above example, Spring Boot auto-configuration includes
 *                  JacksonAutoConfiguration, if it finds ObjectMapper in the classpath.
 *      2.  @ConditionalOnMissingBean : We use this annotation to verify the absence of a
 *                  specific bean. Example below:
 *                  @Configuration
 *                  @ConditionalOnClass({ObjectMapper.class})
 *                  public class JacksonAutoConfiguration {
 *                      // additional configuration code
 *                      @Bean
 *                      @Primary
 *                      @ConditionalOnMissingBean
 *                      public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
 *                          return builder.createXmlMapper(false).build();
 *                      }
 *                  }
 *  ->  To enable the auto-configuration magic, Spring Boot uses the @EnableAutoConfiguration
 *      annotation.
 *  ->  To load auto-configuration classes, Spring needs to know where to look for it. Spring checks
 *      META-INF/spring.factories file within your published jar. This file should contain a list of
 *      the configuration class. Let’s look at the spring.factories file under the auto-configuration jar.
 *              # Auto Configure
 *              org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
 *              org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,\
 *              org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,\
 *              org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration,\
 *      This is a standard component of the Spring Core and it uses SpringFactoriesLoader, get the list
 *      of Java Configurations classes configured using the org.springframework.boot.autoconfigure
 *      .EnableAutoConfiguration property key.
 */
public class Q_001_AutoConfigurationWorking {
}
