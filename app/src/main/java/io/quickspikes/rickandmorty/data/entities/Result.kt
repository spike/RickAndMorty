package io.quickspikes.rickandmorty.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

data class Result(
    val id: Int,
    val info: Info,
    val results: List<CartoonCharacter>
)

