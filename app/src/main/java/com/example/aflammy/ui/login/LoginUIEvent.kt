package com.example.aflammy.ui.login

sealed interface LoginUIEvent {
    data class LoginEvent(val login: Int) : LoginUIEvent
    object SignUpEvent : LoginUIEvent
}