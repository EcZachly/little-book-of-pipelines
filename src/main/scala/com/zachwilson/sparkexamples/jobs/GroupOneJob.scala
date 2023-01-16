package com.zachwilson.sparkexamples.jobs

import com.zachwilson.sparkexamples.{BaseJob, IntermediateDataset, ItemGroupEnum}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object GroupOneJob extends BaseJob(
  group = ItemGroupEnum.GROUP_ONE,
  source = (spark: SparkSession)=> {
    import spark.implicits._
    spark.table("schema.some_other_input_table")
      .withColumn("identifier", $"input_table_id")
      .withColumn("typeName", lit("item_one"))
      .withColumn("properties", map(lit("property1"), $"property1Column"))
      .withColumn("groupName", lit(ItemGroupEnum.GROUP_TWO))
      .as[IntermediateDataset]
  }
)
