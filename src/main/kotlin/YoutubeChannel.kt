package org.example

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber

data class YoutubeChannel(
    private var videos: MutableList<String>
): Publisher<String>{

    override fun subscribe(subscriber: Subscriber<in String>?) {
        subscriber?.onSubscribe(YoutubeSubscription(subscriber, videos))
    }

    fun addVideo(title: String){
        videos.add(title)
    }
}