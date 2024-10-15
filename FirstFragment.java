package com.example.tablayout;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class FirstFragment extends Fragment {

    private ViewPager2 viewPager2; // Declare ViewPager2

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // Initialize viewPager2
        viewPager2 = requireActivity().findViewById(R.id.pager);

        // Find the UI elements in the fragment's layout
        Button logInButton = view.findViewById(R.id.logInButton);
        final EditText usernameEditText = view.findViewById(R.id.username);
        final EditText emailEditText = view.findViewById(R.id.email);
        final EditText phoneNumberEditText = view.findViewById(R.id.phoneNumber);

        // Set an OnClickListener for the "Log In" button
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the second fragment by switching to the second tab
                viewPager2.setCurrentItem(1); // Assuming the second tab is at position 1
            }
        });

        // Set an OnClickListener for the "Create Account" button
        Button createAccountButton = view.findViewById(R.id.btnToSecond);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to WelcomePage
                Intent intent = new Intent(getActivity(), Welcome.class);
                startActivity(intent);
            }
        });


        return view;
    }
}