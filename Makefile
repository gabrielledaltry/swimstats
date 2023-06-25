OUT_DIR := bin

.PHONY: build
build:
	javac -d $(OUT_DIR) ./*.java 

.PHONY: clean
clean:
	rm -rf $(OUT_DIR)