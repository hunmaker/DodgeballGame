package com.starry.game.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.starry.game.LoginActivity;
import com.starry.game.R;

public class AccountFragment extends Fragment {

    private TextView nameTextView;
    private TextView emailTextView;
    private FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        nameTextView = (TextView) view.findViewById(R.id.name_textView);
        emailTextView = (TextView) view.findViewById(R.id.email_textView);

        auth = FirebaseAuth.getInstance();

//        final String myUid = auth.getCurrentUser().getUid();
//
//        FirebaseDatabase.getInstance().getReference().child("users").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    UserModel userModel = snapshot.getValue(UserModel.class);
//
//                    if(userModel.uid.equals(myUid))
//                        nameTextView.setText(userModel.userName);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

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