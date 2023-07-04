package com.example.dawam.ui.apply_waqf

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.example.dawam.api.model.WaqfRequest
import com.example.dawam.api.model.waqfRequestResponse.WaqfRequestResponse
import com.example.dawam.api.model.waqfCitiesResponse.WaqfCitiesResponse
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
    private val waqfImage ="http://afdinc-001-site5.itempurl.com/waqfImages/0WhatsAppImage2023-04-10at2.42.26AM.jpeg"
    private val waqfDocument ="http://afdinc-001-site5.itempurl.com/waqfDocuments/0AI_Groups.pdf"
    private val insUserId ="1"
    private val documentNumber =8
    val waqfRequest = WaqfRequest()



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
        viewBinding.vm = viewModel
        viewBinding.content.addBtn.setOnClickListener {
           val f= viewModel.register()
            if(f){
                sendDataToApi()
            }

        }
        loadWaqfActivitiesDropdown()
        loadCountriesDropdown()
        //(viewBinding.content.waqfCities.editText as? AutoCompleteTextView)?.isEnabled=false
        loadCitiesDropdown(1)
        loadTypesDropdown()
    }

    private fun sendDataToApi() {
        val waqfName = viewBinding.content.waqfNameEt.text.toString()
        val founderName =viewBinding.content.personNameEt.text.toString()
        val establishmentDate = viewBinding.content.waqfDateEt.text.toString()
        val establishmentDateH = viewBinding.content.waqfDateHEt.text.toString()
        val waqfDescription = viewBinding.content.waqfDescriptionEt.text.toString()

        val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")
        val date = LocalDate.parse(establishmentDate, formatter)
        val isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        val establishmentDateFormated = isoFormatter.format(date.atStartOfDay())

        val dateH = LocalDate.parse(establishmentDateH, formatter)
        val isoFormatterH = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        val establishmentDateFormatedH = isoFormatterH.format(dateH.atStartOfDay())
        waqfRequest.waqfName =waqfName
        waqfRequest.founderName=founderName
        waqfRequest.documentNumber=documentNumber
        waqfRequest.establishmentDate=establishmentDateFormated
        waqfRequest.establishmentDateH=establishmentDateFormatedH
        waqfRequest.waqfDescription=waqfDescription
        waqfRequest.waqfDocument=waqfDocument
        waqfRequest.imageUrl=waqfImage
        waqfRequest.insUserId=insUserId

        ApiManager.getApis().sendWaqfRequest(waqfRequest).enqueue(object : Callback<WaqfRequestResponse> {
            override fun onResponse(
                call: Call<WaqfRequestResponse>,
                response: Response<WaqfRequestResponse>
            ) {
                if (response.isSuccessful) {
                    val res = response.body()
                    Log.e("onResponse: result is ", res.toString())
                } else {
                    val errorCode = response.code()
                    val errorMessage = response.message()

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
                                val activity= waqfActivitiesList.get(position)
                                waqfRequest.waqfActivityId = activity.id
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
                               val country= countriesList.get(position)
                                waqfRequest.waqfCountryId = country.id
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
                                val city= citiesList.get(position)
                                waqfRequest.waqfCityId = city.id
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
                                val type= typesList.get(position)
                                waqfRequest.waqfTypeId = type.id
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




}

