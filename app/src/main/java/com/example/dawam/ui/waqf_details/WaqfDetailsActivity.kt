package com.example.dawam.ui.waqf_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dawam.R
import com.example.dawam.databinding.ActivityWaqfDetailsBinding
import com.example.dawam.ui.Constants.WAQF_IMAGE_EXTRA
import com.example.dawam.ui.waqf_details.recycler_view.LineItem
import com.example.dawam.ui.waqf_details.recycler_view.WaqfDetailsAdapter

class WaqfDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityWaqfDetailsBinding
    val items = listOf(
        LineItem("اسم الوقف:", "جامعة القاهرة"),
        LineItem("اسم الواقف:", "الأميرة فاطمة إسماعيل"),
        LineItem("تاريخ الوقف هجريًا:","شعبان 1324 هجريًا"),
        LineItem("تاريخ الوقف ميلاديًا:", "أكتوبر سنة 1906م"),
        LineItem("نوع الوقف:", "خيري"),
        LineItem("تصنيف الوقف:", "جامعة"),
        LineItem("ريع الوقف:","مصر- مدينة الجيزة غرب القاهرة"),
        LineItem("وصف الوقف:","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.")
        )


    lateinit var adapter: WaqfDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityWaqfDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //intent
        val waqfImage = intent.getIntExtra(WAQF_IMAGE_EXTRA, R.drawable.cairo_college)
        viewBinding.content.image.setImageResource(waqfImage)


        initListeners()

        initRecyclerView()

    }

    private fun initRecyclerView() {
        adapter= WaqfDetailsAdapter(items)

         viewBinding.content.recyclerView.adapter=adapter
    }





    private fun initListeners() {
        with(viewBinding) {
            backBtn.setOnClickListener{
                finish()
            }
        }
    }
}