package ujjwal.anand.globallogic.algorithms.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ujjwal.anand.globallogic.algorithms.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ArmstrongFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ArmstrongFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArmstrongFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText mEnterNumber;
    Button mCheck;
    TextView mShowResult;

    public ArmstrongFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArmstrongFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArmstrongFragment newInstance(String param1, String param2) {
        ArmstrongFragment fragment = new ArmstrongFragment();
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
        View view = inflater.inflate(R.layout.fragment_armstrong,container,false);

        initViews(view);

        mCheck.setOnClickListener(this);

        return view;
    }

    private void initViews(View view) {
        mEnterNumber = view.findViewById(R.id.enter_number);
        mCheck = view.findViewById(R.id.find_armstrong);
        mShowResult = view.findViewById(R.id.numbers);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if(view==mCheck){
            if(!TextUtils.isEmpty(mEnterNumber.getText())){

                if(checkArmstrong(Integer.valueOf(mEnterNumber.getText().toString()))){
                    mShowResult.setText("It's Armstrong");
                }else {
                    mShowResult.setText("It's not Armstrong");
                }

                mEnterNumber.setText(null);
            }else{
                Toast.makeText(getActivity(),"Please Enter a Value",Toast.LENGTH_LONG).show();
            }
        }
    }

    public boolean checkArmstrong(Integer integer){
        int cube=0,a,temp;

        temp=integer;
        while(integer>0)
        {
            a=integer%10;
            integer=integer/10;
            cube=cube+(a*a*a);
        }
        if(temp==cube){
            return true;
        }else {
            return false;
        }
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
