---
layout:      post
title:       "REST Web Services"
date:        2015-01-08
categories:
- REST
tags:
- REST
- web services
---

## Questions I want to answer in this article

- What is REST and which are its advantages / disadvantages
- HTTP: verbs, status codes, headers...
- guidelines for resource paths
- filtering, sorting, paging
- multiple actions on the same resource
- HATEOAS; links to related resources
- data formats: json,  xml
- schema?

## Things I'll probably move to another article

- HTTP is a request / response protocol but the client of a HTTP service doesn't have to be synchronous (blocking a thread until the response comes). The same is true for server side architectures: we don't need to process requests synchronously and block while waiting for other services to respond (databases, REST services). We can even use queues in order to decouple from the service we are calling.
- It would also be interesting to read about ways to come up with the architecture for a system; thinking about the constraints of the system; the role of coding standards when developing a system (this will probably be a separate article).

Usefull links:
- [Fielding about REST]
- [Enterprise Integration Using REST]
- [REST CookBook]
- [HTTP Options]
- [Gist for REST links]

[Fielding about REST]: http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm
[Enterprise Integration Using REST]: http://martinfowler.com/articles/enterpriseREST.html
[REST CookBook]: http://restcookbook.com/
[HTTP Options]: http://zacstewart.com/2012/04/14/http-options-method.html
[Gist for REST links]: https://gist.github.com/miyagawa/1912431
