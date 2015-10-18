---
layout: post
title:  "Scala Generic Numbers"
date:   2015-10-10
categories: Scala
---
In Java and Scala, it's not possible to write functions that work for any numeric value as these types don't share a common base class.
<!--more-->
{% highlight scala %}
def a(x: Numeric, y: Numeric) = ???

def getValue[T, U](obj: T, memberName: String): U = ???

case class A(n: Int)

val obj = A(1)
a(getValue(obj, "n"), 6)
{% endhighlight %}

http://docs.scala-lang.org/tutorials/tour/unified-types.html
