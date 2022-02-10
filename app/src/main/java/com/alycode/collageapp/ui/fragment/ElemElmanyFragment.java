package com.alycode.collageapp.ui.fragment;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alycode.collageapp.FireBaseHandle.FirebaseHandle;
import com.alycode.collageapp.R;
import com.alycode.collageapp.databinding.FragmentElemElmanyBinding;
import com.alycode.collageapp.ui.HandleClickOnBooks;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ElemElmanyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElemElmanyFragment extends Fragment implements View.OnClickListener {
    FragmentElemElmanyBinding fragmentElemElmanyBinding;
    IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
    String url = null;
    String namePdf = null;

    public ElemElmanyFragment() {
        // Required empty public constructor
    }

    public static ElemElmanyFragment newInstance() {
        ElemElmanyFragment fragment = new ElemElmanyFragment();
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
        fragmentElemElmanyBinding = FragmentElemElmanyBinding.inflate(inflater, container, false);
        return fragmentElemElmanyBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButtonsOnClickListener();
    }

    private void setButtonsOnClickListener() {
        fragmentElemElmanyBinding.elemElmanyGoToDoctorBook.setOnClickListener(this);
        fragmentElemElmanyBinding.elemElmanyGoToStudentBook.setOnClickListener(this);
        fragmentElemElmanyBinding.elemElmanyGoToLastExamsBook.setOnClickListener(this);
        fragmentElemElmanyBinding.elemElmanyLecs.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.elem_elmany_go_to_doctor_book: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D9%86%D8%AD%D9%88%2F%D9%86%D8%AD%D9%88%20%D9%88%D8%B5%D8%B1%D9%81%20%D8%A7%D9%84%D9%81%D8%B1%D9%82%D9%87%20%D8%A7%D9%84%D8%AB%D8%A7%D9%84%D8%AB%D9%87.pdf?alt=media&token=da499286-1483-44a7-b6c8-af5fe38a052f";
                namePdf = "علم المعاني الفرقه الثالثه.pdf";
                HandleClickOnBooks.getHandleClickOnBooksInstance().
                        buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                break;
            }
            case R.id.nazertElAdap_go_to_student_book: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%B9%D9%84%D9%85%20%D8%A7%D9%84%D9%85%D8%B9%D8%A7%D9%86%D9%8A%2F%D8%B9%D9%84%D9%85%20%D8%A7%D9%84%D9%85%D8%B9%D8%A7%D9%86%D9%8A(%20%D8%A7%D8%AE%D8%B1%20%D9%83%D9%84%D8%A7%D9%85).pdf?alt=media&token=e590bc9a-0378-47c3-847e-07c3a0b4cd14";
                namePdf = "علم المعاني الفرقه الثالثه.pdf";
                HandleClickOnBooks.getHandleClickOnBooksInstance().
                        buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                break;
            }
            case R.id.elem_elmany_go_to_lastExams_book: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%B9%D9%84%D9%85%20%D8%A7%D9%84%D9%85%D8%B9%D8%A7%D9%86%D9%8A%2F%D8%A7%D9%85%D8%AA%D8%AD%D8%A7%D9%86%D8%A7%D8%AA%20%D8%A7%D9%84%D8%B3%D9%86%D9%8A%D9%86%20%D8%A7%D9%84%D8%B3%D8%A7%D8%A8%D9%82%D9%87%20%D8%B9%D9%84%D9%85%20%D8%A7%D9%84%D9%85%D8%B9%D8%A7%D9%86%D9%8A.pdf?alt=media&token=867a50b8-5b3a-408e-b7dc-32187513e09f";
                namePdf = "امتحانات السنين السابقه علم المعاني.pdf";
                HandleClickOnBooks.getHandleClickOnBooksInstance().
                        buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                break;
            }
            case R.id.elem_elmany_lecs: {
//          مدخل إلى نظرية الأدب
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1kKsjZ6k1MRZSFUFJxJhqDTkXKPPg-Jc3?usp=sharing"));
                startActivity(intent);
                break;
            }
        }
    }
    //  مدخل إلى نظرية الأدب
    //                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1kKsjZ6k1MRZSFUFJxJhqDTkXKPPg-Jc3?usp=sharing"));
    //                startActivity(intent);

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