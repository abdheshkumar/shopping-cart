import scala.concurrent.Future

/**
  * Created by abdhesh on 07/05/17.
  */
object MonadExamples {

  sealed trait Maybe[A]

  final case class There[A](value: A) extends Maybe[A]

  final case class NotThere[A]() extends Maybe[A]

  def head1[A](as: List[A]): A = as.head

  def head[A](as: List[A]): Maybe[A] = as match {
    case Nil => NotThere[A]()
    case a :: _ => There[A](a)
  }

  def parse_config1: Result[FileError, Config] = {
    file_open("config.cfg") match {
      case Error(e) => Error(e)
      case Success(handle) =>
        file_read(handle) match {
          case Error(e) => Error(e)
          case Success(bytes) =>
            ???
        }
    }
  }

  def parse_config2: Result[FileError, Config] = {
    chain(file_open("config.cfg")) { handle =>
      chain(file_read(handle)) { bytes =>
        ???
      }
    }
  }

 /* def parse_config3: Result[FileError, Config] =
    for {
      handle <- file_open("config.cfg")
      bytes <- file_read(handle)
    } yield ???*/

  case class FileError()

  case class FileHandle()

  case class Config()

  def file_open(path: String): Result[FileError, FileHandle] = ???

  def file_read(fileHandle: FileHandle): Result[FileError, FileHandle] = ???

  // Change the `A` in a `Result[E, A]` into a `B` by using the provided
  // function `f`:
  def change[E, A, B](result: Result[E, A])(f: A => B): Result[E, B] = result match {
    case Error(e) => Error(e)
    case Success(a) => Success(f(a))
  }
Future.successful("")

  /**
    * doX match {
    * case Error(e) => Error(e)
    * case Value(x) => doY(x) match {
    * case Error(e) => Error(e)
    * case Success(y) => doZ(y) match {
    * case Error(e) => Error(e)
    * case Success(z) => doW(w) match {
    * ...
    * }
    * }
    * }
    * }
    *
    * @return
    */

  def chain[E, A, B](result: Result[E, A])(f: A => Result[E, B]): Result[E, B] =
    result match {
      case Error(e) => Error(e)
      case Success(a) => f(a)
    }


}
