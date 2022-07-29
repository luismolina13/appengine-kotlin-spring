package com.kalecard.appengine

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("")
class MainController {

    @RequestMapping(
        value = ["/"],
        method = [RequestMethod.GET, RequestMethod.OPTIONS]
    )
    fun handle(): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("HELLO WORLD")
    }
}