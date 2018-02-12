package com.slapshotapps.swimplanner.api.models

import android.os.Parcel
import android.os.Parcelable
import java.text.SimpleDateFormat
import java.util.*


data class Workout(val id: Int, val name: String, private val targetDate: String,
    private val completedDate: String, val sets: List<WorkoutSet>) : Parcelable {
    private val serviceDateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.US)

    fun targetDate(): Date {
        return serviceDateFormat.parse(targetDate)
    }

    fun completedDate(): Date {
        return serviceDateFormat.parse(completedDate)
    }

    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        ArrayList<WorkoutSet>().apply { source.readList(this, WorkoutSet::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(targetDate)
        writeString(completedDate)
        writeList(sets)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Workout> = object : Parcelable.Creator<Workout> {
            override fun createFromParcel(source: Parcel): Workout = Workout(source)
            override fun newArray(size: Int): Array<Workout?> = arrayOfNulls(size)
        }
    }
}

data class WorkoutSet(val id: Int, val strokes: List<SwimStroke>, val yards: Int,
    val repetitions: Int, val notes: String) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        ArrayList<SwimStroke>().apply { source.readList(this, SwimStroke::class.java.classLoader) },
        source.readInt(),
        source.readInt(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeList(strokes)
        writeInt(yards)
        writeInt(repetitions)
        writeString(notes)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<WorkoutSet> = object : Parcelable.Creator<WorkoutSet> {
            override fun createFromParcel(source: Parcel): WorkoutSet = WorkoutSet(source)
            override fun newArray(size: Int): Array<WorkoutSet?> = arrayOfNulls(size)
        }
    }
}