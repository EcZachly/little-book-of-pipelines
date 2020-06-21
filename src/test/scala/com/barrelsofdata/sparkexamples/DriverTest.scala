package com.barrelsofdata.sparkexamples

import java.util.Properties

import org.apache.log4j.{LogManager, Logger, PropertyConfigurator}
import org.apache.spark.sql.SparkSession
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funsuite.AnyFunSuite

class DriverTest extends AnyFunSuite with BeforeAndAfterAll {

  val JOB_NAME: String = "Driver Test Job"
  val LOGGER_PROPERTIES: String = "log4j-test.properties"
  val LOG: Logger = Logger.getLogger(this.getClass.getCanonicalName)

  var spark: SparkSession = _

  def setupLogger(): Unit = {
    val properties = new Properties
    properties.load(getClass.getClassLoader.getResource(LOGGER_PROPERTIES).openStream())
    LogManager.resetConfiguration()
    PropertyConfigurator.configure(properties)
  }

  override def beforeAll: Unit = {
    setupLogger()
    LOG.info("Setting up spark session")
    spark = SparkSession.builder().appName(JOB_NAME).master("local[*]").getOrCreate()
  }

  test("Check if spark session is working") {
    LOG.info("Testing spark job")
    assertResult("hello")(spark.sql("SELECT 'hello'").collect().head.get(0))
  }

  override def afterAll: Unit = {
    LOG.info("Closing spark session")
    spark.close()
  }

}