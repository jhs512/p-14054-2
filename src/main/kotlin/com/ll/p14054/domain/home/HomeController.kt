package com.ll.p14054.domain.home

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress

@RestController
class HomeController(
    @param:Value("\${spring.application.name}") private val applicationName: String,
) {
    @GetMapping("/")
    fun home(): InstanceResponse =
        InstanceResponse(
            application = applicationName,
            hostname = InetAddress.getLocalHost().hostName,
            message = "최신 코프링 + 쿠버네티스 롤링 업데이트",
        )

    data class InstanceResponse(
        val application: String,
        val hostname: String,
        val message: String,
    )
}

