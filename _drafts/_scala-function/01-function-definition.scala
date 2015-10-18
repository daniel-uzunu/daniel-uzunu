/*
Function definition (when the function is not recursive, the return type can be omitted).

The return type should always be specified for public methods.

In Scala, the return value of a function is the last computed expression.
The return keyword exists, but it should be avoided: https://tpolecat.github.io/2014/05/09/return.html
*/
def func(a: Int, b: Int): Int = a + b

def func1(a: Int, b: Int) = a + b

// functions that return the Unit value ()
def f() { // deprecated - procedure syntax
  println("ABC")
}

def g(): Unit = {
  println("ABC")
}

def h() = println("ABC")

def k = {
  println("k")
  3 + 5
}

// k() -- this is an error

println("func(3, 5): " + func(3, 5))
println("func1(3, 5): " + func1(3,  5))

lazy val a = k + k

println(f, g, h(), a)
