---
layout: post
title:  "Technical Debt"
date:   2014-11-29 12:41:34
categories: Software Development
---
The primary reason to write code is to build executable programs. However, software systems need to be enhanced and maintained, which leads to a continuously evolving codebase. In this context, writing code which is easy to understand and change becomes as important as writing code that works correctly and fulfill its users needs. The code must reflect our current understanding of the problem,  it should ... Otherwise, the mismatch between the concepts which are present in the codebase and our current understanding of the problem space will slow us down. We will have a hard time trying to integrate new features into a codebase that is not reflecting the things we learned since we originally wrote the code. This mismatch appears because we don't have a complete understanding of the problem when we write the code and this is fine. It is better to have working software based on partial understanding and learn by observing the software being used than trying to get a complete understanding of the problem before writing code (agile vs waterfall). However, it is important to incorporate this learning back into the codebase. Otherwise, implementing new features without refactoring the code will slow us down more and more until it will become prohibitively expensive to incorporate any new feature. **I should also include the technical debt term into the introduction.**
<!--more-->

The *technical debt* metaphor was coined by Ward Cunningham in 1992 to illustrate the effects of *not-quite-right* code using a financial analogy<sup>[[1]][1]</sup>. This metaphor is successful because most people understand the benefits of debt and they also understand the repercussions. You can buy something sooner using borrowed money and increase your buying power, but until you pay those money back you are paying interest. If you continue to take debt without paying it back, more and more of your income will be used to pay the interest until your purchasing power goes to zero. The same things is happening with software, *if you develop a program for a long period of time by only adding features and never reorganizing it to reflect your understanding of those features, then eventually that program simply does not contain any understanding and all efforts to work on it take longer and longer. In other words, the interest is total -- you'll make zero progress.*<sup>[[2]][2]</sup>

This analogy can be extended to include multiple types of less than optimal code, but there also comes the question of when it is useful to use this metaphor. I don't consider it useful for cases where both managers and developers don't care about quality. However, it becomes useful when the team developing this code or another team wants to clean it up. In this moment, the team realizes that the amount of technical debt is huge, but they still see value in the product. Complete rewrites are rarely a good option, so the wisest thing to do would be to **inventory** the debt and pay it back a little at a time. **There's also the question: is it possible to pay the debt in these cases?**

Ward Cunningham considers that technical debt arises as a result of writing code to solve a problem that you don't completely understand. He doesn't see it as an excuse to write code poorly with the intention of cleaning it up later. *You know, if you want to be able to go into debt that way by developing software that you don't completely understand, you are wise to make that software reflect your understanding as best as you can, so that when it does come time to refactor, it's clear what you were thinking when you wrote it, making it easier to refactor it into what your current thinking is now.*<sup>[[2]][2]</sup> This kind of thinking is at the heart of agile software development - the software is developed incrementally without having a complete understanding of the problem when you start coding.

Uncle Bob - [A Mess is not a Technical Debt]

> A mess is not a technical debt. A mess is just a mess. Technical debt decisions are made based on real project constraints. They are risky, but they can be beneficial. The decision to make a mess is never rational, is always based on laziness and unprofessionalism, and has no chance of paying of in the future. A mess is always a loss.

> When you decide to take on a technical debt, you had better make sure that your code stays squeaky clean. Keeping the system clean is the only way you will pay down that debt.

Martin Fowler - [Technical Debt Quadrant]

> To my mind, the question of whether a design flaw is or isn't debt is the wrong question. Technical Debt is a metaphor, so the real question is whether or not the debt metaphor is helpful about thinking about how to deal with design problems, and how to communicate that thinking. A particular benefit of the debt metaphor is that it's very handy for communicating to non-technical people.
>
> I think that the debt metaphor works well in both cases - the difference is in nature of the debt. A mess is a reckless debt which results in crippling interest payments or a long period of paying down the principal. We have a few projects where we've taken over a code base with a high debt and found the metaphor very useful in discussing with client management how to deal with it.

> Reckless debt may not be inadvertent. A team may know about good design practices, even be capable of practicing them, but decide to go "quick and dirty" because they think they can't afford the time required to write clean code. I agree with Uncle Bob that this is usually a reckless debt, because people underestimate where the DesignPayoffLine is. The whole point of good design and clean code is to make you go faster - if it didn't people like Uncle Bob, Kent Beck, and Ward Cunningham wouldn't be spending time talking about it.
>
> Dividing debt into reckless/prudent and deliberate/inadvertent implies a quadrant, and I've only discussed three cells. So is there such a thing as prudent-inadvertent debt? Although such a thing sounds odd, I believe that it is - and it's not just common but inevitable for teams that are excellent designers.
>
> I was chatting with a colleague recently about a project he'd just rolled off from. The project that delivered valuable software, the client was happy, and the code was clean. But he wasn't happy with the code. He felt the team had done a good job, but now they realize what the design ought to have been.

![Technical Debt Quadrant](http://martinfowler.com/bliki/images/techDebtQuadrant.png)

Steve McConnell - [Technical Debt]

> Debt
>
> I. Debt incurred unintentionally due to low quality work
>
> II. Debt incurred intentionally
>
> II.A. Short-term debt, usually incurred reactively, for tactical reasons
>
> II.A.1. Individually identifiable shortcuts (like a car loan)
>
> II.A.2. Numerous tiny shortcuts (like credit card debt)
>
> II.B. Long-term debt, usually incurred proactively, for strategic reasons

> You're acquiring an asset (the released software) for less than it's full price. Thus you're financing the gap between what you paid (actual dev cost) vs. the full price (what the dev cost would have been without the shortcuts). That gap is the technical debt.

> When technical debt is incurred for strategic reasons, the fundamental reason is always that the cost of development work today is seen as more expensive than the cost will be in the future. This can be true for any of several reasons.
>
> Time to Market. When time to market is critical, incurring an extra $1 in development might equate to a loss of $10 in revenue. Even if the development cost for the same work rises to $5 later, incurring the $1 debt now is a good business decision.
>
> Preservation of Startup Capital. In a startup environment you have a fixed amount of seed money, and every dollar counts. If you can delay an expense for a year or two you can pay for that expense out of a greater amount of money later rather than out of precious startup funds now.
>
> Delaying Development Expense. When a system is retired, all of the system's technical debt is retired with it. Once a system has been taken out of production, there's no difference between a "clean and correct" solution and a "quick and dirty" solution. Unlike financial debt, when a system is retired all its technical debt is retired with it. Consequently near the end of a system's service life it becomes increasingly difficult to cost-justify investing in anything other than what's most expedient.

> One organization we've worked with maintains a debt list within its defect tracking system. Each time a debt is incurred, the tasks needed to pay off that debt are entered into the system along with an estimated effort and schedule. The debt backlog is then tracked, and any unresolved debt more than 90 days old is treated as critical.
>
> Another organization maintains its debt list as part of its Scrum product backlog, with similar estimates of effort required to pay off each debt.
>
> Either of these approaches can be used to increase visibility into the debt load and into the debt service work that needs to occur within or across release cycles. Each also provides a useful safeguard against accumulating the "credit card debt" of a mountain of tiny shortcuts mentioned earlier. You can simply tell the team, "If the shortcut you are considering taking is too minor to add to the debt-service defect list/product backlog, then it's too minor to make a difference; don't take that shortcut. We only want to take shortcuts that we can track and repair later."

**Debt can also arise when you write software using a technology that you are still learning. "I  wish I knew this one year ago when I wrote this piece of code."**

**Martin Fowler, Uncle Bob opinions.**

## Some points I want to cover in this article:

- what is technical debt and which is my view on technical debt? There are a few subtleties in what different people understand by technical debt. I need to choose what I want to include under the technical debt umbrella.
- types of debt; is it useful to distinguish between types of debt like code debt, documentation debt, test debt... ?
- causes of technical debt; when is it useful to deliberately take debt? how much debt should we take? design payoff line
- measuring technical debt and the interest that is paid for this debt
- how to reduce the technical debt? create special stories to pay debt or include them in stories that touch the part of the code affected by debt

## Some Ideas

- Make the debt visible ([http://c2.com/cgi/wiki?TechnicalDebt](http://c2.com/cgi/wiki?TechnicalDebt))
- How much debt it is wise to take? See [Design Stamina Hypothesis]
- How to keep track of the debt you accumulated and the interest you are paying for it?
- How and when to pay the debt back?
- The savvy developer treats technical debt just as the entrepreneur does financial debt. They use it. It speeds delivery, so long as it is properly managed. (same as above)
- the technical debt metaphor is useful as a communication tool between developers or between developers and non technical managers. In the later case, both parts understand better the perspective of the other part.

## References

1. [Ward Cunningham - *The WyCash Portfolio Management System*][1]
1. [Ward Cunningham - *Ward Explains Debt Metaphor*][2]
1. [Martin Fowler - *Technical Debt*][3]
1. Martin Fowler - [Technical Debt Quadrant]
1. Martin Fowler - [Design Stamina Hypothesis]
1. Uncle Bob - [A Mess is not a Technical Debt]
1. Steve McConnell - [Technical Debt]
1. Martin Fowler - [Cannot Measure Productivity]
1. Steve Garnet - [Technical Debt: Strategies & Tactics for Avoiding & Removing it][Garnett Technical Debt]
1. Henrik Kniberg - [Good and Bad Technical Debt]

[1]: http://c2.com/doc/oopsla92.html "The WyCash Portfolio Management System"
[2]: http://c2.com/cgi/wiki?WardExplainsDebtMetaphor "Ward Explains Debt Metaphor"
[3]: http://martinfowler.com/bliki/TechnicalDebt.html "Technical Debt"
[Technical Debt Quadrant]: http://martinfowler.com/bliki/TechnicalDebtQuadrant.html
[Design Stamina Hypothesis]: http://martinfowler.com/bliki/DesignStaminaHypothesis.html
[A Mess is not a Technical Debt]: https://sites.google.com/site/unclebobconsultingllc/a-mess-is-not-a-technical-debt
[Technical Debt]: http://www.construx.com/10x_Software_Development/Technical_Debt
[Cannot Measure Productivity]: http://martinfowler.com/bliki/CannotMeasureProductivity.html
[Garnett Technical Debt]: http://blogs.ripple-rock.com/SteveGarnett/2013/03/05/TechnicalDebtStrategiesTacticsForAvoidingRemovingIt.aspx
[Good and Bad Technical Debt]: http://blog.crisp.se/2013/10/11/henrikkniberg/good-and-bad-technical-debt