package com.barrelsofdata.sparkexamples

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession

object Driver {

  val JOB_NAME: String = "Boilerplate"
  val LOG: Logger = Logger.getLogger(this.getClass.getCanonicalName)

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder().appName(JOB_NAME).getOrCreate()
    spark.sql("SELECT 'hello' AS col1").show()

    LOG.info("Dummy info message")
    LOG.warn("Dummy warn message")
    LOG.error("Dummy error message")
  }

}
