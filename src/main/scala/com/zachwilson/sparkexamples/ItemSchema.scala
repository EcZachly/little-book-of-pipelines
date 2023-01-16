package com.zachwilson.sparkexamples

case class ItemSchema (
                          typeName: String,
                          itemLevelProperties: Map[String, String],
                          dataQualityThresholds: Map[String, Double]
                               )