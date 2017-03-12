---
layout: post
title:  "Web App Authentication"
date:   2017-03-12
categories: Web
---
Implementation steps:
- store and check passwords - bcrypt
- session id - random bytes + expiration time + signature (HMAC-SHA2)
- setting the cookie - secure, http-only
- verify cookie for incoming request
- common attacks: session fixation, xss, csrf, timing attacks

Articles:
- https://hueniverse.com/2015/07/08/on-securing-web-session-ids/
- https://en.wikipedia.org/wiki/Hash-based_message_authentication_code
- https://codahale.com/a-lesson-in-timing-attacks/
- https://www.jokecamp.com/blog/examples-of-creating-base64-hashes-using-hmac-sha256-in-different-languages/#java
