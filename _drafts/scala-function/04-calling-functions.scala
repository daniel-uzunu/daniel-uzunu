class A {
  def f(a: Int): Int = a + 1
  def add(a: Int, b: Int) = this
}

class Main {
  val a = new A()
  val i = a f 5
  val sum: Int => String = a add (4, 5) f _ toString ()
  val sum2: Int => String = a add (4, 5) f _ toString ()

  def main(args: Array[String]) = {
    println(sum2.getClass.getSuperclass, Main.getClass)
  }
}

val m = Class.forName("Main$$anon$1$A").newInstance()

m.asInstanceOf[Main].main(Array())


