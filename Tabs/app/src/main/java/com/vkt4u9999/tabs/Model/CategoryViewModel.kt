package com.vkt4u9999.tabs.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel: ViewModel() {



    var categoryList : MutableLiveData<List<Category>> = MutableLiveData()

    //инициализируем список и заполняем его данными пользователей
    init {
        categoryList.value = CategoryData.getCategoryData()
    }

    fun getListCategory() = categoryList

}