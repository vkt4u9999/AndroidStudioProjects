package com.vkt4u9999.tabs.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongViewModel: ViewModel() {



    var songList : MutableLiveData<List<Song>> = MutableLiveData()

    //инициализируем список и заполняем его данными
    init {
        songList.value = SongData.getSongData()
    }

    fun getListSong() = songList

}
