# Variables
SPRING_APP_DIR=.\shopify-sevdesk-integration-backend
ANGULAR_APP_DIR=.\shopify-sevdesk-intgeration-frontend

.PHONY: all build-spring build-angular serve-spring serve-angular clean

all: build-spring build-angular
all serve: build-spring build-angular serve-spring serve-angular

# Build the Spring Boot application
build-spring:
	cd $(SPRING_APP_DIR) && gradlew clean build -x test

# Build the Angular application (Optional if build is needed)
build-angular:
	cd $(ANGULAR_APP_DIR) && npm install && nx build shopify-sevdesk

# Serve the Spring Boot application locally
serve-spring:
	cd $(SPRING_APP_DIR) && set SPRING_PROFILES_ACTIVE=local && gradlew bootRun

# Serve the Angular application locally
serve-angular:
	cd $(ANGULAR_APP_DIR) && nx serve shopify-sevdesk

# Clean up build artifacts
clean:
	cd $(SPRING_APP_DIR) && gradlew clean
	cd $(ANGULAR_APP_DIR) && nx clean shopify-sevdesk

# Serve both applications in parallel
serve: serve-angular serve-spring
