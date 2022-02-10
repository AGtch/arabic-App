package com.alycode.collageapp.ui.fragment;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alycode.collageapp.FireBaseHandle.FirebaseHandle;
import com.alycode.collageapp.FireBaseHandle.NetworkHandling;
import com.alycode.collageapp.R;
import com.alycode.collageapp.databinding.FragmentAdapMasryBinding;
import com.alycode.collageapp.ui.HandleClickOnBooks;
// 01092926949

public class AdapMasryFragment extends Fragment implements View.OnClickListener {
    IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
    FragmentAdapMasryBinding fragmentAdapMasryBinding;
    String namePdf = null;
    String url = null;

    public AdapMasryFragment() {
        // Required empty public constructor
    }

    public static AdapMasryFragment newInstance() {
        AdapMasryFragment fragment = new AdapMasryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButtonsOnClickListener();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentAdapMasryBinding = FragmentAdapMasryBinding.inflate(inflater, container, false);
        return fragmentAdapMasryBinding.getRoot();
    }

    private void setButtonsOnClickListener() {
        fragmentAdapMasryBinding.adaptGoToDoctorBookId.setOnClickListener(this);
        fragmentAdapMasryBinding.adaptGoToStudentBookId.setOnClickListener(this);
        fragmentAdapMasryBinding.adaptGoToLastExamsBookId.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        requireActivity().registerReceiver(FirebaseHandle.getFirebaseHandleInstance(), filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        requireActivity().unregisterReceiver(FirebaseHandle.getFirebaseHandleInstance());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.adapt_go_to_doctor_book_id: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D8%AF%D8%A8%20%D9%85%D8%B5%D8%B1%20%D8%A7%D9%84%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D9%87%2F%D8%A7%D8%AF%D8%A8%20%D9%85%D8%B5%D8%B1%D9%8A.pdf?alt=media&token=f26ea5ea-426a-4c3f-9dc8-168637159374";
                namePdf = "ادب مصري.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;
            }
            case R.id.adapt_go_to_student_book_id: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D8%AF%D8%A8%20%D9%85%D8%B5%D8%B1%20%D8%A7%D9%84%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D9%87%2F%D8%A7%D9%84%D8%A7%D8%AF%D8%A8%20%D8%A7%D9%84%D9%85%D8%B5%D8%B1%D9%8A%20%D9%85%D9%84%D8%AE%D8%B5.pdf?alt=media&token=34615e41-ad95-46cf-bb82-d21120a3beea";
                namePdf = "الادب المصري ملخص.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;
            }
            case R.id.adapt_go_to_last_exams_book_id: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D8%AF%D8%A8%20%D9%85%D8%B5%D8%B1%20%D8%A7%D9%84%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D9%87%2F%D8%A7%D9%85%D8%AA%D8%AD%D8%A7%D9%86%D8%A7%D8%AA%20%D8%A7%D8%AF%D8%A8%20%D9%85%D8%B5%D8%B1%D9%8A.pdf?alt=media&token=61ded5c8-4ef6-439b-ad6d-e740b9f747ff";
                namePdf = "امتحانات ادب مصري.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;
            }
        }
    }
}