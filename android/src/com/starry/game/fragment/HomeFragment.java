package com.starry.game.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.starry.game.AndroidLauncher;
import com.starry.game.LoginActivity;
import com.starry.game.MainActivity;
import com.starry.game.R;

public class HomeFragment extends Fragment {

    private TextView nameTextView;
    private TextView emailTextView;
    private FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        Button startGame = (Button) view.findViewById(R.id.start_button);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AndroidLauncher.class);
                startActivity(intent);
            }
        });

        nameTextView = (TextView) view.findViewById(R.id.name_textView);
        emailTextView = (TextView) view.findViewById(R.id.email_textView);

        auth = FirebaseAuth.getInstance();
        nameTextView.setText(auth.getCurrentUser().getDisplayName());
        emailTextView.setText(auth.getCurrentUser().getEmail());

        Button logOut = (Button) view.findViewById(R.id.logout_button);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                //LoginManager.getInstance().logOut();
                //finish();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
