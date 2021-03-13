package applicationRepository

import model.Call
import org.scalatest.PrivateMethodTester
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ApplicationRepositorySpec extends AnyFunSpec with Matchers with PrivateMethodTester {
  val path = "./src/test/resource/calls_test.app.log"
  val applicationRepository = ApplicationRepository(path)

  describe("ApplicationRepository"){
    describe("getCalls"){
      it("returns a sequence of calls given a path"){
        applicationRepository.getCalls.map(data =>
          data
            shouldBe
            Seq(
              Call("A", "555-333-212", "00:02:03"),
              Call("A", "555-433-242", "00:06:41"),
              Call("B", "555-333-212", "00:04:31"),
              Call("B", "555-334-789", "00:01:59")
            )
        )
      }
    }

    describe("getCustomer"){
      it("should be able to get all customer calls given an ID"){
        applicationRepository.getCustomer("A") shouldBe Seq(Call("A", "555-333-212", "00:02:03"), Call("A", "555-433-242", "00:06:41"))
      }
    }

    describe("getCustomerPhoneNumbers"){
      it("should be able to return all the phone numbers used by customers"){
        applicationRepository.getCustomerPhoneNumbers shouldBe Seq("555-333-212", "555-433-242", "555-334-789")
      }
    }

    describe("getTotalCustomerCallDuration"){
      it("should return the total call duration of a given number"){
        val privateMethod = PrivateMethod[Int]('getTotalCustomerCallDuration)

        applicationRepository invokePrivate privateMethod("555-333-212") shouldBe 394
      }
    }

    describe("callDurationByPhoneNumber"){
      it("should return a phone number and the total call duration for that phone number"){

        val privateMethod = PrivateMethod[Map[String, Int]]('callDurationByPhoneNumber)

        applicationRepository invokePrivate privateMethod() shouldBe Map(
          "555-333-212" -> 394,
          "555-433-242" -> 401,
          "555-334-789" -> 119
        )
      }
    }

    describe("allCustomers"){
      it("should return all customers"){
        val privateMethod = PrivateMethod[Seq[String]]('allCustomers)

        applicationRepository invokePrivate privateMethod() shouldBe Seq("A", "B")
      }
    }

    describe("amountSpentByCustomer"){
      it("should return the amount spent by a customer"){
        applicationRepository.amountSpentByCustomer shouldBe Seq(("A", 6.15), ("B", 17.68))
      }
    }
  }
}