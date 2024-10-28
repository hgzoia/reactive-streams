package org.example

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class User(
    private var name: String
): Subscriber<String> {

    override fun onSubscribe(subscription: Subscription?) {
        println("onSubscribe, $name")
        subscription?.request(Long.MAX_VALUE)
    }
    override fun onNext(video: String?) {
        println("onNext, $video")
    }

    override fun onError(error: Throwable?) {
        println("onError, $error")
    }

    override fun onComplete() {
        println("onComplete")
    }

}