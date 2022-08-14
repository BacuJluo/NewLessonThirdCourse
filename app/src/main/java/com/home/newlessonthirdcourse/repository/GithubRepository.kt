package com.home.newlessonthirdcourse.repository

import com.home.newlessonthirdcourse.GithubUser

interface GithubRepository {
    fun getUsers():List <GithubUser>
}