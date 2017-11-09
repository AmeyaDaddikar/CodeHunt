package com.example.coldball.codehunt;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static com.example.coldball.codehunt.MainActivity.CURRENT_LOCATION;
import static com.example.coldball.codehunt.MainActivity.PREFS_NAME;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainPage.OnFragmentInteractionListener} interface
 * to handle interaction events.
 *
 */
public class MainPage extends Fragment implements  View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    
    private static int counter = 5;
    public Button start_button;
    SharedPreferences settings;

    private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = this.getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        start_button = (Button) view.findViewById(R.id.start_button);
        start_button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(counter > 0)
            Toast.makeText(getContext(),
                    "You are " + String.valueOf(counter--) + " steps away from starting codehunt",
                    Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(getContext(), "LET THE GAMES BEGIN!!!!",
                    Toast.LENGTH_SHORT).show();
            //SWITCH FRAGMENT IN MAIN ACTIVITY HERE

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("fragment_value", 1);
            editor.commit();

            FragmentManager fragmentManager = this.getActivity().getSupportFragmentManager();
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_frame);
            fragmentManager.beginTransaction().remove(this).commit();
            fragment = new Question1();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_frame,fragment,"HOMEPAGE")
                    .commit();

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
