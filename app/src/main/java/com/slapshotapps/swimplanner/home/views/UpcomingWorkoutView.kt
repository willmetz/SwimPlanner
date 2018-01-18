package com.slapshotapps.swimplanner.home.views

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.slapshotapps.swimplanner.R
import com.slapshotapps.swimplanner.databinding.CompletedWorkoutCardBinding
import com.slapshotapps.swimplanner.databinding.UpcomingWorkoutCardBinding
import com.slapshotapps.swimplanner.home.viewmodels.CompletedWorkoutViewModel
import com.slapshotapps.swimplanner.home.viewmodels.UpcomingWorkoutViewModel

class UpcomingWorkoutView : ConstraintLayout {

    lateinit var binding: UpcomingWorkoutCardBinding

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        binding = DataBindingUtil.inflate<UpcomingWorkoutCardBinding>(LayoutInflater.from(context),
            R.layout.upcoming_workout_card, this, true)
    }

    fun setWorkout(viewModel: UpcomingWorkoutViewModel) {
        binding.upcomingWorkout = viewModel
    }
}