#!/usr/bin/env scala

import scala.annotation.tailrec

case class Person(name: String, age: Int)

val person = Person(
    name = "John Doe",
    age = 37
)

println(person.name)

println("###  generate all permutations of a set ###")

// 1 2 3 => 123, 132, 213, 231, 312, 321

// 1 23 => 12 3, 13 2
// 2 13
// 3 12

def permutations[A](set: Set[A]): Set[List[A]] = {
    if (set.isEmpty) {
        Set(List())
    }  else {
        set.flatMap(item => permutations(set - item).map(item :: _))
    }
}

println(permutations(Set()))

println(permutations(Set(1)))

println(permutations(Set(1, 2)))

println(permutations((1 to 3).toSet))
System.exit(0)

println("### By-name parameters ###")

def func(i: => Int): Int = {
    println("Inside function")
    i + i
}

val res = func {
    println("evaluating")
    4
}

println(s"Result: $res")

println("### currying ###")

def add(a: Int)(b: Int) = a + b

def add3 = add(3)_

def f(fn: Int => Int, n: Int) = fn(n)

println(f(add(2), 7))

def fn(f: (Int, Int) => Int)(x: Int, y: Int) = f(x, y)

def r = fn(_ + _)_


println(r(4, 9))

println("### recursive functions ###")

@tailrec
def recursiveFunc(i: Int): Int = {
    if (i == 0) 0 else recursiveFunc(i - 1)
}

println(s"Rec: ${recursiveFunc(10)}")
