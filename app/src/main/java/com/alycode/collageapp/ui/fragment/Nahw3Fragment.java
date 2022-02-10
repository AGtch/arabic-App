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
import com.alycode.collageapp.FireBaseHandle.NetworkHandling;
import com.alycode.collageapp.R;
import com.alycode.collageapp.databinding.FragmentNahw3Binding;
import com.alycode.collageapp.ui.HandleClickOnBooks;
import com.alycode.collageapp.ui.OpenLinks;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Nahw3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Nahw3Fragment extends Fragment implements View.OnClickListener {

    FragmentNahw3Binding fragmentNahw3Binding;
    IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
    String url;
    String namePdf;

    public Nahw3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Nahw3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Nahw3Fragment newInstance() {
        Nahw3Fragment fragment = new Nahw3Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentNahw3Binding = FragmentNahw3Binding.inflate(inflater, container, false);
        return fragmentNahw3Binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButtonsOnClickListener();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nahw3_go_to_doctor_book: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D9%86%D8%AD%D9%88%2F%D9%86%D8%AD%D9%88%20%D9%88%D8%B5%D8%B1%D9%81%20%D8%A7%D9%84%D9%81%D8%B1%D9%82%D9%87%20%D8%A7%D9%84%D8%AB%D8%A7%D9%84%D8%AB%D9%87.pdf?alt=media&token=da499286-1483-44a7-b6c8-af5fe38a052f";
                namePdf = "نحو وصرف الفرقه الثالثه.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;
            }
            case R.id.nahw3_go_to_student_book: {
                Toast.makeText(requireActivity(), "لا يوجد شى متعلق بهذا الجزء سوف نضيف ان توفر لنا", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nahw3_go_to_alfetAbnMalk1_book: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D9%86%D8%AD%D9%88%2F%D8%A7%D9%84%D9%81%D9%8A%D9%87%20%D8%A7%D8%A8%D9%86%20%D9%85%D8%A7%D9%84%D9%83%20%D9%85%D9%86%20%D8%A7%D9%84%D8%A8%D9%8A%D8%AA-33-109.pdf?alt=media&token=084c3df5-9797-4c53-8833-4e2a2fa4612a";
                namePdf = "الفيه ابن مالك من البيت-33-109.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;
            }
            case R.id.nahw3_go_to_lastExams_book: {
                url = "https://firebasestorage.googleapis.com/v0/b/arabic-data-pdf.appspot.com/o/%D9%86%D8%AD%D9%88%2F%D8%A7%D9%85%D8%AA%D8%AD%D8%A7%D9%86%D8%A7%D8%AA%20%D8%A7%D9%84%D9%86%D8%AD%D9%88%20%D8%A7%D9%84%D8%B3%D8%A7%D8%A8%D9%82%D9%87.pdf?alt=media&token=a8d01c77-6a68-400b-92b8-74a1697c1add";

                namePdf = "امتحانات النحو السابقه.pdf";
                if (NetworkHandling.getNetworkHandling().checkConnection(requireContext())) {
                    HandleClickOnBooks.getHandleClickOnBooksInstance().
                            buttonClickedToDownloadOrOpenPdf(requireActivity().getBaseContext(), namePdf, url);
                } else {
                    MassageDialog.getMassageDialog().showErrorMassage();
                }
                break;
            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk1_book: {
                url = "https://youtu.be/4ZJT_8KWc-g";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk2_book: {
                url = "https://drive.google.com/drive/folders/1cdUmFE07hYse77G-ABxDv_YXlEhex0GO";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk2_2_book: {
                url = "https://drive.google.com/drive/folders/1MQhSs3lYIjBNh-IET0N8T-oUoTBJwJQN";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;

            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk3_book: {
                url = "https://youtu.be/D70XOBat2mE";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk4_book: {
                url = "https://youtu.be/IjNciZA38RE";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk5_book: {
                url = "https://youtu.be/8BY68VGpMJk";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;

            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk6_book: {
                url = "https://youtu.be/M07rPi7NHE4";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;

            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk7_book: {
                url = "https://youtu.be/Hmr87fh0M1s";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            }
            case R.id.nahw3_go_to_Sharh_alfetAbnMalk8_book: {
                url = "https://youtu.be/FKCxqp48A2";
                OpenLinks.getOpenLinksInstance().openLinksMethod(requireContext(), url);
                break;
            }
            case R.id.nahw3_go_to_test1: {
                url = "https://www.arab-exams.com/tests_search_results.php?words=%D9%86%D8%AD%D9%88";
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

    public void setButtonsOnClickListener() {

        fragmentNahw3Binding.nahw3GoToDoctorBook.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToAlfetAbnMalk1Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToStudentBook.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToLastExamsBook.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk1Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk2Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk22Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk3Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk4Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk5Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk6Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk7Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToSharhAlfetAbnMalk8Book.setOnClickListener(this);
        fragmentNahw3Binding.nahw3GoToTest1.setOnClickListener(this);
    }

}