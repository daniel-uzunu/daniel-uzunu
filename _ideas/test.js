'use strict';

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
