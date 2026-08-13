package com.ll.p14054

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class P14054ApplicationTests(
    @param:Autowired private val mvc: MockMvc,
) {
    @Test
    fun `application context and home endpoint work`() {
        mvc.perform(get("/"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.application").value("p-14054-2"))
    }
}

