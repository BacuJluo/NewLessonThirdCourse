package com.home.newlessonthirdcourse

import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class EmailPresenter (private val router: Router
) : MvpPresenter<EmailsView>()  {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initEmail()
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}