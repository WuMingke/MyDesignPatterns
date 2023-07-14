package com.erkuai.see

import androidx.lifecycle.Lifecycle

interface LifecycleProvider {

    fun observe(observer: Observer?)

    fun removeObserver(observer: Observer?)

    interface Observer {
        fun onChanged(event: Lifecycle.Event)
    }
}