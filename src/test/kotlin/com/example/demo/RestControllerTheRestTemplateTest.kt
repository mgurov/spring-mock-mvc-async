package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RestControllerTheRestTemplateTest {

    val restTemplate = RestTemplateBuilder()
        .build()

    @Test
    fun `should get simple response`() {

        val responseType = object: ParameterizedTypeReference<Map<String, String>>() {}
        val response = restTemplate.exchange(
            "http://localhost:8080/" + RestControllerThe.Path.simple,
            HttpMethod.GET,
            null,
            responseType
        )

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isEqualTo(mapOf("hello" to "world"))
    }


}

//TODO: random ports?