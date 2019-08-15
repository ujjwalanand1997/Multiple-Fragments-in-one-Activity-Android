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
import java.util.Collections;

import ujjwal.anand.globallogic.algorithms.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SortFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SortFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SortFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText mEnterNumber;
    Button mAddNumbers , mSortNumbers;
    TextView mShowNumbers;
    ArrayList<Integer> numbers;

    public SortFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SortFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SortFragment newInstance(String param1, String param2) {
        SortFragment fragment = new SortFragment();
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

        View view = inflater.inflate(R.layout.fragment_sort,container,false);

        initViews(view);

        numbers = new ArrayList<>();

        mAddNumbers.setOnClickListener(this);

        mSortNumbers.setOnClickListener(this);

        return view;
    }


    private void initViews(View container) {

        mEnterNumber = container.findViewById(R.id.enter_number);
        mAddNumbers = container.findViewById(R.id.add_numbers);
        mSortNumbers = container.findViewById(R.id.sort_numbers);
        mShowNumbers = container.findViewById(R.id.numbers);

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
        if(view==mSortNumbers){
            if(numbers.isEmpty()){
                mShowNumbers.setText("0 numbers added");
                Toast.makeText(getActivity(),"0 numbers added",Toast.LENGTH_LONG).show();
            }else {
                mEnterNumber.setText(null);
                Collections.sort(numbers);
                String strRes = numbers.toString();
                mShowNumbers.setText(strRes.substring(1, strRes.length() - 1));
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
