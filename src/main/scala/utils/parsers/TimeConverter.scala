package utils.parsers

case class TimeConverter(callDuration: String) {
  import  TimeConverter._

  def convertCallDurationToSeconds: Int = {
    val duration = callDuration.split(":").map(_.toInt)
    time(duration(0), duration(1), duration(2))
  }
}

object TimeConverter {
  import TimeConversion._

  private object TimeConversion {
    val `anHourInSeconds` = 3600
    val `aMinuteInSeconds` = 60
  }

  private def time(hour: Int, min:Int, sec:Int): Int = {
    convertHoursToSeconds(hour) + convertMinutesToSecs(min) + sec
  }

  private def convertHoursToSeconds(hour: Int)   : Int   = `anHourInSeconds` * hour
  private def convertMinutesToSecs (minutes: Int): Int   = `aMinuteInSeconds` * minutes
}