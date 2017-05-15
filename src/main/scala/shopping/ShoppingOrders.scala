package shopping

/**
  * Created by abdhesh on 15/05/17.
  */
class ShoppingOrders {
  val cart = Cart

  def removeItem(item: Item): (Double, Double) = {
    cart.removeItem(item)
    cart.totalBill
  }

  def advanceScanCart(items: List[Item]): Unit = {
    items.foreach(cart.addItem)
    val (totalAmount, totalDiscount) = cart.totalBill
    println(f"Total:£${totalAmount}%2.2f, Discount:£$totalDiscount%2.2f ")
  }

  def scanCart(items: List[Item]): Unit = {
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
}
