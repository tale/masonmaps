plugins {
	java
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"

	id ("com.github.node-gradle.node") version "3.0.1"

}

apply(plugin = "io.spring.dependency-management")

group = "com.gmuguessr"
version = "0.0.1-SNAPSHOT"


node {
    version = "14.15.5"
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.postgresql:postgresql:42.7.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.microsoft.sqlserver:mssql-jdbc:6.1.0.jre7")
	
}

tasks.withType<Test> {
	useJUnitPlatform()
}