package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.R.color
import com.example.lesson.R.id
import com.example.lesson.R.layout
import com.example.lesson.entity.Lesson
import com.example.lesson.entity.Lesson.State.LIVE
import com.example.lesson.entity.Lesson.State.PLAYBACK
import com.example.lesson.entity.Lesson.State.WAIT
import java.util.ArrayList

/**
 * Created by Bony on 12/25/20.
 */
internal class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    private var list: List<Lesson> = ArrayList()

    fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    /**
     * 静态内部类
     */
    class LessonViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {
        internal fun onBind(lesson: Lesson) {
            setText(id.tv_date, lesson.date ?: "日期待定")
            setText(id.tv_content, lesson.content)
            lesson.state?.let {
                setText(id.tv_state, it.stateName())
                val colorRes: Int = when (it) {
                    PLAYBACK -> color.playback
                    LIVE -> color.live
                    WAIT -> color.wait
                }
                val backgroundColor: Int = itemView.context.getColor(colorRes)
                getView<TextView>(id.tv_state).setBackgroundColor(backgroundColor)
            }
        }

        companion object {
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(layout.item_lesson, parent, false))
            }
        }
    }
}