package com.example.demo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.async.WebAsyncTask
import org.springframework.web.servlet.function.AsyncServerResponse
import java.util.concurrent.TimeUnit

@RestController
class RestControllerThe {

    data class SimpleParams(
        val delaySecs: Long = 0L,
        val responseTimeoutMsecs: Long = TimeUnit.MINUTES.toMillis(10L)
    )

    @GetMapping(Path.simple)
    fun simpleResponse(
        @ModelAttribute params: SimpleParams,
    ): ResponseEntity<Map<String, String>> {
        TimeUnit.SECONDS.sleep(params.delaySecs)
        return ResponseEntity.ok(mapOf("hello" to "world"))
    }

    @GetMapping(Path.simpleAsync)
    fun simpleResponseAsync(
        @ModelAttribute params: SimpleParams,
    ): WebAsyncTask<Map<String, String>> {
        return WebAsyncTask(params.responseTimeoutMsecs) {
            TimeUnit.SECONDS.sleep(params.delaySecs)
            mapOf("hello" to "world")
        }
    }

    object Path {
        const val simple = "/api-rest/simple"
        const val simpleAsync = "/api-rest/simple-async"
    }

}