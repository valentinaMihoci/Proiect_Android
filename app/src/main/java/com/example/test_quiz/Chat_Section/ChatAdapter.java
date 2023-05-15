package com.example.test_quiz.Chat_Section;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_quiz.R;
import java.util.List;
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<ChatMessage> messages;
    private LayoutInflater inflater;

    public ChatAdapter(Context context, List<ChatMessage> messages) {
        this.inflater = LayoutInflater.from(context);
        this.messages = messages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_chat_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatMessage message = messages.get(position);
        holder.bind(message);
    }

    public void add(ChatMessage message) {
        messages.add(message);
        notifyItemInserted(messages.size() - 1);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView message1;
        ImageView circleImageView;
        TextView text_time;
        public ViewHolder(View itemView) {
            super(itemView);


            username = (TextView)itemView.findViewById(R.id.list_item_username);
            message1 = (TextView)itemView.findViewById(R.id.list_item_message);
            circleImageView = (ImageView)itemView.findViewById(R.id.userChatImage);
            text_time = (TextView)itemView.findViewById(R.id.text_message_time);

        }

        public void bind(ChatMessage message) {
            circleImageView.setImageResource(R.drawable.speaking);
            username.setText(message.getUsername());
            message1.setText(message.getMessage());
            text_time.setText(message.getComment_time());
        }
    }
}

