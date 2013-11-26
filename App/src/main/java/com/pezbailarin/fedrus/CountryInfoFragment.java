package com.pezbailarin.fedrus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by cesar on 26/11/13.
 */
public class CountryInfoFragment extends Fragment {
    WebView webView;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_info, container, false);
        webView = (WebView)view.findViewById(R.id.webView);
        webView.loadData("selecciona un país", "text/plain", "utf-8");
        return view;
    }


    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof CountryDetailActivity) {
            String country = ((CountryDetailActivity)getActivity()).getCountry();
            loadWebViewContent(country);
        }
    }


    /**
    * Cargar wikipedia en el webView
    */
    public void loadWebViewContent(String country) {
        webView.loadUrl("http://es.m.wikipedia.org/wiki/" + country);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}