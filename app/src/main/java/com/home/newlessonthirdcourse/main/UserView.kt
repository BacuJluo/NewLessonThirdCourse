package com.home.newlessonthirdcourse.main

import com.home.newlessonthirdcourse.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView:MvpView {
    fun initList(list: List<GithubUser>)
    fun onUserClicked(user: GithubUser)
}