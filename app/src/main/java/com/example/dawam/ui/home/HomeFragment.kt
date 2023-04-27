package com.example.dawam.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dawam.R
import com.example.dawam.api.ApiManager
import com.example.dawam.api.model.waqfResponse.WaqfResponse
import com.example.dawam.databinding.FragmentHomeBinding
import com.example.dawam.ui.Constants.WAQF_IMAGE_EXTRA
import com.example.dawam.ui.home.recycler_view.Waqf
import com.example.dawam.ui.home.recycler_view.WaqfAdapter
import com.example.dawam.ui.waqf_details.WaqfDetailsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment:Fragment() {
    lateinit var viewModel: HomeViewModel
    lateinit var viewBinding :FragmentHomeBinding
    lateinit var adapter: WaqfAdapter
    var awqaf = listOf(
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,)
    )
    //lateinit var waqfList: MutableList<WaqfResponse>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init viewModel
        viewModel= ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
         viewBinding= FragmentHomeBinding.inflate(inflater,container, false )
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         initRecyclerView()

        //get Awqaf
       ApiManager.getApis().getWaqf().enqueue(object :Callback<ArrayList<WaqfResponse>>{
           override fun onResponse(
               call: Call<ArrayList<WaqfResponse>>,
               response: Response<ArrayList<WaqfResponse>>
           ) {
               Log.e("response", response.body().toString())
               Log.e("response is successful", response.isSuccessful.toString())
           }

           override fun onFailure(call: Call<ArrayList<WaqfResponse>>, t: Throwable) {
               Log.e("error", t.localizedMessage?:"")
           }

       })

    }

    private fun initRecyclerView() {
        adapter = WaqfAdapter(awqaf)
        adapter.onWaqfClick = object : WaqfAdapter.OnWaqfClick {
            override fun onWaqfBtnClick(name: String,  image:Int) {
                //We should start new activity ==> WaqfResponse details
                val intent = Intent(requireActivity(), WaqfDetailsActivity::class.java)
                intent.putExtra(WAQF_IMAGE_EXTRA, image)
                startActivity(intent)
            }
        }
        viewBinding.content.waqfRecycler.adapter=adapter
    }


}


