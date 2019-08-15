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

import java.util.ArrayList;

import ujjwal.anand.globallogic.algorithms.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchingFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText mEnterNumber , mEnterK;
    Button mAddNumbers , mSearchNumber;
    TextView mShowNumbers;
    int mIntegerK;
    ArrayList<Integer> numbers;

    public SearchingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchingFragment newInstance(String param1, String param2) {
        SearchingFragment fragment = new SearchingFragment();
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
        View view = inflater.inflate(R.layout.fragment_searching,container,false);

        initViews(view);

        numbers = new ArrayList<>();

        mAddNumbers.setOnClickListener(this);

        mSearchNumber.setOnClickListener(this);

        return view;
    }

    private void initViews(View view) {

        mEnterNumber = view.findViewById(R.id.enter_number);
        mEnterK = view.findViewById(R.id.enter_k);
        mAddNumbers = view.findViewById(R.id.add_numbers);
        mSearchNumber = view.findViewById(R.id.search_number);
        mShowNumbers = view.findViewById(R.id.numbers);

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

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if(view == mAddNumbers){
            if(!TextUtils.isEmpty(mEnterNumber.getText())){
                numbers.add(Integer.valueOf(mEnterNumber.getText().toString()));
                mEnterNumber.setText(null);
            }else{
                Toast.makeText(getActivity(),"Please Enter a Value",Toast.LENGTH_LONG).show();
            }
        }
        if(view==mSearchNumber){
            if(numbers.isEmpty()){
                mShowNumbers.setText(getResources().getText(R.string.no_number_added));
                Toast.makeText(getActivity(),getResources().getText(R.string.no_number_added),Toast.LENGTH_LONG).show();
            }else if(TextUtils.isEmpty(mEnterK.getText().toString())){
                Toast.makeText(getActivity(),"Enter Search Value",Toast.LENGTH_LONG).show();
            }else{
                mEnterNumber.setText(null);

                mIntegerK = Integer.valueOf(mEnterK.getText().toString());
                int index = numbers.indexOf(mIntegerK);
                if(index !=-1){
                    mShowNumbers.setText("Element found at "+index);
                }else{
                    mShowNumbers.setText("Element not Found");
                }
                mEnterK.setText(null);
                numbers.clear();
            }
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
