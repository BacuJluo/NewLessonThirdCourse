package com.home.newlessonthirdcourse.repository.impl

class CountersRepository {
    private val counters = mutableListOf(1,1,1)

    fun getCurrent(position:Int):Int{ //FIXME("Для чего эту функцию создали?")
        return counters[position]
    }

    fun next(position: Int):Int{
        return counters[position]++
    }

    fun set(position: Int, value:Int){ //FIXME("Где использовать, и зачем она нужна эта функция?")
        counters[position] = value
    }
}