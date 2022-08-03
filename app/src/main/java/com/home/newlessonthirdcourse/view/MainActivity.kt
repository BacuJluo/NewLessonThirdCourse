package com.home.newlessonthirdcourse.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.home.newlessonthirdcourse.MainView
import com.home.newlessonthirdcourse.R
import com.home.newlessonthirdcourse.databinding.ActivityMainBinding
import com.home.newlessonthirdcourse.presenter.CountersPresenter
import com.home.newlessonthirdcourse.utils.Utils.Companion.FIRST_BUTTON
import com.home.newlessonthirdcourse.utils.Utils.Companion.FIRST_COUNTER_POSITION
import com.home.newlessonthirdcourse.utils.Utils.Companion.SECOND_BUTTON
import com.home.newlessonthirdcourse.utils.Utils.Companion.SECOND_COUNTER_POSITION
import com.home.newlessonthirdcourse.utils.Utils.Companion.THIRD_BUTTON
import com.home.newlessonthirdcourse.utils.Utils.Companion.ZERO_COUNTER_POSITION

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
        initButtonClick()

    }

    private fun initButtonClick() {
        with(binding){
            btnNumberOne.setOnClickListener {
                presenter.onCounterClick(FIRST_BUTTON)
            }
            btnNumberTwo.setOnClickListener {
                presenter.onCounterClick(SECOND_BUTTON)
            }
            btnNumberThree.setOnClickListener {
                presenter.onCounterClick(THIRD_BUTTON)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String,position:Int) {
        with(binding){
            when(position){
                ZERO_COUNTER_POSITION -> tvText.text = counter
                FIRST_COUNTER_POSITION -> tvTextTwo.text = counter
                SECOND_COUNTER_POSITION -> tvTextThree.text = counter
            }
        }

    }
}