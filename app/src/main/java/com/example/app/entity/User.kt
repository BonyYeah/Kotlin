package com.example.app.entity

/**
 * Created by Bony on 12/24/20.
 */
data class User(
    val username: String?,
    val password: String?,
    val code: String?) {
    constructor() : this(null, null, null)
}