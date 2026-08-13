package com.ll.p14054.global.webmvc

import com.ll.p14054.global.app.AppProperties
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.nio.file.Path

@Configuration
class WebMvcConfig(
    private val appProperties: AppProperties,
) : WebMvcConfigurer {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        val location = Path.of(appProperties.gen.dirPath).toAbsolutePath().normalize().toUri().toString()
        registry.addResourceHandler("/gen/**").addResourceLocations(location)
    }
}

