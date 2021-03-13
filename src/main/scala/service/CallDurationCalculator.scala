package service

sealed trait Duration
final case object BeforeThreeMinutes extends Duration
final case object AfterThreeMinutes extends  Duration

object CallDurationCalculator {
  import Tariff._

  private  object Tariff {
    val `before3Min` = 0.05
    val `after3Min`  = 0.03
  }

  def cost(callDuration: Int): Double = {
    duration(callDuration) match {
      case BeforeThreeMinutes => callDuration * `before3Min`
      case AfterThreeMinutes  => 9 + (callDuration - 180) * `after3Min`
    }
  }

  private def duration(callDuration: Int): Duration = {
    if(callDuration <= 180) BeforeThreeMinutes
    else AfterThreeMinutes
  }
}
