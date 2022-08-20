package com.home.newlessonthirdcourse.repository

import com.home.newlessonthirdcourse.GithubUser
import io.reactivex.rxjava3.core.Observable

interface GithubRepository {
    fun getUsers(): Observable<List<GithubUser>>
}