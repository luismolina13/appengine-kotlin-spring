package com.kalecard.appengine

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

	private val log: Logger = LoggerFactory.getLogger(ServletInitializer::class.qualifiedName)

	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		log.info("========== >>>>>>>>>>>>>>>>>>>>> ServletInitializer.configure")
		return application.sources(AppengineApplication::class.java)
	}

}
