package hackeru.edu.parsingxml;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyFragment extends Fragment implements CurrencyDataSource.OnCurrenciesArrivedListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_currency, container, false);
        //v.findViewById

        CurrencyDataSource.getCurrencies(this);

        return v;
    }

    @Override
    public void onCurrenciesArrived(List<CurrencyDataSource.Currency> currencies) {
        if (currencies != null) {
            Toast.makeText(getActivity(), currencies.toString(), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getActivity(), "Error connecting to server", Toast.LENGTH_SHORT).show();
        }
    }
}
