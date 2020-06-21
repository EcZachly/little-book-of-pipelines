# Spark Boilerplate
This is a boilerplate project for Apache Spark. The related blog post can be found at [https://www.barrelsofdata.com/spark-boilerplate-using-scala](https://www.barrelsofdata.com/spark-boilerplate-using-scala)

## Build instructions
From the root of the project execute the below commands
- To clear all compiled classes, build and log directories
```shell script
./gradlew clean
```
- To run tests
```shell script
./gradlew test
```
- To build jar
```shell script
./gradlew shadowJar
```
- All combined
```shell script
./gradlew clean test shadowJar
```

## Run
```shell script
spark-submit --master yarn --deploy-mode cluster build/libs/spark-boilerplate-1.0.jar
```