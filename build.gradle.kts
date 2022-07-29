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
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
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
		jvmFlags = listOf("-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005")
	}
}
