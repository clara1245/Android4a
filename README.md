# Top Rated Movies App

## Author: Clara Nacache


Mobile Android App in Kotlin Language. <br>
This app displays a list of the top rated French movies (from([The Movie Database](https://www.themoviedb.org/)) Api) and gives their title and description. <br>
You can create an account and login to access to this movies list.

## Librairies used:
+ [Picasso](https://square.github.io/picasso/)
+ [RecyclerView](https://developer.android.com/jetpack/androidx/releases/recyclerview)
+ [Retrofit 2](https://square.github.io/retrofit/)
+ [Room](https://developer.android.com/jetpack/androidx/releases/room)
+ [Material Design](https://github.com/material-components/material-components-android/releases)
+ [Junit4](https://junit.org/junit4/)
+ [Koin](https://github.com/InsertKoinIO/koin)
+ [Mockk](https://mockk.io/)
+ [OkHTTP3 Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
+ [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
+ [Coroutines](https://developer.android.com/kotlin/coroutines)


## How to use the app?
When lauching the application, the first view is a login form, with "login" and "create account" buttons. <br>
<img align="center" width="300" height="600" src="https://github.com/clara1245/Android4a/blob/master/app/src/ReadMe_pictures/login.jpeg"/> <br>
When the button "create account" is clicked , a register form appears, and you can enter new credentials. Then, you can click on "Register" button and access to
the home view. You can also go back to the login view once registered. </p>
<img align="center" width="300" height="600" src="https://github.com/clara1245/Android4a/blob/master/app/src/ReadMe_pictures/register.jpeg"/>
The home activity is a list of items showing the top rated French movies, with a scroll option.
<img align="center" width="300" height="600" src="https://github.com/clara1245/Android4a/blob/master/app/src/ReadMe_pictures/list2.jpeg"/>
<img align="center" width="300" height="600" src="https://github.com/clara1245/Android4a/blob/master/app/src/ReadMe_pictures/list1.jpeg"/>

## Improvements:
To improve this mobile application, we could add an activity for each item, and an item view, in order to click on a movie item and display all the movie characteristics.
