package com.example.myportfoy.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class VerilerNot(
        var nbaslik: String = "",
        var ynot: String = "",
        var olusturmaTarihi2:String= "") : Parcelable

