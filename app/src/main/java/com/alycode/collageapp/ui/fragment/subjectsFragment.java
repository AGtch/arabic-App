package com.alycode.collageapp.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alycode.collageapp.R;
import com.alycode.collageapp.databinding.FragmentSubjectsBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link subjectsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class subjectsFragment extends Fragment implements View.OnClickListener, ReplaceFragments {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FragmentSubjectsBinding fragmentSubjectsBinding;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public subjectsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment subjectsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static subjectsFragment newInstance() {
        subjectsFragment fragment = new subjectsFragment();
        Bundle args = new Bundle();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentSubjectsBinding = FragmentSubjectsBinding.inflate(inflater, container, false);
        return fragmentSubjectsBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentSubjectsBinding.btnNahw3Id.setOnClickListener(this);
        fragmentSubjectsBinding.btnNazaretAdap3Id.setOnClickListener(this);
        fragmentSubjectsBinding.btnElmaaneId.setOnClickListener(this);
        fragmentSubjectsBinding.btnEnglish3Id.setOnClickListener(this);
        fragmentSubjectsBinding.btnAdabId.setOnClickListener(this);
        fragmentSubjectsBinding.btnSharId.setOnClickListener(this);
        fragmentSubjectsBinding.btnEnglish3Id.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_nahw3_id: {
                replaceFragment(Nahw3Fragment.newInstance());
                break;
            }
            case R.id.btn_nazaret_adap3_id: {
                replaceFragment(NazaretElAdapFragment.newInstance());
                break;
            }
            case R.id.btn_elmaane_id: {
                replaceFragment(ElemElmanyFragment.newInstance());
                break;
            }
            case R.id.btn_adab_id: {
                replaceFragment(AdapMasryFragment.newInstance());
                break;
            }
            case R.id.btn_shar_id: {
                replaceFragment(ShirApadsyFragment.newInstance());
                break;
            }
            case R.id.btn_english3_id: {
                replaceFragment(EnglishFragment.newInstance());
                break;
            }

        }
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        // Replace whatever is in the fragment_container view with this fragment
        transaction.replace(R.id.fragment_container_view, fragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}