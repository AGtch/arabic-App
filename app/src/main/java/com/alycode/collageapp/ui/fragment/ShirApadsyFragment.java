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
import com.alycode.collageapp.databinding.FragmentShirApadsyBinding;
import com.alycode.collageapp.ui.HandleClickOnBooks;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShirApadsyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShirApadsyFragment extends Fragment implements View.OnClickListener {
    FragmentShirApadsyBinding fragmentShirApadsyBinding;
    IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
    String namePdf;
    String url;

    public ShirApadsyFragment() {
        // Required empty public constructor
    }

    public static ShirApadsyFragment newInstance() {
        ShirApadsyFragment fragment = new ShirApadsyFragment();
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
        fragmentShirApadsyBinding = FragmentShirApadsyBinding.inflate(inflater, container, false);
        return fragmentShirApadsyBinding.getRoot();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shar_abaasy_go_to_doctor_book_id: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%20%D8%A7%D9%84%D8%B9%D8%A8%D8%A7%D8%B3%D9%8A%2F%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%20%D9%81%D9%8A%20%D8%A7%D9%84%D8%B9%D8%B5%D8%B1%20%D8%A7%D9%84%D8%B9%D8%A8%D8%A7%D8%B3%D9%8A%20%D8%A7%D9%84%D8%AC%D8%B2%D8%A1%20%D8%A7%D9%84%D8%A7%D9%88%D9%841.pdf?alt=media&token=2739580c-1a4c-4aa5-9413-d77840e8a884";
                namePdf = "الشعر في العصر العباسي الجزء الاول1.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;

            }
            case R.id.shar_abaasy_go_to_doctor_book2_id: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%20%D8%A7%D9%84%D8%B9%D8%A8%D8%A7%D8%B3%D9%8A%2F%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%20%D9%81%D9%8A%20%D8%A7%D9%84%D8%B9%D8%B5%D8%B1%20%D8%A7%D9%84%D8%B9%D8%A8%D8%A7%D8%B3%D9%8A%20%D8%A7%D9%84%D8%AC%D8%B2%D8%A1%20%D8%A7%D9%84%D8%A7%D9%88%D9%842.pdf?alt=media&token=7ddcfce0-ba40-4af9-a669-7e44c2e18c47";
                namePdf = "الشعر في العصر العباسي الجزء الاول2.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;

            }
            case R.id.shar_abaasy_go_to_student_book_id: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%20%D8%A7%D9%84%D8%B9%D8%A8%D8%A7%D8%B3%D9%8A%2F%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%20%D9%81%D9%8A%20%D8%A7%D9%84%D8%B9%D8%B5%D8%B1%20%D8%A7%D9%84%D8%B9%D8%A8%D8%A7%D8%B3%D9%8A-%D8%AA%D9%84%D8%AE%D9%8A%D8%B5.pdf?alt=media&token=3ee6bbf0-328e-487b-b2ee-017d5aab454d";
                namePdf = "الشعر في العصر العباسي-تلخيص.pdf";
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButtonsOnClickListener();
    }

    private void setButtonsOnClickListener() {
        fragmentShirApadsyBinding.sharAbaasyGoToStudentBookId.setOnClickListener(this);
        fragmentShirApadsyBinding.sharAbaasyGoToDoctorBook2Id.setOnClickListener(this);
        fragmentShirApadsyBinding.sharAbaasyGoToDoctorBookId.setOnClickListener(this);

    }
}