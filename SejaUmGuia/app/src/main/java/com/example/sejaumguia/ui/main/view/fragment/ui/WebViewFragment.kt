package com.example.sejaumguia.ui.main.view.fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.sejaumguia.R
import com.example.sejaumguia.databinding.WebViewRandomChuckNorrisBinding
import com.example.sejaumguia.ui.main.recyclerView.getDataUrl
import com.example.sejaumguia.ui.main.view.main.MainActivity


private lateinit var webView:WebView
private lateinit var mBinding:WebViewRandomChuckNorrisBinding

class WebViewFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = WebViewRandomChuckNorrisBinding.inflate(layoutInflater,container,false)
        MainActivity.currentFragment ="Fragment_3"

        webView = mBinding.root.findViewById(R.id.webViewDescription)
        val getUrl = getDataUrl.urlGet
        webView.loadUrl(getUrl)

        return mBinding.root
    }

}