package br.com.heiderlopes.modularizacao.viewmodel

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer

class StateMachineSingle<T> : SingleTransformer<T, ViewState<T>> {

    override fun apply(upstream: Single<T>): SingleSource<ViewState<T>> {
        return upstream
            .map {
                ViewState.Success(it) as ViewState<T>
            }
            .onErrorReturn {
                ViewState.Failed(it)
            }
            .doOnSubscribe {
                ViewState.Loading
            }
    }
}
