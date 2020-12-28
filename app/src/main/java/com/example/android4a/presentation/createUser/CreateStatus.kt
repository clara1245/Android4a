package com.example.android4a.presentation.createUser

sealed class CreateStatus

object CreateSuccess : CreateStatus()
object CreateError : CreateStatus()