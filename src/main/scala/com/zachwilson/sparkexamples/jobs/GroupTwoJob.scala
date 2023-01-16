package com.zachwilson.sparkexamples.jobs

import com.zachwilson.sparkexamples.{BaseJob, IntermediateDataset, ItemGroupEnum}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object GroupTwoJob extends BaseJob(
  group = ItemGroupEnum.GROUP_TWO,
  source = (spark: SparkSession)=> {
    import spark.implicits._
    val itemTwo = spark.table("schema.some_input_table")
      .withColumn("identifier", $"input_table_id")
      .withColumn("typeName", lit("item_two"))
      .withColumn("properties", map(lit("property1"), $"property1Column"))
      .withColumn("group", lit(ItemGroupEnum.GROUP_TWO))

    val itemThree = spark.table("schema.some_input_table")
      .withColumn("identifier", $"input_table_id")
      .withColumn("typeName", lit("item_three"))
      .withColumn("properties", map(lit("property2"), $"property2Column"))
      .withColumn("group", lit(ItemGroupEnum.GROUP_TWO))


    itemTwo.union(itemThree).as[IntermediateDataset]
  }
)
