package com.example.movie.repos

interface UserDataSource {
    fun createAccountInFireBase(email:String,password:String)
    fun resetPassword(email: String)
    fun logInFireBase(email: String,password: String)


}
interface UserOnlineDataSource{

}