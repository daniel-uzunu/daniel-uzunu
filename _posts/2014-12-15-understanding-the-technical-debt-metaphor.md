---
layout:      post
title:       "Understanding the Technical Debt Metaphor"
date:        2014-12-15
categories:
- software development
tags:
- software development
- technical debt
- metaphor
---
It is not easy to explain to non-technical people why design is important. They want to see the features implemented while minimizing the amount of time and money allocated for building the system. Technical debt is a useful concept in these situations as it is easy to understand by both technical and non-technical persons. In this article I will explain what technical debt is, when it is wise to incur technical debt and I will present a few strategies for managing and reducing it.
<!--more-->

The technical debt metaphor was coined by Ward Cunningham in an [Experience Report for OOPSLA 1992][The WyCash Portfolio Management System] to illustrate the effects of *not-quite-right* code using a financial analogy. This metaphor is successful because most people understand the benefits of debt and they also understand its repercussions. You can buy something sooner using borrowed money and increase your buying power, but until you pay those money back you are paying interest. If you continue to take debt without paying it back, more and more of your income will be used to pay the interest until your purchasing power goes to zero. The same things is happening with software,

> if you develop a program for a long period of time by only adding features and never reorganizing it to reflect your understanding of those features, then eventually that program simply does not contain any understanding and all efforts to work on it take longer and longer. In other words, the interest is total -- you'll make zero progress. ([Ward Explains Debt Metaphor])

Ward Cunningham considers that the main source of debt is writing code to solve a problem that you don't completely understand. He doesn't see it as an excuse to write code poorly with the intention of cleaning it up later, arguing that you should write code that reflects that understanding as best as you can, in order to be able to refactor it later (it's very hard to refactor a piece of code when it is not clear which were the intentions of the person writing it). This kind of thinking is at the heart of agile software development - the software is developed incrementally without having a complete understanding of the problem when you start coding.

Technical debt is anything that slows you down (following the metaphor, this means anything that makes you pay interest). Some examples:

- Unclear, unreadable code.
- Duplicate code.
- Unit or integration tests that don't make you feel confident that the system still works after refactoring it.
- Not automating tasks that are performed multiple times and can be automated.
- Tangled architecture and unnecessarily complex dependencies.
- Important technical documentation that is missing or out-of-date.
- Unnecessary technical documentation that is being maintained and kept up-to-date.
- Lack of test environments.
- Long build-test cycle and lack of continuous integration.

## Types of Technical Debt

An important question is what to classify as being technical debt. Some people, like Uncle Bob are stating that [A Mess is not a Technical Debt]. While his concerns are valid and making a mess is never a good decision, I think that the more important question is when it is useful to use the technical debt metaphor. There are situations in which a team is given the task to further develop a system for which good design practices were ignored. For example, the system was bought and you later discovered the bad shape in which the code was. The interest payments are very high and it would take a very long time to pay back the principal, but this metaphor is also a good fit for this scenario as it explains why it is so hard to implement new features.

A good model I have found is Martin Fowler's [Technical Debt Quadrant]. He divides debt using two axes: reckless - prudent and deliberate - inadvertent.

![Technical Debt Quadrant](/assets/techDebtQuadrant.png)

**Deliberate reckless debt** appears when a team knows about design practices, but chooses to ignore them as they think there is no time for applying good design practices to the project. The problem with this approach is that the amount of interest being paid is usually underestimated. As a result, you end up spending more time on the project if you don't deliver before hitting the [Design Payoff Line]. After all, this is the whole point of design, to make you go faster and to be able to keep the pace while the project grows bigger and bigger. Bad code will always slow you down even if you might get some advantages for a short period of time.

**Inadvertent reckless debt** is the result of having only junior developers work on a project. They might have the best intentions, but they simply don't have the knowledge required to build large systems. Some companies are thinking that it is fine to hire only junior developers. The truth is that you need at least one senior developer in every team.

**Deliberate prudent debt** is the kind of debt that is incurred for strategic reasons. You know the total effort will be bigger as you pay interest and you will need to pay the principal, but the advantages you gain by releasing sooner outweigh the extra effort. You need to track this debt and pay it back immediately after the release in order to stop paying the interest. It is important to keep debt as low as possible in order to be able to take this kind of debt when it is required.

Examples of situations in which this might be a good decision are: releasing some new features or a new product before the competition does, convincing a client to sign a contract by implementing the required features in a shorter time or any other situation in which releasing sooner will benefit the company.

When this kind of decision is taken, everyone involved must understand the consequences of this decision. Make sure everyone agrees that the debt must be pay back. You must be sure that the reasons to take the debt are real. If the only reason is that your boss wants to look good in the eyes of his boss by releasing sooner, you will only spend more time without gaining any real advantage.

**Inadvertent prudent debt** is a weird concept. However, it is happening all the time. Only think about the last time you realized that a better design was possible after the work was done. It is impossible to prevent this kind of debt from appearing and I think that the costs would be very high if we try to eliminate it (this can easily result in [Analysis paralysis]). A better answer would be to accept it and refactor the code when you realize that a better solution exists.

## Managing Technical Debt

As indicated above, some kinds of debt should be avoided. It can be the result of taking numerous small shortcuts while writing the code or of the pressure you feel and makes you think there is no time for cleaning up the code. There are times when this pressure comes from ourselves, the cause being that the amount of work needed to finish a task was underestimated.

As the debt accumulates, the code starts to look messy and even more debt will be added if you don't take any measures. This is the result of a phenomenon known as [Broken Windows Theory].

> Consider a building with a few broken windows. If the windows are not repaired, the tendency is for vandals to break a few more windows. Eventually, they may even break into the building, and if it's unoccupied, perhaps become squatters or light fires inside.

There are two kind of measures that we can take in order to keep technical debt at a comfortable level:

- **Proactive measures**. The first thing that we need to do is to ask ourselves what we can do to minimize the amount of technical debt that we produce. Retrospectives are a great tool for this. Some of the things that are usually working are: code reviews, pair programming, refining the Definition of Done to ensure that the gap between sprint results and ready for production code is minimal.
- **Reactive measures**. We can't eliminate all the debt. As a result, we need to track the accumulated debt and dedicate more time to clean up when the debt level is above what we define as safe. A good strategy for tracking debt is to add it as stories in the product backlog and estimate them.

A few questions appear: how do you know when there is too much debt? how much effort is used for paying the interest? As we [Cannot Measure Productivity], we also can't measure how much is our productivity affected by existing debt. However, working with estimates is good enough in most cases. The programmers know the state of the code base and how complicated it is to add features to the system compared to how complicated it should be (the difference here is the interest).

This is an idea you can try. Ask the programmers from your team to give a score on a scale from 1 to 10 for the current state of the code base, 1 meaning that extremely high amounts of debt accumulated in the system and 10 that no or insignificant debt exists. The goal would be for your system to score 9 (going to extremes isn't helpful either). Repeat this experiment from time to time, ideally at each retrospective. If the score reaches 7 or below dedicate 1-2 sprints to fixing the debt until the score goes back to 9.

There's also the question of how to prioritize the technical debt stories in order to maximize your productivity, that is minimizing the interest you will pay in the future. There are two factors which can help you decide: the value of the principal to be paid back (the estimate given for fixing the debt) and the amount of interest generated by the debt. When estimating the interest you should take into account both how much overhead you have when touching that part of the system and how often you need to touch it. The highest priority should be given to the debt for which the ratio between generated interest and principal is the biggest.

One interesting aspect of technical debt compared with financial debt is that when a system is retired, its debt is also retired. This implies that when approaching the end of life for a system, fixing the debt becomes less important.

Technical debt is a great metaphor because it expresses the effects of design flaws in a clear way. It allows you to use terms like principal and interest which are widely understood and they correlate nicely with the world of software. Metaphors are a great tool for facilitating the understanding of a concept and is often used by scientists for explaining and teaching purposes. Their power lies in putting a familiar concept side by side with an unfamiliar one and using the first to explain the second. This is one of the fundamental tools used by our brains to understand the world.

## Further Reading

1. Ward Cunningham  - [The WyCash Portfolio Management System]
1. Ward Cunningham  - [Ward Explains Debt Metaphor]
1. Martin Fowler    - [Technical Debt][Fowler Technical Debt]
1. Martin Fowler    - [Technical Debt Quadrant]
1. Martin Fowler    - [Design Stamina Hypothesis]
1. Martin Fowler    - [Design Payoff Line]
1. Martin Fowler    - [Estimated Interest]
1. Martin Fowler    - [Cannot Measure Productivity]
1. Uncle Bob        - [A Mess is not a Technical Debt]
1. Steve McConnell  - [Technical Debt][McConnell Technical Debt]
1. Henrik Kniberg   - [Good and Bad Technical Debt]
1. Henrik Kniberg   - [The Solution to Technical Debt]
1. Eric Allman      - [Managing Technical Debt]
1. Wikipedia        - [Broken Windows Theory]

[The WyCash Portfolio Management System]: http://c2.com/doc/oopsla92.html
[Ward Explains Debt Metaphor]: http://c2.com/cgi/wiki?WardExplainsDebtMetaphor
[Fowler Technical Debt]: http://martinfowler.com/bliki/TechnicalDebt.html "Technical Debt"
[Technical Debt Quadrant]: http://martinfowler.com/bliki/TechnicalDebtQuadrant.html
[Design Stamina Hypothesis]: http://martinfowler.com/bliki/DesignStaminaHypothesis.html
[Design Payoff Line]: http://martinfowler.com/bliki/DesignPayoffLine.html
[Estimated Interest]: http://martinfowler.com/bliki/EstimatedInterest.html
[A Mess is not a Technical Debt]: https://sites.google.com/site/unclebobconsultingllc/a-mess-is-not-a-technical-debt
[McConnell Technical Debt]: http://www.construx.com/10x_Software_Development/Technical_Debt
[Cannot Measure Productivity]: http://martinfowler.com/bliki/CannotMeasureProductivity.html
[Good and Bad Technical Debt]: http://blog.crisp.se/2013/10/11/henrikkniberg/good-and-bad-technical-debt
[The Solution to Technical Debt]: http://blog.crisp.se/2013/07/12/henrikkniberg/the-solution-to-technical-debt
[Broken Windows Theory]: http://en.wikipedia.org/wiki/Broken_windows_theory
[Managing Technical Debt]: http://queue.acm.org/detail.cfm?id=2168798
[Analysis paralysis]: http://en.wikipedia.org/wiki/Analysis_paralysis
