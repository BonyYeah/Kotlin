package com.example.core

import android.app.Application
import android.content.Context

/**
 * Created by Bony on 12/24/20.
 */
class BaseApplication : Application() {
    companion object {
        private var currentApplication: Context? = null

        fun currentApplication(): Context = currentApplication!!
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }
}