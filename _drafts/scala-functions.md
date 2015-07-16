---
layout: post
title:  "Scala Functions"
date:   2015-05-29 19:07:34
categories: Scala
---
Function definition (when the function is not recursive, the return type can be omitted):

{% highlight scala %}
def func(a: Int, b: Int): Int = a + b

def func(a: Int, b: Int) = a + b

// functions that return the Unit value ()
def f() { // deprecated - procedure syntax
    println("ABC")
}

def g(): Unit = {
    println("ABC")
}

def h() = println("ABC") // return type should always be specified for public methods
{% endhighlight %}

## By-name Parameters

In Scala, function parameter can be of two types: by-name and by-value.

{% highlight scala %}
def func(i: => Int) = i + i

func {
    println("a")
    3
}
{% endhighlight %}

## Named parameters and default values

## Topics

- named parameters and default values
- currying
- implicit parameters
- partial functions
- function types
- recursive functions & @tailrec
- variable number of parameters
- style guide
- blocks are also expressions
- return
- type parameters

## Some Links

- [http://stackoverflow.com/questions/4386127/what-is-the-formal-difference-in-scala-between-braces-and-parentheses-and-when](http://stackoverflow.com/questions/4386127/what-is-the-formal-difference-in-scala-between-braces-and-parentheses-and-when)
