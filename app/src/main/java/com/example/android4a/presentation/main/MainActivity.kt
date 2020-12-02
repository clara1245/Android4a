package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.presentation.CreateUserActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.loginLiveData.observe(this, Observer { it ->
            when (it){
                is LoginSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Succès")
                        .setMessage("Authentifié")
                        .setPositiveButton("OK") {
                                dialog, which ->
                                dialog.dismiss()
                        }
                        .show()
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Identifiants incorrects")
                        .setPositiveButton("OK") {
                            dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })



        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(
                emailUser = login_edit.text.toString().trim(),
                password = password_edit.text.toString()
            )

        }
       create_account_button.setOnClickListener {
           val intent = Intent(this, CreateUserActivity::class.java)
           startActivity(intent)

        }
    }
}