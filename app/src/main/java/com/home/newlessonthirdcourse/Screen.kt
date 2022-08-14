package com.home.newlessonthirdcourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import moxy.MvpFacade.getInstance

object UsersScreen:FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }

    fun userEmailScreen(bundle: Bundle) = FragmentScreen {
        EmailFragment.newInstance(bundle)
    }

}