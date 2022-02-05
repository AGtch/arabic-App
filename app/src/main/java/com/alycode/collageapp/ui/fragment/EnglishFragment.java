package com.alycode.collageapp.ui.fragment;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alycode.collageapp.FireBaseHandle.FirebaseHandle;
import com.alycode.collageapp.R;
import com.alycode.collageapp.databinding.FragmentEnglishBinding;
import com.alycode.collageapp.ui.HandleClickOnBooks;
import com.alycode.collageapp.ui.OpenLinks;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EnglishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnglishFragment extends Fragment implements View.OnClickListener {
    IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
    FragmentEnglishBinding fragmentEnglishBinding;


    public EnglishFragment() {
        // Required empty public constructor
    }

    public static EnglishFragment newInstance() {
        EnglishFragment fragment = new EnglishFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentEnglishBinding.englishGoToDoctorBookId.setOnClickListener(this);
        fragmentEnglishBinding.englishGoToStudentBookId.setOnClickListener(this);
        fragmentEnglishBinding.englishGoToStudentBook2Id.setOnClickListener(this);
        fragmentEnglishBinding.englishGoToLastExamId.setOnClickListener(this);
        fragmentEnglishBinding.englishLec1Id.setOnClickListener(this);
        fragmentEnglishBinding.englishLec2Id.setOnClickListener(this);
        fragmentEnglishBinding.englishLec30Id.setOnClickListener(this);
        fragmentEnglishBinding.englishLec31Id.setOnClickListener(this);
        fragmentEnglishBinding.englishQuiz1Id.setOnClickListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentEnglishBinding = FragmentEnglishBinding.inflate(inflater, container, false);
        return fragmentEnglishBinding.getRoot();
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

    String url;
    String namePdf;

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.english_go_to_doctor_book_id: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D9%84%D8%A7%D9%86%D8%AC%D9%84%D9%8A%D8%B2%D9%8A%2FEnglish_for_Academic.pdf?alt=media&token=32170135-a213-42f3-b544-aab7177c8401";
                namePdf = "english book.pdf";
                HandleClickOnBooks.getHandleClickOnBooksInstance().
                        buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                break;
            }
            case R.id.english_go_to_student_book2_id:{
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D9%84%D8%A7%D9%86%D8%AC%D9%84%D9%8A%D8%B2%D9%8A%2Fenglish%202.pdf?alt=media&token=472a7c2a-b06d-4258-94db-9be09b245ece";
                namePdf ="english 2.pdf";
                HandleClickOnBooks.getHandleClickOnBooksInstance().
                        buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                break;
            }
            case R.id.english_go_to_student_book_id:{
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D8%A7%D9%84%D8%A7%D9%86%D8%AC%D9%84%D9%8A%D8%B2%D9%8A%2FEnglish.pdf?alt=media&token=ce49cda1-1df2-44e1-9f5f-22767225e711";
                namePdf ="English.pdf";
                HandleClickOnBooks.getHandleClickOnBooksInstance().
                        buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                break;
            }
            case R.id.english_go_to_lastExam_id:{
                Toast.makeText(requireActivity(), "سوف يتم اضافته حين توفره", Toast.LENGTH_SHORT).show();
                break;
            } case R.id.english_lec1_id:{
                url = "https://onedrive.live.com/view.aspx?resid=2603DEFBDEDCE6C3!1089&ithint=file%2cpptx&authkey=!AJpEzK1_XdfZjzg";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;

            } case R.id.english_lec2_id:{
                url = "https://onedrive.live.com/view.aspx?resid=2603DEFBDEDCE6C3!1093&ithint=file%2cpptx&authkey=!ANZezQ6vae8EWYs";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            } case R.id.english_quiz1_id:{
                url = "https://forms.office.com/Pages/ResponsePage.aspx?id=DQSIkWdsW0yxEjajBLZtrQAAAAAAAAAAAANAAR2kqMlUNU9MOTRNU1U2M0hXV1JSNzIzUEtQTkJMNi4u";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            } case R.id.english_lec3_0_id:{
                url = "https://youtu.be/lxnbZDJAuIw";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            } case R.id.english_lec3_1_id:{
                url = "https://youtu.be/gU0V4Y5BMFs";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            }case R.id.english_lec3_2_id: {
                url = "https://youtu.be/Yo5ztWpEApw";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            }
        }
    }
}