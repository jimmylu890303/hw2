package com.example.hw2
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Account (val account:String,val password:String,val name: String,val studentId:String):
    Parcelable