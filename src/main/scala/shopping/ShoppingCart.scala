package shopping

/**
  * Created by abdhesh on 13/05/17.
  */
object ShoppingOrders {
  val items = List(
    Item("orange"),
    Item("orange"), Item("orange"), Item("orange"),
    Item("orange"), Item("apple"), Item("apple"))


  def main(args: Array[String]): Unit = {
    //val items = args.toList.map(f => Item(f.toLowerCase))
    //advanceScanCart(items)
    advanceScanCart(items)
  }

  def scanCart(items: List[Item]) = {
    val cart = Cart
    val totalAmount = items.groupBy(f => f)
      .map(f => (f._1, f._2.length))
      .map {
        case (item, numberOfItems) => item.copy(numberOfItems = numberOfItems)
      }
      .flatMap(f => cart.calculateItemPrice(f))
      .sum
    println(f"Total Balance:£$totalAmount%2.2f")
  }

  def advanceScanCart(items: List[Item]) = {
    val cart = Cart
    items.foreach(cart.addItem)
    val (totalAmount, totalDiscount) = cart.totalBill
    println(f"Total:£${totalAmount}%2.2f, Discount:£$totalDiscount%2.2f ")
  }
}
