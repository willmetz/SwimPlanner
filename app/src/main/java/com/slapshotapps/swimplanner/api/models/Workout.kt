package com.slapshotapps.swimplanner.api.models


data class Workout(val name : String, val workoutDate : String, val totalYardage : Int, val sets : List<Set>)
data class Set(val stroke : String, val yards : Int, val repititions : Int)