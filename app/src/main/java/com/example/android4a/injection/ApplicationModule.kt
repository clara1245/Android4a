package com.example.android4a.injection
import android.content.Context
import androidx.room.Room
import com.example.android4a.api.TMDBApi
import com.example.android4a.data.local.AppDatabase
import com.example.android4a.data.local.DatabaseDao
import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetTopRatedResponseUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import com.example.android4a.presentation.createUser.CreateUserViewModel
import com.example.android4a.presentation.home.HomeViewModel
import com.example.android4a.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get()) }
    factory { CreateUserViewModel(get()) }
    factory { HomeViewModel(get()) }

}
    
val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetTopRatedResponseUseCase() }

}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }

}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase : AppDatabase =  Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-base"
    ).build()
   return appDatabase.databaseDao()
}
