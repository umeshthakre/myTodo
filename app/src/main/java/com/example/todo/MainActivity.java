package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.Fragment.AddTodoFragment;
import com.example.Fragment.CompletedTodoFrgment;

public class MainActivity extends AppCompatActivity {
    Button addTodo,completeTodo,dueTodo;
    LinearLayout linearLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTodo = findViewById(R.id.btnAddTodo);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout2.setBackgroundColor(getResources().getColor(R.color.black));
        addTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout2.setBackgroundColor(getResources().getColor(R.color.bgforTodo));
                AddTodoFragment firstFragment = new AddTodoFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, firstFragment);
                transaction.commit();
            }
        });
        completeTodo = findViewById(R.id.btnCompleted);
        completeTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompletedTodoFrgment completedTodoFrgment = new CompletedTodoFrgment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, completedTodoFrgment);
                transaction.commit();
            }
        });

    }
}