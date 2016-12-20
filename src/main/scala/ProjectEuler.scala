/**
  * Created by bjornlonnfors on 20/12/16.
  */
import scala.collection.mutable._
import scala.math._
object ProjectEuler {

  def multipleSum(num: Int, res: Int) = {
    val multiples = Buffer[Int]()

    for(a <- 1 until res){
      if(a % num == 0){
        multiples += a
      }
    }
    multiples.toVector

  }

  def sameNumbersSum(vec1: Vector[Int], vec2: Vector[Int]): Vector[Int] = {

    val b = Buffer[Int]()
    for(z <- vec1){
      if(vec2.contains(z)){
        b += z
      }

    }

    b.toVector

  }




}
