plugins {
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
	id("org.liquibase.gradle") version "2.2.2"
}

group = "shopify.sevdesk"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(22))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.security:spring-security-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.liquibase:liquibase-core")
	liquibaseRuntime("org.liquibase:liquibase-core")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	compileOnly("org.projectlombok:lombok")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

liquibase {
	activities.register("main") {
		val dbUrl = "jdbc:mysql://localhost:3306/mydatabase"
		val dbUser = "root"
		val dbPassword = "password"

		this.arguments =
			mapOf(
				"logLevel" to "debug",
				"changeLogFile" to "/db/changelog/db.changelog-master.yaml",
				"url" to dbUrl,
				"username" to dbUser,
				"password" to dbPassword,
				"driver" to "com.mysql.cj.jdbc.Driver",
				"classpath" to "$projectDir/src/main/resources",
			)
	}
	runList = "main"
}