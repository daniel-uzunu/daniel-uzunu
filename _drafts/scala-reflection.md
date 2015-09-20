---
layout: post
title:  "Scala Reflection"
date:   2015-09-20
categories: Scala
---
In this article, I will explore how to get the value of vals, vars and methods with no arguments using reflection. I'll present three solutions for this problem: using Java reflection, using Scala reflection and using Scala macros (compile-time reflection).
<!--more-->

The function I want to implement takes two arguments: an object and the name of the method to be invoked.

{% highlight scala %}
def getValue[T](obj: T, memberName: String): Any = ???
{% endhighlight %}

As I started exploring this problem in the context of a validation library, the most important use case is getting the value for the fields of a case class.

{% highlight scala %}
case class Person(name: String, age: Int)

val p = Person("John Doe", 31)

getValue(p, "name")
getValue(p, "age")
{% endhighlight %}

However, the implementation also works with regular classes and it can obtain the value for vals, vars and methods that are declared in the class itself or inherited.

{% highlight scala %}
class Person(val firstName: String, val lastName: String, val age: Int) {
  var index = 0

  def fullName = firstName + " " + lastName

  def show(): String = {
    println(firstName)
    firstName
  }
}

val p = new Person("John", "Doe", 31)

getValue(p, "firstName")
getValue(p, "index")
getValue(p, "fullName")
getValue(p, "show")
getValue(p, "toString")
{% endhighlight %}

Note: no error handling is implemented in order to keep the code simple. The implementations are behaving differently for invalid input.

## Java Reflection

The implementation using Java reflection is pretty straight forward. It obtains a `Method` object by name and invokes it on `obj`.

{% highlight scala %}
def getValue[T](obj: T, methodName: String): Any = {
  val method = obj.getClass.getMethod(methodName)
  method.invoke(obj)
}
{% endhighlight%}

What might come as a surprise is that we are searching for methods, even though the implementation should also work vals and vars.

http://alvinalexander.com/scala/scala-class-to-decompiled-java-source-code-classes
