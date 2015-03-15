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
- HTTP status codes and how they should be used. errors.
- response body for errors

## Things I'll probably move to another article

- HTTP is a request / response protocol but the client of a HTTP service doesn't have to be synchronous (blocking a thread until the response comes). The same is true for server side architectures: we don't need to process requests synchronously and block while waiting for other services to respond (databases, REST services). We can even use queues in order to decouple from the service we are calling.
- It would also be interesting to read about ways to come up with the architecture for a system; thinking about the constraints of the system; the role of coding standards when developing a system (this will probably be a separate article).

Usefull links:
- [Fielding about REST]
- [Enterprise Integration Using REST]
- [REST CookBook]
- [HTTP Options]
- [Gist for REST links]
- [Martin Fowler - Richardson Maturity Model]
- [Richardson - RESTfull Web Services]
- [Richardson - RESTfull Web APIs]
- [API Example Using REST]

[Fielding about REST]: http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm
[Enterprise Integration Using REST]: http://martinfowler.com/articles/enterpriseREST.html
[REST CookBook]: http://restcookbook.com/
[HTTP Options]: http://zacstewart.com/2012/04/14/http-options-method.html
[Gist for REST links]: https://gist.github.com/miyagawa/1912431
[Martin Fowler - Richardson Maturity Model]: http://martinfowler.com/articles/richardsonMaturityModel.html
[Richardson - RESTfull Web Services]: https://books.google.ro/books?id=XUaErakHsoAC&printsec=frontcover&dq=inauthor:%22Leonard+Richardson%22&hl=en&sa=X&ei=1PkFVaedGsHjO5aCgTg&ved=0CC4Q6AEwAg#v=onepage&q&f=false
[Richardson - RESTfull Web APIs]: https://books.google.ro/books?id=ZXDGAAAAQBAJ&printsec=frontcover&dq=inauthor:%22Leonard+Richardson%22&hl=en&sa=X&ei=1PkFVaedGsHjO5aCgTg&ved=0CDoQ6AEwBA#v=onepage&q&f=false
[API Example Using REST]: http://thereisnorightway.blogspot.ro/2012/05/api-example-using-rest.html
