package com.example.dawam

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("error")
fun bindErrorOnTextInputLayout(textInputLayout: TextInputLayout,
                               errorMessag: String?){
    textInputLayout.error = errorMessag

}