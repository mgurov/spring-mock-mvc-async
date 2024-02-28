package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class RestControllerTheSpringMvcTest(
    @Autowired private val mockMvc: MockMvc,
) {
    @Test
    fun `should get simple response`() {
        mockMvc.get(RestControllerThe.Path.simple, {})
            .andExpect {
                status { isOk() }
                content {
                    jsonPath("hello") {value("world")}
                }
            }
    }

    @Test
    fun `should get simple async response`() {
        mockMvc.get(RestControllerThe.Path.simpleAsync, {})
            .andExpect {
                status { isOk() }
                content {
                    jsonPath("hello") {value("world")}
                }
            }
    }
}