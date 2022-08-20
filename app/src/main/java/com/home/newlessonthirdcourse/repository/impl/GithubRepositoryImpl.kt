package com.home.newlessonthirdcourse.repository.impl

import com.home.newlessonthirdcourse.GithubUser
import com.home.newlessonthirdcourse.repository.GithubRepository
import io.reactivex.rxjava3.core.Observable

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

    override fun getUsers(): Observable<List<GithubUser>> =  Observable.just(repositories)


}