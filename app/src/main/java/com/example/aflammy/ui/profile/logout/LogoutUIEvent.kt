package com.example.aflammy.ui.profile.logout

sealed interface LogoutUIEvent {
    object LogoutEvent : LogoutUIEvent
    object CloseDialogEvent : LogoutUIEvent
}