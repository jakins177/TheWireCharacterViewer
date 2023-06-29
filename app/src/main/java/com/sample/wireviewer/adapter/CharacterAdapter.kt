package com.sample.wireviewer.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.wireviewer.R
import com.sample.wireviewer.CharacterModel.RelatedTopic
import com.sample.wireviewer.util.parseName

class CharacterAdapter (

    private var dataSet:
            List<RelatedTopic>? = mutableListOf(),
    private val listener: (RelatedTopic) -> Unit
    ):
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.character_row_item, viewGroup, false)

        return CharacterViewHolder(view)
    }

    override fun getItemCount() = dataSet?.size ?: 0

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var conTextView: TextView = itemView.findViewById(R.id.name_textview)

        fun updateInfo(item: RelatedTopic?) {
            if(item != null ) {
                Log.i("updateInfo", "updateInfo: ")

                var name:String = parseName(item.Text.toString());

                conTextView.text = name
            }
        }
    }

    fun setFilteredList(cList: List<RelatedTopic>) {
         this.dataSet = cList
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = dataSet?.get(position)
        holder.updateInfo(item)

        holder.itemView.setOnClickListener {
            if(item != null){
                listener(item)
            }
        }
    }



    }