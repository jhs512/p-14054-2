package com.ll.p14054

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class P14054Application

fun main(args: Array<String>) {
    runApplication<P14054Application>(*args)
}

