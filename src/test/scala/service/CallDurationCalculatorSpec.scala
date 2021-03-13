package service

import org.scalatest.PrivateMethodTester
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CallDurationCalculatorSpec extends AnyFunSpec with Matchers with PrivateMethodTester {
  describe("CallDurationCalculator"){
    describe("duration - when given a call duration in seconds"){
      it("should return the right duration type if duration is equal to 180 seconds"){
        val duration = PrivateMethod[Duration]('duration)

        CallDurationCalculator invokePrivate duration(180) shouldBe BeforeThreeMinutes
      }

      it("should return the right duration type if duration is greater than 180 seconds"){
         val duration = PrivateMethod[Duration]('duration)

         CallDurationCalculator invokePrivate duration(400) shouldBe AfterThreeMinutes
      }
    }

    describe("CallCost"){
      it("should be able to calculate the cost of a call below or equal 3 minutes"){
        CallDurationCalculator.cost(180) shouldBe 9
        CallDurationCalculator.cost(126) shouldBe 6.300000000000001
      }

      it("should be able to calculate the cost of a call after 3 minutes"){
        CallDurationCalculator.cost(181) shouldBe 9.03
        CallDurationCalculator.cost(426) shouldBe 16.38
      }
    }
  }
}
