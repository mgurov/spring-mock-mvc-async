package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestControllerThe {

    @GetMapping("/api-rest/simple")
    fun simpleResponse(): Map<String, String> {
        return mapOf("hello" to "world")
    }

}