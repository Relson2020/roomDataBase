package com.example.database

import android.app.Application

class GlobalInstance : Application(){

    //var abc ="dsfjkdbn"
    /** get Instance of the activity */
    companion object {
        private lateinit var mInstance: GlobalInstance

        @Synchronized
        fun getApplication(): GlobalInstance {
            return mInstance
        }

    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this

    }
}