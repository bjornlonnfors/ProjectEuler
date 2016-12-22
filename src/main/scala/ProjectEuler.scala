/**
  * Created by bjornlonnfors on 20/12/16.
  */
import scala.collection.mutable._
import util.control.Breaks._
import scala.math._

object ProjectEuler {

  //Problem 1:



  /**
    * Takes all the multiples of a number with given restraint and places them in a vector
    * @param num multiples of wich number
    * @param res until what number do you want the multiples
    * @return all the multiples in a vector
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
    * @return a vector with all the number that occur twice
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


  // Problem 4

  // Find the largest palindrome made from the product of two 3-digit numbers.

  /**
    * Checks if the number is a palindrome recursively
    * @param number takes a number in form of a string
    * @return Boolean
    */


  def palindrome(number: String): Boolean = {


    if(number.length <= 1) true

    else if (number(0) == number.last) palindrome(number.slice(1,number.length - 1))

    else false


  }

  /**
    * Finds the largest palindrome that is a product of 2 3 - digit number
    * @param number useless
    * @return Int
    */



  def testPalindrome(number: Int): Int = {

    val stop  = Buffer[Int]()


    breakable {
    for (a <- 100 to 999; b <- 100 to 999) {

      if (ProjectEuler.palindrome((a * b).toString)) {

        stop += a * b

      }

      }
    }

    stop.sorted.last
  }


  // Problem 5:

  // What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

  // Brute force

  /**
    * Checks if a certain number is a prime
    * @param n Checks if this number is a prime
    * @return Boolean
    */

  def isPrime(n: Int) = (2 until n).forall(n % _ != 0) // Takes modulus of all number from 2 until the number wich is checked. If all is not == 0 then it's a prime

  def findPrime(res: Int): Vector[Int] = {
    val resultBuffer = Buffer[Int]()

    for(a <- 3 to res){
      if(isPrime(a)) resultBuffer += a
    }
    resultBuffer.toVector
  }

  /**
    * Finds all the ??Exponentials?? of a certain number until a certain number,ex whatnum = 2 and untilWhat = 20, returns Vector(2,4,8,16)
    * @param whatnum Wich number exponentials do you want
    * @param untilWhat Until what number do you want your exponentials
    * @return Vector
    */

  def findPotens(whatnum: Int,untilWhat: Int): Vector[Int] = {
    val findBuffer = Buffer(whatnum)


    while(findBuffer.last < untilWhat){
      findBuffer += findBuffer.last * whatnum
    }
    findBuffer.dropRight(1).toVector
  }


  /**
    * Finds the smallest possible number that has % == 0 from 1 to res. Does this by taking all the primes and the highest exponential of all numbers
    * @param res 1 to what
    * @return Int
    */

  def divisible(res: Int): Int = {
    val endVector = findPrime(res).toBuffer

    for(a <- 2 to sqrt(res).toInt){
      endVector += findPotens(a,res).sorted.last
    }

    endVector.sorted.distinct

    for(a <- 2 to sqrt(res).toInt){
      for(b <- findPotens(a,res).dropRight(1)){
        if(endVector.contains(b)) endVector.remove(endVector.indexOf(b))

      }
    }



    endVector.sorted.distinct.product


  }








}
