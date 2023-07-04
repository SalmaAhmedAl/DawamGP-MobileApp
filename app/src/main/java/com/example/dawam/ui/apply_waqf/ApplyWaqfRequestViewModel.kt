package com.example.dawam.ui.apply_waqf

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class ApplyWaqfRequestViewModel: ViewModel() {
    val waqfName = ObservableField<String>()
    val waqfNameError = ObservableField<String?>()
    val personName = ObservableField<String>()
    val personNameError = ObservableField<String?>()
    val dateOfWaqf = ObservableField<String>()
    val dateOfWaqfError = ObservableField<String?>()
    val dateOfWaqfH = ObservableField<String>()
    val dateOfWaqfErrorH = ObservableField<String?>()
    val waqfType = ObservableField<String>()
    val waqfTypeError = ObservableField<String?>()
    val waqfActivity = ObservableField<String>()
    val waqfActivityError = ObservableField<String?>()
    val waqfCountry = ObservableField<String>()
    val waqfCountryError = ObservableField<String?>()
    val waqfCity = ObservableField<String>()
    val waqfCityError = ObservableField<String?>()
    val waqfDescription = ObservableField<String>()
    val waqfDescriptionError = ObservableField<String?>()

    fun register() :Boolean{
         if(validate())
             return true
        return validate()
    }
    fun validate():Boolean{
        var isValid= true
        if(waqfName.get().isNullOrBlank()){
            waqfNameError.set("يجب إدخال اسم الوقف")
            isValid = false
        }else{
            isValid = true
            waqfNameError.set(null)
        }
        if(personName.get().isNullOrBlank()){
            personNameError.set("يجب إدخال اسم الواقف")
            isValid = false
        }else{
            isValid = true
            personNameError.set(null)
        }
        if(dateOfWaqf.get().isNullOrBlank()){
            dateOfWaqfError.set("يجب إدخال تاريخ الوقف")
            isValid = false
        }else{
            isValid = true
            dateOfWaqfError.set(null)
        }
        if(dateOfWaqfH.get().isNullOrBlank()){
            dateOfWaqfErrorH.set("يجب إدخال تاريخ الوقف هجريًا")
            isValid = false
        }else{
            isValid = true
            dateOfWaqfErrorH.set(null)
        }

        if(waqfDescription.get().isNullOrBlank()){
            waqfDescriptionError.set("من فضلك ادخل وصف الوقف")
            isValid = false
        }else{
            isValid = true
            waqfDescriptionError.set(null)
        }
        if(waqfType.get().isNullOrBlank()){
            waqfTypeError.set("من فضلك اختر نوع الوقف")
            isValid = false
        }else{
            isValid = true
            waqfTypeError.set(null)
        }
        if(waqfActivity.get().isNullOrBlank()){
            waqfActivityError.set("من فضلك اختر نشاط الوقف")
            isValid = false
        }else{
            isValid = true
            waqfActivityError.set(null)
        }
        if(waqfCountry.get().isNullOrBlank()){
            waqfCountryError.set("من فضلك اختر ريع الوقف")
            isValid = false
        }else{
            isValid = true
            waqfCountryError.set(null)
        }
        if(waqfCity.get().isNullOrBlank()){
            waqfCityError.set("من فضلك اختر مدينة الوقف")
            isValid = false
        }else{
            isValid = true
            waqfCityError.set(null)
        }
        return isValid
    }
}