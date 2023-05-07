package com.example.dawam.ui.apply_waqf

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class ApplayWaqfRequestViewModel: ViewModel() {
    val waqfName = ObservableField<String>()
    val waqfNameError = ObservableField<String?>()
    val waqefName = ObservableField<String>()
    val waqefNameError = ObservableField<String?>()
    val dateOfWaqf = ObservableField<String>()
    val dateOfWaqfError = ObservableField<String?>()
    val waqfType = ObservableField<String>()
    val waqfTypeError = ObservableField<String?>()
    val waqfDiscreption = ObservableField<String>()
    val waqfDiscreptionError = ObservableField<String?>()
    val goodReturnFromTheWaqf = ObservableField<String>()
    val goodReturnFromTheWaqfError = ObservableField<String?>()
    var navigator : Navigator? = null
    fun register() {
        if(!validate()) return
        navigator?.showMessage("تمت العملية بنجاح")
    }
    fun validate():Boolean{
        var isValid= true
        if(waqfName.get().isNullOrBlank()){
            waqfNameError.set("من فضلك ادخل اسم الوقف")
            isValid = false
        }else{
            isValid = true
            waqfNameError.set(null)
        }
        if(waqefName.get().isNullOrBlank()){
            waqefNameError.set("من فضلك ادخل اسم الواقف")
            isValid = false
        }else{
            isValid = true
            waqefNameError.set(null)
        }
        if(dateOfWaqf.get().isNullOrBlank()){
            dateOfWaqfError.set("من فضلك ادخل تاريخ الوقف")
            isValid = false
        }else{
            isValid = true
            dateOfWaqfError.set(null)
        }
        if(goodReturnFromTheWaqf.get().isNullOrBlank()){
            goodReturnFromTheWaqfError.set("من فضلك ادخل ريع الوقف")
            isValid = false
        }else{
            isValid = true
            goodReturnFromTheWaqfError.set(null)
        }
        if(waqfDiscreption.get().isNullOrBlank()){
            waqfDiscreptionError.set("من فضلك ادخل وصف الوقف")
            isValid = false
        }else{
            isValid = true
            waqfDiscreptionError.set(null)
        }
        if(waqfType.get().isNullOrBlank()){
            waqfTypeError.set("من فضلك ادخل نوع الوقف")
            isValid = false
        }else{
            isValid = true
            waqfTypeError.set(null)
        }
        return isValid
    }
}