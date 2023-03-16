# Define the default target
.DEFAULT_GOAL := build

# Define variables for the project
APP_NAME := myapp
BUILD_DIR := build
SRC_DIR := src

# Define the build target
.PHONY: build
build:
	./gradle build

# Define the clean target
.PHONY: clean
clean:
	./gradle clean
