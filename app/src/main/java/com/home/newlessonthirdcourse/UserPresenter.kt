package com.home.newlessonthirdcourse

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.github.terrakok.cicerone.Router
import com.home.newlessonthirdcourse.main.UserView
import com.home.newlessonthirdcourse.repository.GithubRepository
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class UserPresenter(
    private val repository: GithubRepository,
    private val router:Router
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repository.getUsers().subscribe {
            viewState.initList(it)
            //viewState.hideLoading()
        }
    }

    fun onBackPressed(): Boolean {
         router.exit()
        return true
    }

    fun onUserClicked(user: GithubUser){
        router.navigateTo(UsersScreen.userEmailScreen(
            Bundle().apply {
                putParcelable(
                    EmailFragment.BUNDLE_EXTRA,
                    user
                )
            }))
    }

}