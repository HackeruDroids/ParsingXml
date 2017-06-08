package hackeru.edu.parsingxml;


import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class YnetArticleFragment extends Fragment {
    WebView webView;

    public static YnetArticleFragment newInstance(String link) {
        Bundle args = new Bundle();
        args.putString("link", link);
        YnetArticleFragment fragment = new YnetArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String link = getArguments().getString("link");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ynet_article, container, false);
        webView = (WebView) v.findViewById(R.id.webView);

        config(webView);

        webView.loadUrl(link);
        return v;
    }

    private void config(final WebView webView) {
        //Enable JavaScript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){

             @SuppressWarnings("deprecation")
             @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.animate().rotation(0);
                webView.setBackgroundColor(0xfff);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                webView.animate().rotation(360);
                super.onPageStarted(view, url, favicon);
                webView.setBackgroundColor(0x0f0);
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                webView.loadUrl(url);
                return true;
            }
        });
    }
}
