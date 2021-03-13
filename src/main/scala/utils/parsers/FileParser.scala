package utils.parsers
import java.io.{FileNotFoundException, IOException}
import scala.language.reflectiveCalls

import scala.io.Source
object FileParser {

  def read(path: String): Either[Unit, Seq[String]] = {
    try {
      val source = Source.fromFile(path)
      Right((for(data <- source.getLines()) yield data).toSeq)
    } catch {
      case error: FileNotFoundException => Left(println(s"File not found -> Make sure the file path matches this: ${error}"))
      case error: IOException           => Left(println(s"Got an IOException! -> ${error}"))
    }
  }
}
