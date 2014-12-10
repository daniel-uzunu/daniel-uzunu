---
layout: post
title:  "Thoughts on Software Development"
date:   2014-01-11 19:00:00
categories: Software Development
---
Software use is growing at an explosive rate. In the latest years it reached peaks that couldn't be imagined 20 years ago. Now it is present basically everywhere. Still there a lot of things to be improved in the way we approach software projects. It is time to let go to habits that are standing in our way of reaching our best.
<!--more-->

Acting in the light of experience is a principle that should guide our work. Performing more than the minimal amount of planning and design before the code is written leads, in most cases, to wasted effort. I am not saying that planning and design are useless, but I believe that you should do them at the right moment, when you have all the information needed in order to do them accurately. Most software projects are presenting some unique challenges, at least for the team that is working on the project.

It is time to embrace the agile way of developing software and push it to the extreme. I see software development as a continuous flow of actions, each of them bringing you one step closer to the goal of the project. Resisting this flow, by doing a big part of requirements gathering and design upfront, leads to suboptimal decisions. This is not an issue for projects that are predictable enough. However, even these projects can benefit from the experience accumulated during the development process if we let this experience guide our actions.

The success of Test Driven Development lies in the small steps it uses to write the code for solving a specific problem. TDD keeps you focused on the problem at hand; you're just implementing the features you have on your list, one at a time. First make it work, then clean it up. Red, green, refactor... Red, green, refactor...

Automated testing is a great tool for improving the quality, but we can go even further by making developers responsible for the quality of the software they are building. All the tests should be automated and wrote by the developers. You may think that it is madness to deploy software without manually testing it, but think about it: a large proportion of the bugs found during manual testing exist because a safety net is in place. Making developers responsible for the quality will decrease the number of defects to a low enough rate that continuous deployment would actually become possible.
