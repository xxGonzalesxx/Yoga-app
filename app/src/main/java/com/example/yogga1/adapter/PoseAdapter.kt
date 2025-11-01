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
        val poseImage: ImageView = itemView.findViewById(R.id.poseImage)
        val poseName: TextView = itemView.findViewById(R.id.poseName)
        val poseDifficulty: TextView = itemView.findViewById(R.id.poseDifficulty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pose, parent, false)
        return PoseViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoseViewHolder, position: Int) {
        val pose = poses[position]
        holder.poseName.text = pose.name
        holder.poseDifficulty.text = pose.difficulty
        holder.poseImage.setImageResource(pose.imageResource)

        holder.itemView.setOnClickListener {
            onItemClick(pose)
        }
    }

    override fun getItemCount() = poses.size
}
