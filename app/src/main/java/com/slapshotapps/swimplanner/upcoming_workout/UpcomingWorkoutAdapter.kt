package com.slapshotapps.swimplanner.upcoming_workout

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.slapshotapps.swimplanner.R
import com.slapshotapps.swimplanner.databinding.WorkoutSetItemViewBinding
import com.slapshotapps.swimplanner.upcoming_workout.viewmodels.WorkoutRowViewModel


class UpcomingWorkoutAdapter(val workoutRowModels: List<WorkoutRowViewModel>) :
    RecyclerView.Adapter<UpcomingWorkoutAdapter.WorkoutViewHolder>() {

    override fun getItemCount(): Int {
        return workoutRowModels.size
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder?, position: Int) {
        holder?.bind(workoutRowModels.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WorkoutViewHolder {

        val inflater = LayoutInflater.from(parent!!.context)

        val binding = DataBindingUtil.inflate<WorkoutSetItemViewBinding>(inflater,
            R.layout.workout_set_item_view,
            parent,
            false)

        return WorkoutViewHolder(binding)
    }

    class WorkoutViewHolder(val binding: WorkoutSetItemViewBinding) : RecyclerView.ViewHolder(
        binding.root) {
        fun bind(viewModel: WorkoutRowViewModel) {
            binding.data = viewModel
            binding.executePendingBindings()
        }
    }
}