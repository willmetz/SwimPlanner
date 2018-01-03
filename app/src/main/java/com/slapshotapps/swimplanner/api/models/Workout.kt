package com.slapshotapps.swimplanner.api.models


data class Workout(val id : Int, val name : String, val targetDate : String, val completedDate : String, val sets : List<WorkoutSet>)
data class WorkoutSet(val id : Int, val strokes: List<SwimStroke>, val yards : Int, val repetitions: Int, val notes : String)