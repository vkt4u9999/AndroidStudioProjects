package com.vkt4u9999.tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.vkt4u9999.tabs.Model.SliderItem
import com.vkt4u9999.tabs.Utils.SliderAdapter
import com.vkt4u9999.tabs.databinding.ActivityImageSliderBinding
import java.lang.Math.abs

class ImageSliderActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityImageSliderBinding

    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityImageSliderBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        viewPager= mBinding.viewPagerImageSlider

        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.image_1))
        sliderItems.add(SliderItem(R.drawable.image_2))
        sliderItems.add(SliderItem(R.drawable.image_3))

        viewPager.adapter= SliderAdapter(sliderItems, viewPager)

        viewPager.clipToPadding= false
        viewPager.clipChildren= false
        viewPager.offscreenPageLimit= 3
        viewPager.getChildAt(0).overScrollMode= RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer= CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer{
            page, position -> val r = 1 - abs(position)
            page.scaleY= 0.85f + r * 0.25f
        }

        viewPager.setPageTransformer(compositePageTransformer)


    }
}