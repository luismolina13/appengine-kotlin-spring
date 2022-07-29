import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.10"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	war
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("com.google.cloud.tools.appengine") version "2.4.4"
}

group = "com.kalecard"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	providedCompile("javax.servlet:javax.servlet-api:3.1.0")
	providedCompile("com.google.appengine:appengine:+")

	implementation("com.github.spotbugs:spotbugs-annotations:4.5.0")
	implementation("org.springframework.boot:spring-boot-starter-web") {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
	}
	implementation("org.projectlombok:lombok:1.18.2") {
		exclude(group = "org.slf4j", module = "jul-to-slf4j")
	}

	implementation("com.github.spotbugs:spotbugs-annotations:4.5.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

appengine {  // App Engine tasks configuration
	deploy {   // deploy configuration
		projectId = "clado-app"
		version = "GCLOUD_CONFIG"
		stopPreviousVersion = true
		promote = true
	}
	run {
//		jvmFlags = listOf("-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005")
	}
}
