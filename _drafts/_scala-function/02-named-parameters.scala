/*
http://docs.scala-lang.org/tutorials/tour/named-parameters.html
*/

// When calling methods and functions, you can use the name of the variables expliclty in the call.

def printName(first:String, last:String) = {
  println(first + " " + last)
}
printName("John", "Smith")
// Prints "John Smith"
printName(first = "John", last = "Smith")
// Prints "John Smith"
printName(last = "Smith", first = "John")
// Prints "John Smith"

// Note that once you are using parameter names in your calls, the order doesn’t matter, so long as all parameters are named.
// This feature works well with default parameter values

def printName1(first:String = "John", last:String = "Smith") = {
  println(first + " " + last)
}

printName1(last = "Jones")
// Prints "John Jones"

printName1("aaa", last = "bb")

implicit val someInt = 3

def f(a: Int)(b: Int = a * 2) = b
def g(a: Int)(implicit b: Int = a * 2) = b

val a = f(3)()
val b = g(3)

println(a, b)
