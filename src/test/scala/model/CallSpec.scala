package model

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar

class CallSpec extends AnyFunSpec with Matchers with MockitoSugar {
  val id = "A"
  val number = "555-333-212"
  val duration = "00:02:03"

  describe("Call"){
    describe("When created"){
      it("should be given the right parameters"){
        val call = Call("A", "555-333-212", "00:02:03")
        call.id shouldBe id
        call.number shouldBe number
        call.duration shouldBe duration
      }

      it("should be able the calculate its cost"){
        val call = Call("A", "555-333-212", "00:02:03")

        call.durationCost shouldEqual 6.15
      }
    }
  }
}
