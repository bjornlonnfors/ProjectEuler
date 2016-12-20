/**
  * Created by bjornlonnfors on 20/12/16.
  */
import scala.collection.mutable._

object ProjectEuler {

  //Problem 1:



  /**
    * Takes all the multiples of a number with given restraint and places them in a vector
    * @param num
    * @param res
    * @return
    */

  def multiple(num: Int, res: Int) = {
    val multiples = Buffer[Int]()

    for(a <- 1 until res){
      if(a % num == 0){
        multiples += a
      }
    }
    multiples.toVector

  }

  /**
    * Takes two(2) vectors and removes the repeat.
    * @param vec1
    * @param vec2
    * @return
    */

  def sameNumbers(vec1: Vector[Int], vec2: Vector[Int]): Vector[Int] = {

    val b = Buffer[Int]()

    for(z <- vec1){
      if(vec2.contains(z)){
        b += z
      }
    }

    b.toVector
  }


  // Problem 2:


  /**
    * Finds all the fibonacci number below the restraining number you give and sums them up
    * @param res Finds all fibonacci numbers that are less than this number
    * @return sum of all even fibonaccis under a given restraint
    */

  def fibonacci(res: Int) = {

    val fibo = Buffer(1,2)

    do{

      fibo += fibo.last + fibo(fibo.length - 2)

    }while(fibo.last < res)

    fibo.dropRight(1).filter(_ % 2 == 0).sum


  }


  // Problem 3:


  // What is the largest prime factor of the number 600851475143 ?


  def largestPrimeFactor(b : BigInt) = {

    def loop(f:BigInt, n: BigInt): BigInt = {

      if (f == n) n

      else if (n % f == 0) loop(f, n / f)

      else loop(f + 1, n)
    }
    loop (BigInt(2), b)
  }





















}
