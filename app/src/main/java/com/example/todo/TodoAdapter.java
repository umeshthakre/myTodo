package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class TodoAdapter extends FirebaseRecyclerAdapter<Todo, TodoAdapter.TodoViewHolder> {

    public TodoAdapter(@NonNull FirebaseRecyclerOptions<Todo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull TodoViewHolder holder, int position, @NonNull Todo todo) {
    holder.title.setText(todo.getTitle());
    holder.descripion.setText(todo.getDescription());
    holder.label.setText(todo.getLabel());
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo, parent, false);

        return new TodoViewHolder(view);
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView title,label,descripion,due;
        Button complete;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            label= itemView.findViewById(R.id.tvLable);
            descripion = itemView.findViewById(R.id.tvDescription);
        }
    }
}
