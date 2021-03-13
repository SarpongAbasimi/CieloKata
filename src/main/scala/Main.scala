import applicationRepository.ApplicationRepository
import java.util.{Currency, Locale}

object Main {
  def main(args: Array[String]): Unit = {
    val resourcePath = "./src/resource/calls.log"

    val applicationCurrency = Currency.getInstance(Locale.UK)

     ApplicationRepository(resourcePath).amountSpentByCustomer.foreach(customer => {
       println(s"Customer ${customer._1} total cost of calls for the day ${applicationCurrency} ${customer._2}")
     })
  }
}
