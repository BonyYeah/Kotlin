package com.example.lesson.entity

/**
 * Created by Bony on 12/25/20.
 */
class Lesson(var date: String?, var content: String?, var state: State?) {

    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }
}