package com.example.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todo.R;
import com.example.todo.Todo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddTodoFragment extends Fragment {
    DatabaseReference myRef;
    EditText title,label,description;
    Button submit;
    public AddTodoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_todo, container, false);

        submit = view.findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myRef = FirebaseDatabase.getInstance().getReference("Todo");
                title = getView().findViewById(R.id.etTitle);
                label = getView().findViewById(R.id.etlabel);
                description = getView().findViewById(R.id.etDescription);

                String Title = title.getText().toString();
                String Label = label.getText().toString();
                String Description = description.getText().toString();

                Todo todo = new Todo();
                todo.setTitle(Title);
                todo.setDescription(Description);
                todo.setLabel(Label);
                todo.setDue(true);
                myRef.push().setValue(todo).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getActivity(), "todo is added", Toast.LENGTH_SHORT).show();
                            title.setText("");
                            label.setText("");
                            description.setText("");
                        } else {
                            Toast.makeText(getActivity(), "please try again", Toast.LENGTH_SHORT).show();
                            title.setText("");
                            label.setText("");
                            description.setText("");
                        }
                    }
                });
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}