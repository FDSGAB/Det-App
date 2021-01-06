package co.det.det.home

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private val url = "10.0.2.2:5000"
private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(url)
        .build()
interface DETApiService {
    @GET("Det")
    fun getProperties():
            Call<String>
}
object DETApi{
    val retrofitService : DETApiService by lazy {
        retrofit.create(DETApiService::class.java) }
}