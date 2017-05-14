/**
  * Created by abdhesh on 06/05/17.
  */
object BubbleSort extends App {

  //This is the comment
  def bubbleSort[A <% Ordered[A]](a: Array[A]) {
    for (i <- 0 until a.length; j <- 0 until a.length - 1 - i) {
      if (a(j + 1) < a(j)) {
        val tmp = a(j)
        a(j) = a(j + 1)
        a(j + 1) = tmp
      }
    }
  }

  List(1, 2, 3).sorted
  bubbleSort(Array(1, 2, 3))

  import scala.math._

  def sort[A: Ordering](as: List[A]): List[A] = as match {
    case Nil => Nil
    case a :: as =>
      val (before, after) = as partition (implicitly[Ordering[A]].lt(_, a))

      sort(before) ++ (a :: sort(after))
  }
}

