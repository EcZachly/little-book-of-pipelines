package com.zachwilson.sparkexamples

object ItemGroupEnum extends Enumeration {

  type ItemGroup = Value

  implicit def valueToGroupDetails(x: Value): ItemGroupEnum = x.asInstanceOf[ItemGroupEnum]

  case class ItemGroupEnum(
                          name: String,
                          items: List[ItemSchema]
                          )


  val GROUP_ONE = ItemGroupEnum(
    name = "group_one",
    items = List(
      ItemSchema(
        typeName = "item_one",
        dataQualityThresholds = Map(
          "non-zero-threshold" -> 0.75,
          "max-value"-> 100000.0
        ),
        itemLevelProperties = Map()
      )
    )
  )

  val GROUP_TWO = ItemGroupEnum(
    name = "group_two",
    items = List(
      ItemSchema(
        typeName = "item_two",
        dataQualityThresholds = Map(
          "non-zero-threshold" -> 0.25,
          "max-value"-> 100000.0
        ),
        itemLevelProperties = Map()
      ),
      ItemSchema(
        typeName = "item_three",
        dataQualityThresholds = Map(
          "non-zero-threshold" -> 0.1,
          "max-value"-> 1000000.0
        ),
        itemLevelProperties = Map()
      )
    )
  )

}
