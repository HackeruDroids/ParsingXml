package hackeru.edu.parsingxml;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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




    static class YnetAdapter {

        class YnetViewHolder extends RecyclerView.ViewHolder{
            TextView tvTitle;
            TextView tvDescription;
            ImageView ivThumbnail;
            public YnetViewHolder(View itemView) {
                super(itemView);
                tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
                tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
                ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
            }
        }
    }
}
