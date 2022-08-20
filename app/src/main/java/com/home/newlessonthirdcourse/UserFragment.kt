package com.home.newlessonthirdcourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.home.newlessonthirdcourse.databinding.FragmentUserListBinding
import com.home.newlessonthirdcourse.main.OnRecycleIViewItemClickListener
import com.home.newlessonthirdcourse.main.UserView
import com.home.newlessonthirdcourse.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener{

    companion object{
        fun getInstance():UserFragment{
            return UserFragment()
        }
    }

    private lateinit var viewBinding:FragmentUserListBinding

    private val adapter = UserAdapter(object : OnRecycleIViewItemClickListener{
        override fun onItemViewClick(user: GithubUser) {
            onUserClicked(user)
        }


    })
    private val presenter:UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(),GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater,container,false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding){
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }

        Consumer().subscribe()
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }


    override fun onBackPressed() = presenter.onBackPressed()

    override fun onUserClicked(user: GithubUser) {
        presenter.onUserClicked(user)
    }

}
