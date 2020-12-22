package com.example.android4a.presentation.createUser

sealed class CreateStatus

data class CreateSuccess (val email: String): CreateStatus()
object CreateError : CreateStatus()