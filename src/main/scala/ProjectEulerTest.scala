/**
  * Created by bjornlonnfors on 20/12/16.
  */
object ProjectEulerTest extends App {

  val a = ProjectEuler.multipleSum(3,1000)
  val b = ProjectEuler.multipleSum(5,1000)
  val c = ProjectEuler.sameNumbersSum(a,b)
  println(a.sum + b.sum - c.sum)



}
