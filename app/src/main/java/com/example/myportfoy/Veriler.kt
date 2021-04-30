package com.example.myportfoy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class Veriler(
        var nbaslik: String = "",
        var ynot: String = "") : Parcelable