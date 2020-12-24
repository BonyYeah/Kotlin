package com.example.core.http

/**
 * Created by Bony on 12/24/20.
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)
    fun onFailure(message: String)
}