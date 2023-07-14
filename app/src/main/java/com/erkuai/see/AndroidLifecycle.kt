package com.erkuai.see

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class AndroidLifecycle(private val owner: LifecycleOwner?) : LifecycleProvider, LifecycleEventObserver {

    private val mObservers = arrayListOf<LifecycleProvider.Observer>()
    private val mLock = Any()

    /**
     * 缓存当前的Event事件
     */
    private var mEvent: Lifecycle.Event? = null

    init {
        owner?.lifecycle?.addObserver(this)
    }

    companion object {
        fun createLifecycleProvider(owner: LifecycleOwner?): LifecycleProvider {
            return AndroidLifecycle(owner)
        }
    }


    override fun observe(observer: LifecycleProvider.Observer?) {
        if (observer == null) {
            throw IllegalArgumentException("The observer is null.")
        }
        synchronized(mLock) {
            if (mObservers.contains(observer)) return
            mObservers.add(observer)
            if (mEvent != null) {
                observer.onChanged(mEvent!!)
            }
        }
    }

    override fun removeObserver(observer: LifecycleProvider.Observer?) {
        if (observer == null) {
            throw IllegalArgumentException("The observer is null.")
        }
        synchronized(mLock) {
            val index = mObservers.indexOf(observer)
            if (index == -1) return
            mObservers.remove(observer)
        }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        synchronized(mLock) {
            mEvent = event
            for (i in mObservers.size - 1 downTo 0) {
                mObservers[i].onChanged(event)
            }
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            owner?.lifecycle?.removeObserver(this)
        }
    }
}