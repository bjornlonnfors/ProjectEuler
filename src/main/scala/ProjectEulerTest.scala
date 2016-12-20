/**
  * Created by bjornlonnfors on 20/12/16.
  */
object ProjectEulerTest extends App {


  // Problem 1

  val a = ProjectEuler.multiple(3,1000)
  val b = ProjectEuler.multiple(5,1000)
  val c = ProjectEuler.sameNumbers(a,b)
  println(a.sum + b.sum - c.sum)

  // Problem 2

  println(ProjectEuler.fibonacci(4000000))



}
