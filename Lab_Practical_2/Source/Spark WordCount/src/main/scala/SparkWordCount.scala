import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by Barath on 31-Jan-17.
  */
object SparkWordCount {

  def main(args: Array[String]) {
    /*uncomment below if you are running in windows and also point to hadoop*/
    //System.setProperty("hadoop.home.dir","C:\\Users\\barath\\Documents\\UMKC Subjects\\PB\\hadoopforspark");

    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val sc=new SparkContext(sparkConf)

    //input1 and input2 contain different source of NEWS
    val input1=sc.textFile("input1")

    val input2=sc.textFile("input2")

    //Applying flatmap to first text file - First Transformation 1a
    val wordCount1=input1.flatMap(line=>{line.split(" ")}).map(word=>(word,1)).cache()

    //Applying flatmap to second text file - First Transformation 1b
    val wordCount2=input2.flatMap(line=>{line.split(" ")}).map(word=>(word,1)).cache()

    //Applying union to two different RDD - Second Transformation 2
    val finalwc =wordCount2.union(wordCount1).cache()

    //Reduce the RDD by Key to output file- First Action 1
    val output=finalwc.reduceByKey(_+_)

    output.saveAsTextFile("output")

    //Displaying the RDD by Key to console - Second Action 2
    output.collect().foreach(println)

  }

}