package model

import service.CallDurationCalculator
import utils.parsers.TimeConverter

case class Call(id: String, number: String, duration: String) {
  def durationCost: Double = {
    CallDurationCalculator.cost(TimeConverter(this.duration).convertCallDurationToSeconds)
  }
}
