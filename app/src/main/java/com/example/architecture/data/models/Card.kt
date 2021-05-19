package com.example.architecture.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card(
    val cardUuid: String,
    val lastFourNumbers: String,
    val printedName: String
) : Parcelable