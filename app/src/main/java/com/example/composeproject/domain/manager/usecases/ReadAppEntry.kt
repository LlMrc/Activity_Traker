package com.example.composeproject.domain.manager.usecases

import com.example.composeproject.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val  localManager: LocalUserManager) {

     operator fun  invoke(): Flow<Boolean> {
      return  localManager.readAppEntry()
    }
}