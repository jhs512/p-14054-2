package com.ll.p14054.global.app

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("custom")
data class AppProperties(
    val temp: Directory = Directory("/tmp"),
    val gen: Directory = Directory("/gen"),
) {
    data class Directory(
        val dirPath: String,
    )
}

