package com.jcodee.mod3class3.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jcodee.mod3class3.R;
import com.jcodee.mod3class3.entities.Comment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 20/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {
    private Context context;
    private ArrayList<Comment> lista;

    public CommentAdapter(Context context, ArrayList<Comment> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false);

        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        Comment comment = lista.get(position);

        holder.tvName.setText(comment.getName());
        holder.tvBody.setText(comment.getBody());
        holder.tvEmail.setText(comment.getEmail());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class CommentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvEmail)
        TextView tvEmail;
        @BindView(R.id.tvBody)
        TextView tvBody;

        public CommentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
