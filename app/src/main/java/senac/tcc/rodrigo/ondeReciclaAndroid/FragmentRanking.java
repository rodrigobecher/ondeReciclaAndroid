package senac.tcc.rodrigo.ondeReciclaAndroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import senac.tcc.rodrigo.onderecicla.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRanking extends Fragment {


    public FragmentRanking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_ranking2, container, false);

    }

}
