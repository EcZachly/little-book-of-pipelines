package com.zachwilson.sparkexamples

case class IntermediateDataset (
                               identifier: String,
                               typeName: String,
                               properties: Map[String, String],
                               // groupName is the partition
                               groupName: String
                               )
