---
layout:      post
title:       "How I've Learnt Haskell with my Wife"
date:        2015-08-16
categories:
- haskell
---

It was a hot summer day, the first day of our two week vacation, when I convinced my wife to learn Haskell together. We spent the first few days in our home, hiding from the sun and preparing our trip to Neptun, a small Black Sea resort. She noticed that I was very enthusiastic about reading Alessandro Baricco's novel, Mr. Gwyn. *You should read literature more often*, she said, being happy to see me excited and that I was reading a book that she read a couple of months ago. *It gives you a special kind of feeling, I haven't seen you like this for a long time. I love talking about the books we read.* The truth is that I was neglecting this passion of mine, dedicating the few time I have to small projects and learning new programming techniques. I took a moment to think and I replied, "I'm also excited about the projects I'm working on, but it's harder to explain what I do and the ideas I have. With literature is easier, I have some basic concepts. Maybe I can teach you programming." After discussing a little about it, she agreed. I promised that she can also teach me something, maybe Italian. At first I thought that I can teach her a programming language I already know, like Java or Scala. We quickly realized that it be more fun to learn a language that was new for both of us. We chose Haskell (she knew that I read a few things about it and I want to learn Haskell) and this how it all started.
<!--more-->

My wife studied literature and she wrote a PhD thesis about the feminine character from the Romanian novels written in the communist era. She also writes novels, poetry and books for children. I am a professional programmer and in different moments of my career I worked used Java, Scala, C# and JavaScript.

The next day we had our first lesson.

## Lesson #1

I was anxious to start with the first bits of syntax and I started by explaining what is ``ghci`` and how to start. She was curious about what Haskell really is, so we postponed the bits of syntax for a few minutes.

We started with literals and simple expressions:

{% highlight haskell %}
Prelude> 1+1
2
Prelude> -2
-2
Prelude> 3.4
3.4
Prelude> 1==1
True
Prelude> 1==2
False
Prelude> False
False
Prelude> True
True
Prelude> "wife"
"wife"
Prelude> 'a'
'a'
Prelude> 0.1+0.2
0.30000000000000004
Prelude> 0.1+0.1
0.2
Prelude> 987-23
964
Prelude> 4*2
8
Prelude> 21345/9
2371.6666666666665
Prelude> (1+1)*3
6
Prelude> 1+1*3
4
Prelude> "wife"=="wife"
True
Prelude> "wife"/="wife"
False
Prelude> 3<1
False
Prelude> 1<3&&4+3<8
True
Prelude> 1 < 3 && 4 + 3 < 8
True
Prelude> True || False
True
Prelude> not True
False
{% endhighlight %}

We saw the first complaints from the compiler and I surprised her with floating point arithmetics.

We moved on to variables:

{% highlight haskell %}
Prelude> let n = 3
Prelude> n
3
Prelude> n*2
6
Prelude> let a = n*n
Prelude> a
9
Prelude> a+n
12
Prelude> a>n
True
{% endhighlight %}

Then calling functions (the compiler complains again):

{% highlight haskell %}
Prelude> min 9 10
9
Prelude> min -3.1 -2

<interactive>:36:1:
    No instance for (Ord a0) arising from a use of `min'
    The type variable `a0' is ambiguous
    Possible fix: add a type signature that fixes these type variable(s)
    Note: there are several potential instances:
      instance Integral a => Ord (GHC.Real.Ratio a)
        -- Defined in `GHC.Real'
      instance Ord Integer -- Defined in `integer-gmp:GHC.Integer.Type'
      instance Ord a => Ord (Maybe a) -- Defined in `Data.Maybe'
      ...plus 23 others
    In the first argument of `(-)', namely `min'
    In the first argument of `(-)', namely `min - 3.1'
    In the expression: min - 3.1 - 2

<interactive>:36:6:
    No instance for (Fractional (a0 -> a0 -> a0))
      arising from the literal `3.1'
    Possible fix:
      add an instance declaration for (Fractional (a0 -> a0 -> a0))
    In the second argument of `(-)', namely `3.1'
    In the first argument of `(-)', namely `min - 3.1'
    In the expression: min - 3.1 - 2

<interactive>:36:10:
    No instance for (Num (a0 -> a0 -> a0)) arising from a use of `-'
    Possible fix:
      add an instance declaration for (Num (a0 -> a0 -> a0))
    In the expression: min - 3.1 - 2
    In an equation for `it': it = min - 3.1 - 2
Prelude> min 3.1 2
2.0
Prelude> min (-3.1) (-2.0)
-3.1
Prelude> succ 5 + max 3 2 + 1
10
{% endhighlight %}

Then we wrote some functions. With ``doubleUs2`` she said that I tricked her, but at the next exercise she named the function ``love`` and she was happy being able to write the function.

{% highlight haskell %}
doubleMe x = x + x
doubleUs x y = x * 2 + y * 2
finding x y = 2 * x < y
doubleUs2 x y = doubleMe x + doubleMe y
love x y z = x + y + z
{% endhighlight %}

{% highlight haskell %}
Prelude> :l learn-haskell
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> doubleMe 5
10
*Main> :l learn-haskell
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> doubleMe 5
10
*Main> doubleUs 5 3
16
*Main> :l learn-haskell
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> finding 7 9
False
*Main> 7 <= 7
True
*Main> 7 >= 7
True
*Main> 8 >= 7
True
*Main> 4 >= 7
False
*Main> sqrt 4
2.0
*Main> :l learn-haskell
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> doubleUs 5 3
16
*Main> doubleUs2 5 3
16
*Main> :l learn-haskell
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> love 32 12 11
55
*Main> let i = love 3 4 5
*Main> doubleMe i
24
*Main> i
12
{% endhighlight %}

## Lesson #2

In the second lesson, we learnt about if, lists and tuples.

{% highlight haskell %}
doubleMe x = x + x
doubleUs x y = x * 2 + y * 2
finding x y = 2 * x < y
doubleUs2 x y = doubleMe x + doubleMe y
love x y z = x + y + z
isEven x = mod x 2 == 0
leaf x = if isEven x then x * 2 else x + 1
min17 a b = if a < b then a else b
maxT z q = if z > q then z else q

compare2 a b =
  if a == b
    then 0
    else if a < b
      then -1
      else 1
{% endhighlight %}

{% highlight haskell %}
Prelude> 85 + 2
87
Prelude> let i = 3
Prelude> i
3
Prelude> min 4 5
4
Prelude> :l learn-haskell.hs
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> love 1 2 3
6
*Main> 3 / 2
1.5
*Main> div 3 2
1
*Main> mod 3 2
1
*Main> mod 5 3
2
*Main> div 5 3
1
*Main> :l learn-haskell.hs
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> thomas 4
True
*Main> thomas 5
False
*Main> if 3 > 2 then 5 * 2 else 3
10
*Main> :l learn-haskell.hs
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> leaf 3
4
*Main> leaf 10
20
*Main> :l learn-haskell.hs
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> min17 20 1
1
*Main> :l
:list  :load
*Main> :l
:list  :load
*Main> :load learn-haskell.hs
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> maxT 65 43
65
*Main> if True then if 3 > 2 then 4 else 3 else 2
4
*Main> if True then (if 3 > 2 then 4 else 3) else 2
4
*Main> compare 1 2
LT
*Main> compare 2 2
EQ
*Main> compare 2 3
LT
*Main> compare 2 1
GT
*Main> :load learn-haskell.hs
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> compare2 1 2
-1
*Main> compare 2 2
EQ
*Main> compare2 2 2
0
*Main> compare2 2 2
0
*Main> compare2 2 1
1
*Main> [1, 2, 4]
[1,2,4]
*Main> ["a", "b"]
["a","b"]
*Main> ["z", "l", "qw", "cvfder"]
["z","l","qw","cvfder"]
*Main> let l = [1, 2, 4]
*Main> l ++ [2, 1, 10]
[1,2,4,2,1,10]
*Main> "hello" ++ " " ++ "babe"
"hello babe"
*Main> ['a', 'b']
"ab"
*Main> head l
1
*Main> tail l
[2,4]
*Main> init l
[1,2]
*Main> last l
4
*Main> []
[]
*Main> reverse [2, 3]
[3,2]
*Main> (1, "hello")
(1,"hello")
*Main> (1, "hello", 1.2)
(1,"hello",1.2)
*Main> let c = (1, "hello", 1.2)
*Main> fst (1, "as")
1
*Main> snd (1, "as")
"as"
*Main> head [1..]
1
*Main> head [1..]
1
*Main> take 6 [1..]
[1,2,3,4,5,6]
*Main> [1..]
{% endhighlight %}

## Lesson #3

As some time passed since the last lesson, we started by recapitulating what we did in the previous lessons. Then we learned some more things about lists. And then some things about types.

{% highlight haskell %}
sky x y = (x + y) / 2

dante l n = sum (take n l)
factorial n = product [1..n]
sumN n = sum (take n [0,2..])
{% endhighlight %}

{% highlight haskell %}
Prelude> :load learn-haskell.hs
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> doubleMe 5
10
*Main> compare2 3 5
-1
*Main> isEven 2
True
*Main> [1, 2]
[1,2]
*Main> head [1, 2, 3]
1
*Main> tail ['a', 'e', 't', 'p']
"etp"
*Main> last ['a', 'e', 't', 'p']
'p'
*Main> length [9, 555]
2
*Main> [1, 2, 3] !! 2
3
*Main> [1, 2, 3] !! 0
1
*Main> [1, 2, 3] !! 1
2
*Main> sum [23, 44, 339]
406
*Main> product [4, -2, -90]
720
*Main> product [4, -2, -90, 2.3]
1655.9999999999998
*Main> [1, 2] > [2, 3]
False
*Main> [2, 3] == [2, 3]
True
*Main> take 2 [1, 2, 220]
[1,2]
*Main> drop 2 [1, 2, 220]
[220]
*Main> drop 3 [1, 2, 221]
[]
*Main> null []
True
Prelude> :reload
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> sky 7 8
7.5
Prelude> :reload
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> dante [2, 44, 21] 2
46
*Main> [1..10]
[1,2,3,4,5,6,7,8,9,10]
*Main> [1,3..10]
[1,3,5,7,9]
*Main> [1,3..50]
[1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49]
*Main> [1,5..50]
[1,5,9,13,17,21,25,29,33,37,41,45,49]
*Main> :reload
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> factorial 5
120
*Main> :reload
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> sumN 3
12
*Main> sumN 9
90
*Main> take 5 [1..]
[1,2,3,4,5]
*Main> take 5 [1, 3..]
[1,3,5,7,9]
*Main> take 10 [1, 3..]
[1,3,5,7,9,11,13,15,17,19]
*Main> :r
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> sumN 9
72
*Main> :t 5
5 :: Num a => a
*Main> :t 'a'
'a' :: Char
*Main> let i = 5
*Main> :t i
i :: Integer
*Main> :t dante
dante :: Num a => [a] -> Int -> a
*Main> let x = 2.3
*Main> :t x
x :: Double
*Main> :t doubleMe
doubleMe :: Num a => a -> a
*Main> :t doubleMe 5
doubleMe 5 :: Num a => a
*Main> :t True
True :: Bool
*Main> let l = [2, 4]
*Main> :t l
l :: [Integer]
*Main> doubleMe 2.5
5.0
*Main> :reload
[1 of 1] Compiling Main             ( learn-haskell.hs, interpreted )
Ok, modules loaded: Main.
*Main> doubleMe 2.5

<interactive>:90:10:
    No instance for (Fractional Integer) arising from the literal `2.5'
    Possible fix: add an instance declaration for (Fractional Integer)
    In the first argument of `doubleMe', namely `2.5'
    In the expression: doubleMe 2.5
    In an equation for `it': it = doubleMe 2.5
*Main> doubleMe 2
4
{% endhighlight %}

{% highlight haskell %}
doubleMe :: Integer -> Integer
doubleMe x = x + x
{% endhighlight %}

## Some material

http://adriann.github.io/programming_problems.html
http://programmers.stackexchange.com/questions/96504/how-can-i-teach-a-bright-person-with-no-programming-experience-how-to-program
