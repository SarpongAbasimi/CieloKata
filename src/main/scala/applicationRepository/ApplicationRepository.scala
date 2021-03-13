package applicationRepository

import model.Call
import service.CallTransformer
import utils.parsers.{FileParser, TimeConverter}


case class ApplicationRepository(path: String){

  def getCalls: Either[Unit, Seq[Call]] = {
    FileParser.read(this.path).map(data => CallTransformer.transform(data))
  }

  def getCustomer(customerID: String): Seq[Call] = {
    this.getCalls.toSeq.flatMap(e => e).filter(customer => customer.id.equals(customerID))
  }

  def getCustomerPhoneNumbers: Seq[String] = {
    this.getCalls.toSeq.flatMap(listOfCustomerCalls => listOfCustomerCalls).map(customer => customer.number).distinct
  }

  def amountSpentByCustomer: Seq[(String, Double)] = {
    this.allCustomers.map(customer =>
      (customer,
        this.getCustomer(customer)
        .filterNot(_.number.equals(this.callDurationByPhoneNumber.maxBy(_._2)._1))
        .map(_.durationCost).reduceOption(_ + _).getOrElse(0.0)))

  }

  private def callDurationByPhoneNumber: Map[String, Int] = {
    this.getCustomerPhoneNumbers.map(eachNumber => (eachNumber, this.getTotalCustomerCallDuration(eachNumber))).toMap
  }

  private def allCustomers: Seq[String] = {
    this.getCalls.toSeq.flatMap(listOfCalls => listOfCalls).map(_.id).distinct
  }

  private def getTotalCustomerCallDuration(aPhoneNumber: String): Int = {
    this.getCalls.toSeq.flatMap(listOfCalls => listOfCalls)
      .filter(eachCustomerCall => eachCustomerCall.number.equals(aPhoneNumber))
      .map(call=> TimeConverter(call.duration).convertCallDurationToSeconds)
      .fold(0)(_ + _)
  }
}
