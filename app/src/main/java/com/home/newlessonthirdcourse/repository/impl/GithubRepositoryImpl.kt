package com.home.newlessonthirdcourse.repository.impl

import com.home.newlessonthirdcourse.GithubUser
import com.home.newlessonthirdcourse.repository.GithubRepository

class GithubRepositoryImpl: GithubRepository {

    private val repositories = listOf(
        GithubUser("BacuJlux"),
        GithubUser("MrFox"),
        GithubUser("VictorMelnik"),
        GithubUser("Denix"),
        GithubUser("DmitryWB"),
        GithubUser("DmitryWB"),
        GithubUser("DmitryWB"),
        GithubUser("DmitryWB"),
        GithubUser("DmitryWB"),
        GithubUser("DmitryWB"),
        GithubUser("DmitryWB"),
        GithubUser("DmitryWB")
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }
}