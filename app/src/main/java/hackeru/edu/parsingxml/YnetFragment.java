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
public class YnetFragment extends Fragment implements YnetDataSource.OnYnetArrivedListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_ynet, container, false);

        YnetDataSource.getYnet(this);

        return v;
    }

    @Override
    public void onYnetArrived(List<YnetDataSource.Ynet> data) {
        Toast.makeText(getActivity(), data.toString(), Toast.LENGTH_SHORT).show();
    }


}
