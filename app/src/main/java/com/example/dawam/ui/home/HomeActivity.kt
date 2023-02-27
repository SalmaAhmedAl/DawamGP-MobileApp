package com.example.dawam.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dawam.R
import com.example.dawam.databinding.ActivityHomeBinding
import com.example.dawam.ui.Constants
import com.example.dawam.ui.waqf_details.WaqfDetailsActivity

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    lateinit var adapter: WaqfAdapter
    var awqaf = listOf(
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        ),
        Waqf(
            name = "جامعة القاهرة",
            "أكتوبر سنة 1906م",
            "شعبان 1324 هجريًا",
            R.drawable.cairo_college
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = WaqfAdapter(awqaf)
        adapter.onWaqfClick = object : WaqfAdapter.OnWaqfClick {
            override fun onWaqfBtnClick(name: String, position: Int, image:Int) {
                //We should start new activity ==> Waqf details
                val intent = Intent(this@HomeActivity, WaqfDetailsActivity::class.java)
                intent.putExtra(Constants.WAQF_NAME_EXTRA, name)
                intent.putExtra(Constants.WAQF_IMAGE_EXTRA, image)
                startActivity(intent)
            }

        }

        viewBinding.waqfRecycler.adapter=adapter
    }

}