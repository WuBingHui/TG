package com.anthony.tg

import android.app.ActionBar
import android.content.Context
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginEnd
import androidx.recyclerview.widget.RecyclerView


class MessageAdapter(private var context: Context) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {


    private var messageList = ArrayList<MessageDto>()


    fun setData(messageList: ArrayList<MessageDto>) {

        this.messageList = messageList

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {


        return messageList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.messageGroup.removeAllViews()
        for (element in messageList[position].data) {
            val textView = TextView(context)
            val line = View(context)
            line.background = ContextCompat.getDrawable(context,R.color.colorAccent)
            val lineLayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2
            )
            lineLayoutParams.setMargins(0, 8, 16, 8)
            line.layoutParams =lineLayoutParams
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 8, 16, 8)
            textView.setPadding(8, 8, 8, 8)
            textView.layoutParams = layoutParams
            textView.text = element
            holder.messageGroup.addView(textView)
            holder.messageGroup.addView(line)
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var messageGroup: LinearLayout
        lateinit var icon: ImageView
        fun bind() {
            messageGroup = itemView.findViewById(R.id.messageGroup)
            icon = itemView.findViewById(R.id.imageView)
        }

    }

}