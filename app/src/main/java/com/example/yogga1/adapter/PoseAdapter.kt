package com.example.yogga1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yogga1.R
import com.example.yogga1.model.YogaPose

class PoseAdapter(
    private val poses: List<YogaPose>,
    private val onItemClick: (YogaPose) -> Unit
) : RecyclerView.Adapter<PoseAdapter.PoseViewHolder>() {

    class PoseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poseName: TextView = itemView.findViewById(R.id.poseName)
        val sanskritName: TextView = itemView.findViewById(R.id.sanskritName)
        val poseDifficulty: TextView = itemView.findViewById(R.id.poseDifficulty)
        val poseImage: ImageView = itemView.findViewById(R.id.poseImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pose, parent, false)
        return PoseViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoseViewHolder, position: Int) {
        val pose = poses[position]
        holder.poseName.text = pose.name
        holder.sanskritName.text = pose.sanskritName
        holder.poseDifficulty.text = pose.difficulty
        holder.poseImage.setImageResource(pose.imageResource)

        // ВАЖНО: ДОБАВЬ ОБРАБОТЧИК КЛИКОВ!
        holder.itemView.setOnClickListener {
            onItemClick(pose)
        }
    }

    override fun getItemCount(): Int {
        return poses.size
    }
}