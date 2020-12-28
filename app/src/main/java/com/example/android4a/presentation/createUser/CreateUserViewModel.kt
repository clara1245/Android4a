package com.example.android4a.presentation.createUser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateUserViewModel (
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {
    val createLiveData: MutableLiveData<CreateStatus> = MutableLiveData()
    fun onClickedCreate(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val createStatus = if (
                emailUser.isNotEmpty() && emailUser.isNotBlank() &&
                password.isNotEmpty() && password.isNotBlank()
            )
                if ( emailUser.matches(Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\Q.\\E[a-zA-Z]{2,}$")) ) {
                    val user = User(emailUser,password)
                    createUserUseCase.invoke(user)
                    CreateSuccess
                } else {
                    CreateError
                }
            else {
                CreateError
            }
            withContext(Dispatchers.Main) {
                createLiveData.value = createStatus
            }

        }
    }

}
