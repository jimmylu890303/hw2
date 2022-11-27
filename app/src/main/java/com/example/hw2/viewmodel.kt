package com.example.hw2

import android.util.Log
import androidx.lifecycle.ViewModel

class viewmodel: ViewModel() {
    private val accountList = ArrayList<Account>().apply {
        add(Account("jimmy","123456","盧俊銘","410723015"))
        add(Account("123456","123456","小胖貓","123465"))
    }
    private var loginAcc: Account? = null;

    fun login(acc:String,pass:String):Int{
        var flag:Int=0;
        for(account in accountList){
            if(account.account==acc && account.password==pass)
            {
                flag=1
                loginAcc = account
                return flag
            }
        }
        return flag
    }
    fun getLoginData(): Account? {
        return loginAcc
    }
}