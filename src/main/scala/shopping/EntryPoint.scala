package shopping

/**
  * Created by abdhesh on 13/05/17.
  */
object EntryPoint {
  val items = List(
    Item("orange"),
    Item("orange"), Item("orange"), Item("orange"),
    Item("orange"), Item("apple"), Item("apple"))


  def main(args: Array[String]): Unit = {
    val shoppingOrders = new ShoppingOrders()
    shoppingOrders.advanceScanCart(items)
    println(shoppingOrders.removeItem(Item("apple")))
  }
}

