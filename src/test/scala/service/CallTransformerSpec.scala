package service

import model.Call
import org.scalatest.PrivateMethodTester
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CallTransformerSpec extends AnyFunSpec with Matchers with PrivateMethodTester{

  describe("CallTransformer"){
    describe("transform when given a list of string"){
      it("can transform the strings to calls"){
        val data = Seq("A 555-333-212 00:02:03", "A 555-433-242 00:06:41")
        CallTransformer.transform(data) shouldBe Seq(Call("A", "555-333-212", "00:02:03"), Call("A", "555-433-242", "00:06:41"))
      }
    }

    describe("splitter when passed a call log"){
      it("should be able to split it in the right components"){
        val callLog = "A 555-333-212 00:02:03"
        val splitCallLog = PrivateMethod[Seq[String]]('splitter)
        CallTransformer invokePrivate splitCallLog(callLog) shouldBe Seq("A", "555-333-212", "00:02:03")
      }
    }
  }
}
