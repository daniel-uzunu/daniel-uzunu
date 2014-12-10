---
layout: post
title:  "Welcome to Jekyll!"
date:   2014-01-01 19:39:34
categories: jekyll update
---
You'll find this post in your `_posts` directory. Go ahead and edit it and re-build the site to see your changes. You can rebuild the site in many different ways, but the most common way is to run `jekyll serve --watch`, which launches a web server and auto-regenerates your site when a file is updated.

To add new posts, simply add a file in the `_posts` directory that follows the convention `YYYY-MM-DD-name-of-post.ext` and includes the necessary front matter. Take a look at the source for this post to get an idea about how it works.

<!--more-->

Jekyll also offers powerful support for code snippets:

{% highlight ruby %}
def print_hi(name)
  puts "Hi, #{name}"
end
print_hi('Tom')
#=> prints 'Hi, Tom' to STDOUT.
{% endhighlight %}

{% highlight javascript %}
'use strict';

/*
* jhkjd
*/

/**
* jsjdfkjsd
*/

function ThrottlingExecutor(concurrentTaskCount,  hasMoreTasks) {
	// hasMoreTasks is executed after each task that completes
	// if true it spans more tasks until the limit is reached
}

var queue = new Queue();

var executor = new ThrottlingExecutor(5, function () { return !queue.isEmpty(); });

executor.on('error', function (error) {
	logger.error(error.message);
	return true;
});

executor.on('done', function (finished) {
	// check if all items are processed
	// if finnished is false an error that stop the processing occured
});

executor.execute(function () {
	return seq([
		function () {
			return read(queue.dequeue());
		},
		function (list) {
			queue.enqueueAll(list);
		}
	]);
});

/****** crawler example ********/
var crawler = new ThrottlingExecutor(10, () => !queue.isEmpty());

crawler.execute(() => {
	var url = queue.dequeue();

	if (!recentlyVisited(url)) {
		return http.get(url).then(body => {
			mq.send(body);
			queue.enqueueAll(findLinks(body)))
		}	
	} else {
		queue.enqueue(url);
	}
});
{% endhighlight %}

Check out the [Jekyll docs][jekyll] for more info on how to get the most out of Jekyll. File all bugs/feature requests at [Jekyll’s GitHub repo][jekyll-gh]. If you have questions, you can ask them on [Jekyll’s dedicated Help repository][jekyll-help].

[jekyll]:      http://jekyllrb.com
[jekyll-gh]:   https://github.com/jekyll/jekyll
[jekyll-help]: https://github.com/jekyll/jekyll-help
