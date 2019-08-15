package ujjwal.anand.globallogic.algorithms.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ujjwal.anand.globallogic.algorithms.ui.fragments.ArmstrongFragment;
import ujjwal.anand.globallogic.algorithms.R;
import ujjwal.anand.globallogic.algorithms.ui.fragments.SearchingFragment;
import ujjwal.anand.globallogic.algorithms.ui.fragments.SortFragment;

public class AlgoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] mTasks = {"Sorting","Searching","Armstrong"};
    Spinner mTaskSpinner;
    ArrayAdapter mArrayAdapter;
    SortFragment mSortFragment;
    ArmstrongFragment mArmstrongFragment;
    SearchingFragment mSearchingFragment;
    FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo);

        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();

        initViews();

        mTaskSpinner.setOnItemSelectedListener(this);

        mArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mTasks);
        mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mTaskSpinner.setAdapter(mArrayAdapter);

    }

    private void initViews() {
        mTaskSpinner = findViewById(R.id.action_spinner);
        mFragmentManager = getSupportFragmentManager();

        mSortFragment = new SortFragment();
        mArmstrongFragment = new ArmstrongFragment();
        mSearchingFragment = new SearchingFragment();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(i==0){
            mFragmentManager.beginTransaction().setCustomAnimations(R.anim.transition_left,R.anim.transition_out_right).replace(R.id.load_item_layout,mSortFragment,mSortFragment.getTag()).commit();
        }else if(i==1){
            mFragmentManager.beginTransaction().setCustomAnimations(R.anim.transition_left,R.anim.transition_out_right).replace(R.id.load_item_layout,mSearchingFragment,mSearchingFragment.getTag()).commit();
        }else {
            mFragmentManager.beginTransaction().setCustomAnimations(R.anim.transition_left,R.anim.transition_out_right).replace(R.id.load_item_layout,mArmstrongFragment,mArmstrongFragment.getTag()).commit();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

