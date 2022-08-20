package com.home.newlessonthirdcourse

import android.util.Log
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.IllegalStateException
import java.util.concurrent.TimeUnit

class Producer{

    fun just():Observable<Int>{
        return Observable.just(1,2,3)
    }

    fun fromIterable(): @NonNull Observable<Int> {
        return Observable.fromIterable(listOf(1,2,3,4,5))
    }

    fun interval1(): Observable<Long> {
        return Observable.interval(1,TimeUnit.SECONDS)
    }
    fun interval2(): Observable<Long> {
        return Observable.interval(500,TimeUnit.MILLISECONDS)
    }

    fun timer():Observable<Long>{
        return Observable.timer(5,TimeUnit.SECONDS)
    }

    fun range():Observable<Int>{
        return Observable.range(0, 10) //от 0 до 9 = 10 раз..
    }

    fun fromCallable():Observable<Byte>{
        return Observable.fromCallable {
            16
        }
    }

    fun fromIterableLong():Observable<Long>{
        return Observable.fromIterable((1L..100L).toList())
    }
    fun fromIterableLong2():Observable<Long>{
        return Observable.fromIterable((102L..120L).toList())
    }

    fun create():Observable<Int>{
        return Observable.create{ observableEmitter ->
            (1..10).forEach {
                observableEmitter.onNext(it)
            }
            observableEmitter.onError(IllegalStateException("Ошибка!!"))
        }
    }

}

class Consumer {
    private val producer = Producer()
    private lateinit var disposable:Disposable

    fun subscribe(){

        val observable1 = producer.interval1()
            .filter{ it.mod(3) == 0}

        /*val observable2 = producer.interval2()*/

        observable1.flatMap {
            Observable.just(it * 2)
        }

        /*//disposable = Observable.merge(producer.fromIterableLong(),producer.fromIterableLong2())
        //disposable = Observable.merge(observable1,observable2)
            /*.map {
                Log.d("RxJava", "Получили элемент 1 -> $it")
                it
            }
            .map {
                it - 10
            }
            .skip( 2)*/
            /*.filter {
                it.mod(3) == 0
            }*/
            /*.map {
                it.mod(5)
            }*/
            /*.distinct()*/*/

            .doOnSubscribe {
                Log.d("RxJava", "Подписались на поток")
            }
            .subscribe(
                { element ->
                    Log.d("RxJava", "Получили элемент $element")

                    /***** Для метода interval *****/
                    /*if (element > 15){
                        Log.d("RxJava", "Поток завершен 1")
                        disposable.dispose() /** остановка потока данных **/
                    }*/
                },
                {
                    Log.d("RxJava", "Получили ошибку \n 1 --> [$it]", it)
                },
                {
                    Log.d("RxJava", "Поток завершен")
                }
            )
    }
}



/*    val observer = object :Observer<Int>{
        override fun onSubscribe(d: Disposable) = Unit

        override fun onNext(t: Int) {
            println("Норм: $t")
        }

        override fun onError(e: Throwable) {
            println("Что то пошло не так $e")
        }

        override fun onComplete() {
            println("Готово")
        }
    }

    * 1 Способ
    val observable = Observable.create{ emmiter ->

        try {
            data.forEach {
                emmiter.onNext(it)
            }
        }catch (e:Throwable){
            emmiter.onError(e)
        }
        emmiter.onComplete()
    }

    observable.subscribe(observer)

    * 2 Способ самый простой, иногда можно использовать..
    Observable.just(1,2,3,4,5)

    * 3 Способ, такой же почти как Just
    Observable.fromIterable(data)
        .subscribe(){ element ->
            println(element)
        }

    *4 Способ почти как 3 Способ только можно уловить ошибку
    Observable.fromIterable(data)
        .subscribe(
            { element ->
                println(element)
            },
            { error ->
                println("Что то пошло не так $error")
            }
        )*/





