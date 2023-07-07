package com.example.dawam.ui.apply_waqf

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dawam.api.ApiManager
import com.example.dawam.api.model.waqfActivitiesResponse.WaqfActivitiesResponse
import com.example.dawam.api.model.waqfCountriesResponse.WaqfCountriesResponse
import com.example.dawam.databinding.FragmentApplyWaqfRequestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.AdapterView.OnItemClickListener
import android.widget.EditText
import android.widget.Toast
import com.example.dawam.api.model.waqfRequestResponse.WaqfRequestResponse
import com.example.dawam.api.model.waqfCitiesResponse.WaqfCitiesResponse
import com.example.dawam.api.model.waqfRequest.WaqfRequest
import com.example.dawam.api.model.waqfTypesResponse.WaqfTypesResponse
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class ApplyWaqfRequestFragment : Fragment() {
    private lateinit var viewBinding: FragmentApplyWaqfRequestBinding
    private lateinit var viewModel :ApplyWaqfRequestViewModel
    private lateinit var adapterActivities: ArrayAdapter<String>
    private lateinit var adapterCountries: ArrayAdapter<String>
    private lateinit var adapterCities: ArrayAdapter<String>
    private lateinit var adapterTypes: ArrayAdapter<String>

    lateinit var country :WaqfCountriesResponse
    lateinit var city :WaqfCitiesResponse
    lateinit var type :WaqfTypesResponse
    lateinit var activity :WaqfActivitiesResponse



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentApplyWaqfRequestBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplyWaqfRequestViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.content.addBtn.setOnClickListener {
            if(validateEditText(viewBinding.content.waqfNameEt)
                &&validateEditText(viewBinding.content.personNameEt)
                &&validateEditText(viewBinding.content.waqfDateEt)
                &&validateEditText(viewBinding.content.waqfDateHEt)
                &&validateAutoCompleteTextView( viewBinding.content.waqfActivities.editText as AutoCompleteTextView)
                &&validateEditText(viewBinding.content.waqfCountries.editText as AutoCompleteTextView)
                &&validateEditText(viewBinding.content.waqfCities.editText as AutoCompleteTextView)
                &&validateEditText(viewBinding.content.waqfType.editText as AutoCompleteTextView)
                &&validateEditText(viewBinding.content.waqfDescriptionEt)
            ){
                sendDataToApi()
            }

        }
        loadWaqfActivitiesDropdown()
        loadCountriesDropdown()
        //(viewBinding.content.waqfCities.editText as? AutoCompleteTextView)?.isEnabled=false
        loadCitiesDropdown(1)
        loadTypesDropdown()
        var textView =viewBinding.title
        val anim = ScaleAnimation(
            0f, 1f, // Start and end values for the X axis scaling
            0f, 1f, // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 0.5f // Pivot point of Y scaling
        )
        anim.duration = 500
        textView.startAnimation(anim)
    }

    private fun sendDataToApi() {
        viewBinding.content.idLoadingPB.setVisibility(View.VISIBLE)

        val waqfName = viewBinding.content.waqfNameEt.text.toString()
        val founderName =viewBinding.content.personNameEt.text.toString()
        val establishmentDate = viewBinding.content.waqfDateEt.text.toString()
        val establishmentDateH = viewBinding.content.waqfDateHEt.text.toString()
        val waqfDescription = viewBinding.content.waqfDescriptionEt.text.toString()

        val formatter = DateTimeFormatter.ofPattern("M/d/yyyy")
        val date = LocalDate.parse("2/28/2000", formatter)
        val isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val establishmentDateFormatted = isoFormatter.format(date.atStartOfDay())

        val dateH = LocalDate.parse("2/28/2000", formatter)
        val establishmentDateFormattedH = isoFormatter.format(dateH.atStartOfDay())

        val countryId = country.id
        val cityId = city.id
        val activityId = activity.id
        val typeId = type.id
        val waqfImage ="http://afdinc-001-site5.itempurl.com/waqfImages/0WhatsAppImage2023-04-10at2.42.26AM.jpeg"
        val waqfDocument ="http://afdinc-001-site5.itempurl.com/waqfDocuments/0AI_Groups.pdf"
        val insUserId =1
        val documentNumber =8
        val waqfRequest = WaqfRequest(waqfName, founderName, documentNumber, establishmentDateFormatted, establishmentDateFormattedH, waqfDescription, countryId,cityId,
        typeId, activityId, waqfImage, waqfDocument, insUserId)
        ApiManager.getApis().sendWaqfRequest(waqfRequest).enqueue(object : Callback<WaqfRequestResponse> {
            override fun onResponse(
                call: Call<WaqfRequestResponse>,
                response: Response<WaqfRequestResponse>
            ) {
                if (response.isSuccessful) {
                    val res = response.body()
                    Log.e("onResponse: result is ", res.toString())
                    Toast.makeText(requireActivity(), "Data added to API", Toast.LENGTH_SHORT).show();
                    // below line is for hiding our progress bar.
                    viewBinding.content.idLoadingPB.setVisibility(View.GONE);

                } else {
                    val errorCode = response.code( )
                    val errorMessage = response.message( )

                }
            }

            override fun onFailure(p0: Call<WaqfRequestResponse>, p1: Throwable) {
                p1.localizedMessage?.let { Log.e("onFailure: false", it) }
            }
        })


    }
    private fun loadWaqfActivitiesDropdown() {
        adapterActivities = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, ArrayList())
        (viewBinding.content.waqfActivities.editText as? AutoCompleteTextView)?.setAdapter(adapterActivities)
        (viewBinding.content.waqfActivities.editText as? AutoCompleteTextView)?.threshold = 1
        fetchActivityItems()
    }
    private fun  fetchActivityItems() {
        //get WaqfRequest Activities
        ApiManager.getApis().getWaqfActivities()
            .enqueue(object : Callback<ArrayList<WaqfActivitiesResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<WaqfActivitiesResponse>>,
                    response: Response<ArrayList<WaqfActivitiesResponse>>
                ) {
                    if (response.isSuccessful) {
                        val waqfActivitiesList = response.body()!!
                        val activitiesNames =
                            waqfActivitiesList?.mapNotNull { it.waqfActivityName } ?: emptyList()
                        adapterActivities.clear()
                        adapterActivities.addAll(activitiesNames)
                        (viewBinding.content.waqfActivities.editText as? AutoCompleteTextView)?.onItemClickListener = OnItemClickListener { parent, _, position, _ ->
                            val selectedItem = parent.getItemAtPosition(position)
                            if (selectedItem is String) {
                                activity= waqfActivitiesList.get(position)
                            }}
                    } else {
                        // Handle the error
                    }
                }

                override fun onFailure(p0: Call<ArrayList<WaqfActivitiesResponse>>, p1: Throwable) {
                    // Handle the error
                }

            })


    }

    private fun loadCountriesDropdown() {
        adapterCountries = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, ArrayList())
        (viewBinding.content.waqfCountries.editText as? AutoCompleteTextView)?.setAdapter(adapterCountries)
        (viewBinding.content.waqfCountries.editText as? AutoCompleteTextView)?.threshold = 1
        fetchCountriesItems()


    }
    private fun fetchCountriesItems() {
        ApiManager.getApis().getCountries()
            .enqueue(object : Callback<ArrayList<WaqfCountriesResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<WaqfCountriesResponse>>,
                    response: Response<ArrayList<WaqfCountriesResponse>>
                ) {
                    if (response.isSuccessful) {
                        val countriesList = response.body()!!
                        val countriesNames =
                            countriesList?.mapNotNull { it.countryName } ?: emptyList()
                        adapterCountries.clear()
                        adapterCountries.addAll(countriesNames)
                        (viewBinding.content.waqfCountries.editText as? AutoCompleteTextView)?.onItemClickListener = OnItemClickListener { parent, _, position, _ ->
                            val selectedItem = parent.getItemAtPosition(position)
                            if (selectedItem is String) {
                                country= countriesList.get(position)
                            }

                        }

                    } else {
                        // Handle the error
                    }
                }

                override fun onFailure(p0: Call<ArrayList<WaqfCountriesResponse>>, p1: Throwable) {
                    // Handle the error
                }

            })

    }

    private fun loadCitiesDropdown(id:Int){
        adapterCities = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, ArrayList())
        (viewBinding.content.waqfCities.editText as? AutoCompleteTextView)?.setAdapter(adapterCities)
        (viewBinding.content.waqfCities.editText as? AutoCompleteTextView)?.threshold = 1
        fetchCityItems(id)
    }
    private fun fetchCityItems(id:Int) {
        ApiManager.getApis().getCities(id)
            .enqueue(object : Callback<ArrayList<WaqfCitiesResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<WaqfCitiesResponse>>,
                    response: Response<ArrayList<WaqfCitiesResponse>>
                ) {
                    if (response.isSuccessful) {
                        val citiesList = response.body()!!
                        val citiesNames =
                            citiesList?.mapNotNull { it.cityName } ?: emptyList()
                        adapterCities.clear()
                        adapterCities.addAll(citiesNames)
                        (viewBinding.content.waqfCities.editText as? AutoCompleteTextView)?.onItemClickListener = OnItemClickListener { parent, _, position, _ ->
                            val selectedItem = parent.getItemAtPosition(position)
                            if (selectedItem is String) {
                                city= citiesList.get(position)
                            }
                    } }
                    else {
                        // Handle the error
                    }
                }

                override fun onFailure(p0: Call<ArrayList<WaqfCitiesResponse>>, p1: Throwable) {
                    // Handle the error
                }

            })
    }

    private fun loadTypesDropdown(){
        adapterTypes = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, ArrayList())
        (viewBinding.content.waqfType.editText as? AutoCompleteTextView)?.setAdapter(adapterTypes)
        (viewBinding.content.waqfType.editText as? AutoCompleteTextView)?.threshold = 1
        fetchTypeItems()
    }
    private fun fetchTypeItems() {
        ApiManager.getApis().getWaqfTypes()
            .enqueue(object : Callback<ArrayList<WaqfTypesResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<WaqfTypesResponse>>,
                    response: Response<ArrayList<WaqfTypesResponse>>
                ) {
                    if (response.isSuccessful) {
                        val typesList = response.body()!!
                        val typesNames =
                            typesList?.mapNotNull { it.typeName } ?: emptyList()
                        adapterTypes.clear()
                        adapterTypes.addAll(typesNames)
                        (viewBinding.content.waqfType.editText as? AutoCompleteTextView)?.onItemClickListener = OnItemClickListener { parent, _, position, _ ->
                            val selectedItem = parent.getItemAtPosition(position)
                            if (selectedItem is String) {
                                type= typesList.get(position)
                            }
                        } }

                     else {
                        // Handle the error
                    }
                }

                override fun onFailure(p0: Call<ArrayList<WaqfTypesResponse>>, p1: Throwable) {
                    // Handle the error
                }

            })
    }


    // validate the EditText field
    fun validateEditText(editText: EditText): Boolean {
        val input = editText.text.toString().trim()
        return if (input.isEmpty()) {
            editText.error = "Field is required"
            false
        } else {
            true
        }
    }

    // validate the AutoCompleteTextView field
    fun validateAutoCompleteTextView(autoCompleteTextView: AutoCompleteTextView): Boolean {
        val input = autoCompleteTextView.text.toString().trim()
        return if (input.isEmpty()) {
            autoCompleteTextView.error = "Field is required"
            false
        } else {
            true
        }
    }


}

