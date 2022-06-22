package com.y4.projektcheck.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.y4.projektcheck.Models.GameSession;
import com.y4.projektcheck.R;

import java.util.ArrayList;

public class GameSessionRequestsAdapter extends RecyclerView.Adapter<GameSessionRequestsAdapter.GameSessionRequestsViewHolder> {
    private ArrayList<GameSession> sessionsArrayList = new ArrayList<>();
    private OnItemClickListener playersRequestClick;

    public GameSessionRequestsAdapter() {
    }

    public ArrayList<GameSession> getSessionsArrayList() {
        return sessionsArrayList;
    }

    public void setSessionsArrayList(ArrayList<GameSession> sessionsArrayList) {
        this.sessionsArrayList = sessionsArrayList;
    }

    public OnItemClickListener getPlayersRequestClick() {
        return playersRequestClick;
    }

    public void setPlayersRequestClick(OnItemClickListener playersRequestClick) {
        this.playersRequestClick = playersRequestClick;
    }

    public GameSessionRequestsAdapter(ArrayList<GameSession> sessionsArrayList, OnItemClickListener playersRequestClick) {
        this.sessionsArrayList = sessionsArrayList;
        this.playersRequestClick = playersRequestClick;
    }

    @NonNull
    @Override
    public GameSessionRequestsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_session_player_layout, parent, false);
        return new GameSessionRequestsViewHolder(view);
    }

    public interface OnItemClickListener {
        void playerClick(GameSession gameSession);
    }

    @Override
    public void onBindViewHolder(@NonNull GameSessionRequestsViewHolder holder, int position) {
        if (sessionsArrayList.get(position).getGameSessionPlayers() != null && !sessionsArrayList.get(position).getGameSessionPlayers().isEmpty()) {
            holder.playerName.setText("Host: "
                    .concat(String.valueOf(sessionsArrayList.get(position).getGameSessionPlayers().get("Player1UserName")))
                    .concat("\n").concat("Session ID: ".concat(sessionsArrayList.get(position).getGameSessionId())));

        }
        holder.bindClickSession(sessionsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return sessionsArrayList.size();
    }

    public class GameSessionRequestsViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView playerName;

        public GameSessionRequestsViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_username_text);
        }

        public void bindClickSession(GameSession gameSession) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playersRequestClick.playerClick(gameSession);
                }
            });
        }
    }
}
