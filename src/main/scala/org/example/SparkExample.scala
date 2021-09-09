package org.example

import org.apache.spark.sql.SparkSession

object SparkExample {

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","c://hadoop//")
    val spark = SparkSession.builder()
      .appName("SparkByExample")
      .master("local")
      .getOrCreate()

    val longAcc = spark.sparkContext.longAccumulator("SumAccumulator")

    val rdd = spark.sparkContext.parallelize(Array(1, 2, 3))
    rdd.foreach(x => longAcc.add(x))
    println(s"accumulator count: ${longAcc.value}")
  }

}
