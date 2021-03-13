package utils.parsers

import org.scalatest.PrivateMethodTester
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class TimeConverterSpec extends AnyFunSpec with Matchers with PrivateMethodTester {

  describe("TimeConverter"){
    describe("convertHoursToSecs"){
      it("should convert hours to second"){
        val convertHoursToSeconds = PrivateMethod[Int]('convertHoursToSeconds)

        TimeConverter invokePrivate  convertHoursToSeconds(1) shouldBe(3600)
        TimeConverter invokePrivate  convertHoursToSeconds(2) shouldBe(7200)
      }
    }

    describe("convertMinutesToSecs"){
      it("should convert minutes to seconds"){
        val convertMinutesToSecs = PrivateMethod[Int]('convertMinutesToSecs)

        TimeConverter invokePrivate convertMinutesToSecs(1) shouldBe(60)
        TimeConverter invokePrivate convertMinutesToSecs(2) shouldBe(120)
      }
    }

    describe("convertCallDurationToSeconds"){
      it("should convert call duration to seconds"){
        TimeConverter("00:02:03").convertCallDurationToSeconds shouldBe(123)
        TimeConverter("00:03:00").convertCallDurationToSeconds shouldBe(180)
      }
    }
  }
}
