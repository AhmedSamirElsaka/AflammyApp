package com.example.aflammy.domain.usecases.login

import com.example.aflammy.utilities.FormFieldState
import javax.inject.Inject

class ValidateFiledUseCase @Inject constructor(){
    operator fun invoke(text: String) : FormFieldState {
        if (text.isBlank() || text.isEmpty()){
            return FormFieldState.InValid("Required")
        }
        return FormFieldState.Valid
    }
}