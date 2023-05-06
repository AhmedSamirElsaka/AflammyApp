package com.example.aflammy.ui.profile.logout

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aflammy.R
import com.example.aflammy.databinding.DialogLogoutBinding
import com.example.aflammy.ui.base.BaseDialog
import com.example.aflammy.utilities.collectLast
import com.example.aflammy.utilities.setWidthPercent
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LogoutDialog() : BaseDialog<DialogLogoutBinding>(), Parcelable {
    override val layoutIdFragment: Int = R.layout.dialog_logout
    override val viewModel: LogoutViewModel by viewModels()

    constructor(parcel: Parcel) : this() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setWidthPercent(90)
        collectLast(viewModel.logoutUIEvent) {
            it.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: LogoutUIEvent) {
        when (event) {
            LogoutUIEvent.CloseDialogEvent -> {
                dismiss()
            }
            LogoutUIEvent.LogoutEvent -> {
                findNavController().navigate(R.id.action_logoutDialog_to_homeFragment)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LogoutDialog> {
        override fun createFromParcel(parcel: Parcel): LogoutDialog {
            return LogoutDialog(parcel)
        }

        override fun newArray(size: Int): Array<LogoutDialog?> {
            return arrayOfNulls(size)
        }
    }

}