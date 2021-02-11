package com.androiddevs.shoppinglisttestingyt.repositories


import androidx.lifecycle.LiveData
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItem
import com.androiddevs.shoppinglisttestingyt.data.remote.responses.ImageResponse
import com.androiddevs.shoppinglisttestingyt.other.Resource
import retrofit2.Response
import retrofit2.http.Query

interface ShoppingRepository {

    suspend fun  insertShoppingItem(shoppingItem : ShoppingItem)

    suspend fun  deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItem() : LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun  seachForImage(imageQuery: String): Resource<ImageResponse>
}