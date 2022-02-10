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
import com.alycode.collageapp.databinding.FragmentNazaretElAdapBinding;
import com.alycode.collageapp.ui.HandleClickOnBooks;
import com.alycode.collageapp.ui.OpenLinks;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NazaretElAdapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NazaretElAdapFragment extends Fragment implements View.OnClickListener {
    FragmentNazaretElAdapBinding fragmentNazaretElAdapBinding;
    IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
    String url;
    String namePdf;

    public NazaretElAdapFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NazaretElAdapFragment newInstance() {
        NazaretElAdapFragment fragment = new NazaretElAdapFragment();
        Bundle args = new Bundle();
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
        fragmentNazaretElAdapBinding = FragmentNazaretElAdapBinding.inflate(inflater, container, false);
        return fragmentNazaretElAdapBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButtonsOnClickListener();
    }

    private void setButtonsOnClickListener() {
        fragmentNazaretElAdapBinding.nazertElAdapGoToDoctorBook.setOnClickListener(this);
        fragmentNazaretElAdapBinding.nazertElAdapGoToLastExamsBook.setOnClickListener(this);
        fragmentNazaretElAdapBinding.nazertElAdapGoToStudentBook.setOnClickListener(this);
        fragmentNazaretElAdapBinding.nazertElAdapLec1.setOnClickListener(this);
        fragmentNazaretElAdapBinding.nazertElAdapLec2.setOnClickListener(this);
        fragmentNazaretElAdapBinding.nazertElAdapLec3.setOnClickListener(this);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nazertElAdap_go_to_doctor_book: {
                // url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%B9%D9%84%D9%85%20%D8%A7%D9%84%D9%85%D8%B9%D8%A7%D9%86%D9%8A%2F%D8%B9%D9%84%D9%85%20%D8%A7%D9%84%D9%85%D8%B9%D8%A7%D9%86%D9%8A%20%D8%A7%D9%84%D9%81%D8%B1%D9%82%D9%87%20%D8%A7%D9%84%D8%AB%D8%A7%D9%84%D8%AB%D9%87.pdf?alt=media&token=b3320db2-3962-4128-bf28-5f85a39e8f72";
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D9%86%D8%B8%D8%B1%D9%8A%D9%87%20%D8%A7%D9%84%D8%A7%D8%AF%D8%A8%2F%D9%85%D9%82%D8%B1%D8%B1%20%D9%86%D8%B8%D8%B1%D9%8A%D8%A9%20%D8%A7%D9%84%D8%A3%D8%AF%D8%A8%20-%20%D8%AF%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%B9%D8%A8%D8%AF%D8%A7%D9%84%D8%B9%D8%A7%D9%84.pdf?alt=media&token=a7691c4b-cfd7-4ceb-a8a7-66aa9611a4e1";
                namePdf = "نظريه الادب الفرقه الثالثه.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;

            }
            case R.id.nazertElAdap_go_to_student_book: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D9%86%D8%B8%D8%B1%D9%8A%D9%87%20%D8%A7%D9%84%D8%A7%D8%AF%D8%A8%2F%D9%86%D8%B8%D8%B1%D9%8A%D8%A9%20%D8%A7%D9%84%D8%A3%D8%AF%D8%A8%20-%20%D9%85%D9%8F%D8%B1%D8%A7%D8%AC%D8%B9.pdf?alt=media&token=51a2c80d-2d56-4fd1-8180-da5e18b9d5f1";
                namePdf = "نظريه الادب الفرقه الثالثه-ملخص.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;

            }
            case R.id.nazertElAdap_go_to_lastExams_book: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D9%86%D8%B8%D8%B1%D9%8A%D9%87%20%D8%A7%D9%84%D8%A7%D8%AF%D8%A8%2F%D8%A7%D9%85%D8%AA%D8%AD%D8%A7%D9%86%D8%A7%D8%AA%20%D8%A7%D9%84%D8%B3%D9%86%D9%8A%D9%86%20%D8%A7%D9%84%D8%B3%D8%A7%D8%A8%D9%82%D9%87.pdf?alt=media&token=aa94c8cd-46a1-42eb-88f6-9e1725a2e75e";
                namePdf = "امتحانات السنين السابقه نظريه الادب.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;

            }
            case R.id.nazertElAdap_lec1: {
                url = "https://drive.google.com/file/d/1IqgYoZ1aY74F5lcMOo8iqA575AczXGUA/view";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);

                break;
            }
            case R.id.nazertElAdap_lec2: {
                url = "https://artmenofiaedu-my.sharepoint.com/:p:/g/personal/mohamed_abdelaal_art_menofia_edu_eg/ETUDIavAlXRNkDHOktPemSMB43TxB9UdCynUP2dEIUsLnA?rtime=XUwnS9Xm2Ug";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);

                break;
            }
            case R.id.nazertElAdap_lec3: {
                url = "https://drive.google.com/file/d/1JPi_BpooyDI7MBbj5AMcaXVTr0BOmyDE/view";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);

                break;
            }
        }
        namePdf = null;
        url = null;
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
}