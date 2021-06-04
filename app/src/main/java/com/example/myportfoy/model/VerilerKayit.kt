package com.example.myportfoy.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*


@Parcelize
    class VerilerKayit(
        var adsoyad: String = "",
        var fadi: String = "",
        var tno: String = "",
        var sno: String = "",
        var mkutusu: String = "",
        var olusturmaTarihi:String= ""): Parcelable


