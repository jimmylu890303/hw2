package com.example.hw2
import android.app.Application

class GlobalVariable:Application() {
    companion object {
        private var loginAccount: Account? =null;
        fun setAccount(account: Account){
            this.loginAccount=account
        }
        fun getAccount(): Account? {
             return this.loginAccount
        }
        fun logout(){
            this.loginAccount = null
        }

    }
}