package com.example.android4a.presentation.createUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.example.android4a.presentation.main.MainActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_create_user.*
import kotlinx.android.synthetic.main.activity_create_user.email_edit
import kotlinx.android.synthetic.main.activity_create_user.password_edit
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class CreateUserActivity : AppCompatActivity() {
    private val createUserViewModel: CreateUserViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        createUserViewModel.createLiveData.observe(this, Observer { it ->
            when (it){
                is CreateSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Succès")
                        .setMessage("Compte créé")
                        .setPositiveButton("OK") {
                                dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
                CreateError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Champs erronés")
                        .setPositiveButton("OK") {
                                dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        register_button.setOnClickListener{
            createUserViewModel.onClickedCreate(
                emailUser = email_edit.text.toString().trim(),
                password = password_edit.text.toString()
            )
        }
        back_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}