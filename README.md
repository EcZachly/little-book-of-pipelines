# Little Book of Pipelines Example

Does your pipeline have over 10 unique upstream sources? Do you experience painful backfills? Do you want cleaner lines of responsibility? 


Try out the following pattern:

1. Group the sources together 

2. Come up with the shared schema. Try to optimize space here since you’re trading off some more storage for easier backfill ability. Partition the table by ds and group. 

3. Build a Scala enum that keeps track of all the groups and what items are in each group. This enum will store all the DQ-related information and anything else that is a constant value for the given group and item within that group. This enum becomes a form of self-documenting data quality code. There should be an obvious and clean mapping. One Group entry -> One Spark Job. 

4. Create an abstract class that takes in source function and an entry in the Scala enum. 

5. Transform the Scala enum into a “little book” Hive table that keeps track of all the groups and items. This table can also be used by data quality and dashboarding 

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
./gradlew build
```
- All combined
```shell script
./gradlew clean test build
```
