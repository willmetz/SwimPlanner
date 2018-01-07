package com.slapshotapps.swimplanner.home.views

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.slapshotapps.swimplanner.R
import com.slapshotapps.swimplanner.databinding.CompletedWorkoutCardBinding
import com.slapshotapps.swimplanner.home.viewmodels.CompletedWorkoutViewModel

class UpcomingWorkoutView : ConstraintLayout {

  //  lateinit var binding: CompletedWorkoutCardBinding

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
//        binding = DataBindingUtil.inflate<CompletedWorkoutCardBinding>(LayoutInflater.from(context),
//            R.layout.completed_workout_card, this, true)
    }

    fun setWorkout(viewModel: CompletedWorkoutViewModel) {
//        binding.data = viewModel
//        binding.invalidateAll()
    }
}