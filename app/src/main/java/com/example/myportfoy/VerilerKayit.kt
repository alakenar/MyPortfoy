package com.example.myportfoy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


    @Parcelize
    class VerilerKayit(
        var adsoyad: String = "",
        var fadi: String = "",
        var tno: String = "",
        var sno: String = "",
        var mkutusu: String = ""): Parcelable


