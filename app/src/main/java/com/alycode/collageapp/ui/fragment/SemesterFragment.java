package com.alycode.collageapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alycode.collageapp.R;
import com.alycode.collageapp.databinding.FragmentSemesterBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SemesterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SemesterFragment extends Fragment implements ReplaceFragments {

    FragmentSemesterBinding fragmentSemesterBinding;

    public SemesterFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SemesterFragment newInstance(String param1, String param2) {
        SemesterFragment fragment = new SemesterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSemesterBinding = FragmentSemesterBinding.inflate(inflater, container, false);
        return fragmentSemesterBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentSemesterBinding.btnFirstSemesterId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(subjectsFragment.newInstance());
            }
        });
        fragmentSemesterBinding.btnSecSemesterId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireActivity().getBaseContext(), "سوف نضيف الملفات لاحقا", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentSemesterBinding = null;
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        // Create new fragment and transaction
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
// Replace whatever is in the fragment_container view with this fragment
        transaction.replace(R.id.fragment_container_view, fragment);
        transaction.addToBackStack(null);
// Commit the transaction
        transaction.commit();
    }
}