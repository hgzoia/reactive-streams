package org.example

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

data class YoutubeSubscription(private var subscriber: Subscriber<in String>?, private var videos: MutableList<String>) : Subscription {

    override fun request(size: Long) {
        println("request(unbounded)")
        val requestNumberItems = getRequestNumberItemsSize(size).minus(1)

        for(item in 0..requestNumberItems){
            subscriber?.onNext(videos[item.toInt()])
        }
        subscriber?.onComplete()
    }

    private fun getRequestNumberItemsSize(size: Long): Long{
        if(size <= videos.size){
            return size
        }
        return videos.size.toLong()
    }

    override fun cancel() {
        TODO("Not yet implemented")
    }

}
