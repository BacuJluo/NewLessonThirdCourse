package com.home.newlessonthirdcourse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val login:String
) : Parcelable