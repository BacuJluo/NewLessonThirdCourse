package com.home.newlessonthirdcourse

import android.os.Bundle
import android.view.View
import com.home.newlessonthirdcourse.databinding.FragmentEmailBinding
import com.home.newlessonthirdcourse.utils.ViewBindingFragment
import moxy.ktx.moxyPresenter

class EmailFragment : ViewBindingFragment<FragmentEmailBinding>(FragmentEmailBinding::inflate),
    EmailsView, OnBackPressedListener {
    private lateinit var userBundle: GithubUser

    companion object {
        const val BUNDLE_EXTRA = "BUNDLE_EXTRA"
        fun newInstance(bundle: Bundle): EmailFragment =
            EmailFragment().apply { arguments = bundle }
    }

    private val presenter: EmailPresenter by moxyPresenter {
        EmailPresenter(GeekBrainsApp.instance.router)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let { it?.getParcelable(BUNDLE_EXTRA) ?: GithubUser(login = "error") }
            .also { userBundle = it }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun initEmail() = with(binding) {
        tvSecondFragment.text = userBundle.login
    }
}

