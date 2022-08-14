package com.home.newlessonthirdcourse.main

import com.github.terrakok.cicerone.Router
import com.home.newlessonthirdcourse.GithubUser
import com.home.newlessonthirdcourse.R
import com.home.newlessonthirdcourse.UsersScreen
import moxy.InjectViewState
import moxy.MvpPresenter

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }
}

