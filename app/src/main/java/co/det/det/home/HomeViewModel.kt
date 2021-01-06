package co.det.det.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()

    val text: LiveData<String>
        get() = _text

    init {
        getDETProperties()
    }

    private fun getDETProperties() {
        _text.value = DETApi.retrofitService.getProperties().enqueue(
            object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    _text.value = response.body()
                }
                override fun onFailure(call: Call<String>, t: Throwable) {
                    _text.value = "Erro: " + t.message
                }
            }).toString()
    }
}