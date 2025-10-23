package com.example.responsi1mobileh1d023097.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobileh1d023097.data.model.SearchResponse
import com.example.responsi1mobileh1d023097.data.network.RetrofitInstance
import com.example.responsi1mobileh1d023097.utils.Constants.AUTH_TOKEN
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _teamDetails = MutableLiveData<SearchResponse?>()
    val teamDetails: LiveData<SearchResponse?> = _teamDetails

    fun fetchTeamDetails(teamId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTeamDetails(teamId,AUTH_TOKEN)

                if (response.isSuccessful) {
                    val result = response.body()
                    _teamDetails.value = result
                    Log.d("SUCCESS_GET_DATA", "Data tim berhasil diambil: ${result?.clubName}")
                } else {
                    Log.e("API_ERROR", "${response.code()} ${response.message()}")
                    _teamDetails.value = null
                }
            } catch (e: Exception) {
                Log.e("API_EXCEPTION", "Exception occurred: ${e.localizedMessage}")
                _teamDetails.value = null
            }
        }
    }
}