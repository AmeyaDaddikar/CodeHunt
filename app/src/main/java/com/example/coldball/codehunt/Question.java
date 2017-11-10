package com.example.coldball.codehunt;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static com.example.coldball.codehunt.MainActivity.PREFS_NAME;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Question.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Question#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String[] PASSWORD = {"0000","2807","0911","2810","0105","7581","5"};
    public static final String[] QUESTION_LIST = {
            "QUESTION 1",
            "QUESTION 2",
            "QUESTION 3",
            "QUESTION 4",
            "The Final Problem"};
    private int CURRENT_LOCATION ;
    int i;
    SharedPreferences settings;
    EditText pass1;
    EditText pass2;
    EditText pass3;
    EditText pass4;
    TextView mQuestionView;
    Button mNextButton;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Question() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question.
     */
    // TODO: Rename and change types and number of parameters
    public static Question newInstance(String param1, String param2) {
        Question fragment = new Question();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_question1, container, false);

        pass1 =  rootView.findViewById(R.id.Digit1);
        pass2 =  rootView.findViewById(R.id.Digit2);
        pass3 =  rootView.findViewById(R.id.Digit3);
        pass4 =  rootView.findViewById(R.id.Digit4);
        i = 0;
        mNextButton = rootView.findViewById(R.id.next_button);
        mQuestionView = rootView.findViewById(R.id.question_text);
        settings = this.getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        CURRENT_LOCATION =settings.getInt("fragment_value",1);
        mQuestionView.setText(QUESTION_LIST[CURRENT_LOCATION - 1]);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = "";
                try {
                    input = pass1.getText().toString() + pass2.getText().toString() + pass3.getText().toString() + pass4.getText().toString();
                    Log.i("QUESTION", input);

                }catch (NullPointerException e){
                    Log.i("QUESTION", "Didnt work obviously");
                }
/*                mQuestionView.setText(QUESTION_LIST[1]);
                fallBackToast(CURRENT_LOCATION,2);
                CURRENT_LOCATION = 2;
*/
                if(input.compareTo(PASSWORD[CURRENT_LOCATION]) == 0){

                    if(CURRENT_LOCATION == 5)
                    {
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        fm.beginTransaction()
                                .remove(Question.this)
                                .commit();
                        fm.beginTransaction()
                                .add(R.id.fragment_frame, new GoodbyeFragment(), "HOMEPAGE")
                                .commit();
                    }
                    else
                        mQuestionView.setText(QUESTION_LIST[CURRENT_LOCATION++]);
                    //fallBackToast(CURRENT_LOCATION,CURRENT_LOCATION);

                }
                else{
                    if (i == 2) {
                        Toast.makeText(getActivity().getApplicationContext(),R.string.excess_message, Toast.LENGTH_SHORT).show();
                    }
                    if (i == 4) {
                        Toast.makeText(getActivity().getApplicationContext(),R.string.excess_message2, Toast.LENGTH_SHORT).show();
                        i = 0;
                    }
                    else{
                        Toast.makeText(getActivity().getApplicationContext(), "Incorrect password!",Toast.LENGTH_SHORT).show();
                    }
                    i++;
                }
                SharedPreferences.Editor editor =settings.edit();
                editor.putInt("fragment_value",CURRENT_LOCATION);
                editor.commit();
                pass1.setText("");
                pass2.setText("");
                pass3.setText("");
                pass4.setText("");
                pass1.requestFocus();
            }
        });

        pass1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO Auto-generated method stub
                if(pass1.getText().toString().length()==1)     //size as per your requirement
                {
                    pass2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        pass2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO Auto-generated method stub
                if(pass2.getText().toString().length()==1)     //size as per your requirement
                {
                    pass3.requestFocus();
                }
                else{
                    pass1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pass3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO Auto-generated method stub
                if(pass3.getText().toString().length()==1)     //size as per your requirement
                {
                    pass4.requestFocus();
                }
                else{
                    pass2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        pass4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(pass4.getText().toString().length()==0){
                    pass3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return rootView;


    }

    void fallBackToast(int ploc, int loc){
        if(ploc>loc)
            Toast.makeText(getActivity().getApplicationContext(),R.string.fallback_message, Toast.LENGTH_SHORT).show();
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
