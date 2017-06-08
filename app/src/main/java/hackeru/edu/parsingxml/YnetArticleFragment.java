package hackeru.edu.parsingxml;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


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
        webView.loadUrl(link);
        return v;
    }
}
