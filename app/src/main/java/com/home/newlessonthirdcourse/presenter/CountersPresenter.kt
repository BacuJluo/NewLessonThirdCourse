package com.home.newlessonthirdcourse.presenter

import com.home.newlessonthirdcourse.MainView
import com.home.newlessonthirdcourse.model.CountersModel
import com.home.newlessonthirdcourse.utils.Utils.Companion.FIRST_BUTTON
import com.home.newlessonthirdcourse.utils.Utils.Companion.FIRST_COUNTER_POSITION
import com.home.newlessonthirdcourse.utils.Utils.Companion.SECOND_BUTTON
import com.home.newlessonthirdcourse.utils.Utils.Companion.SECOND_COUNTER_POSITION
import com.home.newlessonthirdcourse.utils.Utils.Companion.THIRD_BUTTON
import com.home.newlessonthirdcourse.utils.Utils.Companion.ZERO_COUNTER_POSITION

class CountersPresenter(
    private val view: MainView
) {

    private val model = CountersModel()

    fun onCounterClick(id: Int){
        when(id){
            FIRST_BUTTON -> {
                view.setText(newValue(ZERO_COUNTER_POSITION).toString(),ZERO_COUNTER_POSITION)
            }
            SECOND_BUTTON -> {
                view.setText(newValue(FIRST_COUNTER_POSITION).toString(),FIRST_COUNTER_POSITION)
            }
            THIRD_BUTTON -> {
                view.setText(newValue(SECOND_COUNTER_POSITION).toString(),SECOND_COUNTER_POSITION)
            }
        }
    }

    private fun newValue(position: Int): Int {
        return model.next(position)
    }
}