package utils.parsers
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class FileParserSpec extends AnyFunSpec with Matchers {

  val path = "./src/test/resource/calls.test.log"

  describe("FileParser"){
    describe("when run"){
      it("should be able to read from a file given the path"){
        FileParser.read(path).map(eachData => {
          eachData.length shouldBe 2
        })
      }

      it("should have the read data in the correct order"){
        FileParser.read(path).map(eachData => {
          eachData.head shouldEqual "A 555-333-212 00:02:03"
          eachData.last shouldEqual "A 555-433-242 00:06:41"
        })
      }
    }
  }
}
