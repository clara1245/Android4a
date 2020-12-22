package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.example.android4a.presentation.createUser.CreateUserActivity
import com.example.android4a.presentation.home.HomeActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.email_edit
import kotlinx.android.synthetic.main.activity_main.password_edit
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.loginLiveData.observe(this, Observer { it ->
            when (it){
                is LoginSuccess -> {
                   /* MaterialAlertDialogBuilder(this)
                        .setTitle("Succès")
                        .setMessage("Authentifié")
                        .setPositiveButton("OK") {
                                dialog, _ ->
                                dialog.dismiss()
                        }
                        .show()*/
                    val intent = Intent (this, HomeActivity::class.java)
                    startActivity(intent)
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Identifiants incorrects")
                        .setPositiveButton("OK") {
                                dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })



        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(
                emailUser = email_edit.text.toString().trim(),
                password = password_edit.text.toString()
            )

        }
       create_account_button.setOnClickListener {
           val intent = Intent(this, CreateUserActivity::class.java)
           startActivity(intent)
        }

    }
}