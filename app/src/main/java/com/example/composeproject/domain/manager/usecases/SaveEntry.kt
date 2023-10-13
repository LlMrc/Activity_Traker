package com.example.composeproject.domain.manager.usecases

import com.example.composeproject.domain.manager.LocalUserManager

class SaveEntry(private  val localManager: LocalUserManager) {
   suspend operator fun invoke(){
       localManager.saveAppEntry()
   }

}