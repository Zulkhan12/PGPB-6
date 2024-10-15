package com.example.tablayout;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondFragment extends Fragment {

    private ViewPager2 viewPager2; // Declare ViewPager2
    private EditText emailEditText;
    private EditText passwordEditText;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        emailEditText = view.findViewById(R.id.username);
        passwordEditText = view.findViewById(R.id.passwordLogin);

        // Assuming you've initialized viewPager2 in your activity
        viewPager2 = getActivity().findViewById(R.id.pager);

        Button loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        Button createAccountButton = view.findViewById(R.id.CreateAccountButton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the first fragment by switching to the first tab (assuming the first tab is at position 0)
                viewPager2.setCurrentItem(0);
            }
        });

        return view;
    }

    private void loginUser() {
        String enteredEmail = emailEditText.getText().toString();
        String enteredPassword = passwordEditText.getText().toString();

        if (enteredEmail.equals("123@gmail.com") && enteredPassword.equals("123")) {
            // Login successful, navigate to WelcomePage
            Intent intent = new Intent(getActivity(), Welcome.class);
            startActivity(intent);
        } else {
            // Login failed, display a message
            displayMessage("Masukan username atau password yang benar!");
        }
    }

    private void displayMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}