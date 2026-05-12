.PHONY: all
all: format lint build apidocs

.PHONY: build
build:
	@echo "Building..."
	@./gradlew build koverVerify koverXmlReport koverHtmlReport

.PHONY: clean
clean:
	@echo "Cleaning..."
	@./gradlew clean
	@rm -rf kotlin-js-store

.PHONY: test
test:
	./gradlew --rerun-tasks check

.PHONY: apidocs
apidocs:
	@echo "Running Dokka..."
	@rm -rf docs/public
	@./gradlew :docs:dokkaGeneratePublicationHtml

.PHONY: lint
lint:
	@./gradlew spotlessCheck \
		:lib:detekt \
		:examples:detekt \
		:docs:detekt

.PHONY: format
format:
	@./gradlew spotlessApply

.PHONY: publish
publish:
	@./gradlew publishToMavenLocal

.PHONY: help
help:
	@echo "Available targets:"
	@echo "  all      - Format, lint, build, and generate docs"
	@echo "  build    - Build and run coverage verification"
	@echo "  clean    - Clean build artifacts"
	@echo "  test     - Run all tests"
	@echo "  apidocs  - Generate Dokka HTML documentation"
	@echo "  lint     - Run Spotless and Detekt checks"
	@echo "  format   - Auto-format with Spotless"
	@echo "  publish  - Publish to Maven Local"
	@echo "  help     - Show this help message"
