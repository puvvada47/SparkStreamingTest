package samples

import org.apache.spark.streaming.TestSuiteBase
import org.apache.spark.streaming.dstream.DStream

import scala.collection.immutable

class SparkStreamingTest extends TestSuiteBase {
  System.setProperty("hadoop.home.dir","c://hadoop//")
  test("Spark Streaming testing") {
    val input: Seq[Range.Inclusive] = Seq(1 to 4, 5 to 8, 9 to 12)
    val operation: DStream[Int] => DStream[String] = (r: DStream[Int]) => r.map(_.toString)
    val output: Seq[immutable.IndexedSeq[String]] =input.map(_.map(_.toString))
    testOperation(input,operation,output)
  }
}









/*val input = Seq(1 to 4, 5 to 8, 9 to 12)
   testOperation(
     input,
     (r: DStream[Int]) => r.map(_.toString),
     input.map(_.map(_.toString))
   )*/




/*class BasicOperationsSuite extends AnyFunSpec with TestSuiteBase  with BeforeAndAfterAll {

  describe("Spark Streaming Testing"){

    it("Dstream Operations"){
      val input = Seq(1 to 4, 5 to 8, 9 to 12)
      val operation=(r: DStream[Int]) => r.map(_.toString)
      val output=input.map(_.map(_.toString))
      testOperation(input,operation,output)
    }
  }
}*/


