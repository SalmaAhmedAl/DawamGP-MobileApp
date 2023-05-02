package com.example.dawam.ui.waqf_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.dawam.R
import com.example.dawam.databinding.ActivityWaqfDetailsBinding
import com.example.dawam.databinding.ActivityWebviewBinding
import com.example.dawam.ui.waqf_details.recycler_view.WaqfDetailsAdapter

class WebviewActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= DataBindingUtil.setContentView(this, R.layout.activity_webview)
        viewBinding.web.webViewClient=WebViewClient()
        viewBinding.web.settings.setSupportZoom(true)
        viewBinding.web.settings.javaScriptEnabled=true
        val pdfUrl =intent.getStringExtra("pdf_url")
            //"http://afdinc-001-site5.itempurl.com//waqfDocuments/0mawlawy.pdf"
            //
        viewBinding.web.loadUrl("https://docs.google.com/gview?embedded=true&url=${pdfUrl}")
    }
}