OUT_DIR := bin

.PHONY: build
build:
	javac -d $(OUT_DIR) swimstats/*.java 

.PHONY: clean
clean:
	rm -rf $(OUT_DIR)

.PHONY: run
run: build
	java -cp $(OUT_DIR) swimstats.App