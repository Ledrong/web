package com.example.nepekariproject.config
/*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring5.view.ThymeleafViewResolver
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ITemplateResolver


@Configuration
class ThymeleafConfig {
    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Bean
    fun thymeleafViewResolver(): ViewResolver {
        val resolver = ThymeleafViewResolver()
        resolver.templateEngine = thymeleafTemplateEngine()
        resolver.characterEncoding = "UTF-8"
        return resolver
    }

    @Bean
    fun thymeleafTemplateEngine(): SpringTemplateEngine {
        val engine = SpringTemplateEngine()
        engine.enableSpringELCompiler = true
        engine.setTemplateResolver(thymeleafTemplateResolver())
        return engine
    }

    @Bean
    fun thymeleafTemplateResolver(): ITemplateResolver {
        val resolver = SpringResourceTemplateResolver()
        resolver.setApplicationContext(applicationContext)
        resolver.prefix = "classpath:/templates/"
        resolver.suffix = ".html"
        resolver.templateMode = TemplateMode.HTML
        resolver.characterEncoding = "UTF-8"
        resolver.isCacheable = false
        return resolver
    }
}*/