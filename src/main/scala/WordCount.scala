import scala.collection.mutable

/**
  * Created by abdhesh on 07/05/17.
  */
object WordCount {
  /**
    * With Mutable map
    *
    * @param fileName
    * @return
    */
  def wordCount(fileName: String): mutable.Map[String, Int] = {
    val source = io.Source.fromFile(fileName)
    val words = source.getLines.toSeq.flatMap(_.split(" +")).
      map(_.filter(_.isLetter).toLowerCase)
    val counts = mutable.Map[String, Int]()
    for (w <- words) {
      if (counts.contains(w)) counts += w -> (counts(w) + 1)
      else counts += w -> 1
    }
    source.close()
    counts
  }

  /**
    * immutable map
    * The function that is passed into foldLeft takes two arguments. The first is the compiled
    * value so far and the second is the value that is being operated on
    *
    * @param fileName
    * @return
    */
  def wordCount2(fileName: String): Map[String, Int] = {
    val source = io.Source.fromFile(fileName)
    val words = source.getLines.toSeq.flatMap(_.split(" +")).
      map(_.filter(_.isLetter).toLowerCase)
    val counts = words.foldLeft(Map[String, Int]())((m, w) =>
      if (m.contains(w)) m + (w -> (m(w) + 1))
      else m + (w -> 1)
    )
    source.close()
    counts
  }

  def wordCount3(fileName: String): Map[String, Int] = {
    val source = io.Source.fromFile(fileName)
    val words = source.getLines.toSeq.flatMap(_.split(" +")).
      map(_.filter(_.isLetter).toLowerCase)
    val counts = words.groupBy(f => f).map {
      case (key, values) => key -> values.length
    }
    source.close()
    counts
  }
}
