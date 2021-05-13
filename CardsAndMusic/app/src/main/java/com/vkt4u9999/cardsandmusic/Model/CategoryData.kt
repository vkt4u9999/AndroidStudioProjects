package com.vkt4u9999.cardsandmusic.Model

import com.vkt4u9999.cardsandmusic.R

object CategoryData {

    fun getCategoryData()= listOf(
        Category("Домашние животные", R.drawable.home_pets ),
        Category("Дикие животные", R.drawable.wild_animals ),
        Category("Домашние птицы", R.drawable.home_birds ),
        Category("Дикие птицы", R.drawable.wild_birds ),
        Category("Насекомые", R.drawable.insects ),
        Category("Дом и техника", R.drawable.tech ),
        Category("Транспорт", R.drawable.cars ),
        Category("Музыкальные инструменты", R.drawable.music_instruments ),
        Category("Эмоции", R.drawable.emotions ),
        Category("Звуки природы", R.drawable.nature ),
        Category("Детские песни", R.drawable.songs )

    )
}