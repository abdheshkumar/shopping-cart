package shopping

import shopping.Stock.{Discount, Offer, StockItem}


/**
  * Created by abdhesh on 13/05/17.
  */
object Stock {

  case class StockItem(name: String, price: Double)

  case class Offer(name: String, discount: Discount)

  case class Discount(buyNItems: Int, getNItems: Int)

}

class Stock {
  private val stock = List(StockItem("apple", 0.60), StockItem("orange", 0.25))
  private val offers = List(Offer("orange", Discount(2, 3)), Offer("apple", Discount(1, 2)))

  //Get item from DB
  def getStockItem(item: Item): Option[StockItem] = stock.find(_.name == item.name)

  //Get Offer from DB
  def getOffer(item: Item): Option[Offer] = offers.find(_.name == item.name)



}