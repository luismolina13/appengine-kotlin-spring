package com.kalecard.appengine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppengineApplication

fun main(args: Array<String>) {
	runApplication<AppengineApplication>(*args)
}
