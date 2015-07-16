def func(i: => Int): Int = {
  println("Inside function")
  i + i
}

val res = func {
  println("evaluating")
  4
}

def f(i: Int): Int = {
  println("f")
  i
}

println(s"Result: $res")
println(func(f(5)))
