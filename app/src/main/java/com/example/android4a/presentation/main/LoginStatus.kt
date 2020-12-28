package com.example.android4a.presentation.main

sealed class LoginStatus

object LoginSuccess : LoginStatus()
object LoginError : LoginStatus()

