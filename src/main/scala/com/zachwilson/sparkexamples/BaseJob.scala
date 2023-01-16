package com.zachwilson.sparkexamples

import com.zachwilson.sparkexamples.ItemGroupEnum.ItemGroupEnum
import org.apache.log4j.Logger
import org.apache.spark.sql.{Dataset, SparkSession}

class BaseJob (
                group: ItemGroupEnum,
                source: (SparkSession) => Dataset[IntermediateDataset]
              ) {
  val GROUP: ItemGroupEnum = group
  val JOB_NAME: String = group.name + " Job"
  val OUTPUT_DATA_TABLE: String = "schema.some_output_table"
  val LOG: Logger = Logger.getLogger(this.getClass.getCanonicalName)

  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().appName(JOB_NAME).getOrCreate()
    val df = source(spark)
    df.writeTo(OUTPUT_DATA_TABLE)
  }

}
