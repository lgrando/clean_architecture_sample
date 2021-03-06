package com.example.architecture.core.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT: Long = 60

fun <T> getApi(serviceClass: Class<T>): T {

	val client = OkHttpClient.Builder()
	client.readTimeout(TIMEOUT, TimeUnit.SECONDS)
	client.connectTimeout(TIMEOUT, TimeUnit.SECONDS)

	val gson = GsonBuilder()
		.setLenient()
		.create()

	val retrofit = Retrofit.Builder()
		.baseUrl("http://10.0.2.2:3001/")
		.client(client.build())
		.addConverterFactory(GsonConverterFactory.create(gson))

	return retrofit.build().create(serviceClass)
}