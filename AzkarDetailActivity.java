package com.azkaar360;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AzkarDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AzkarAdapter adapter;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        category = getIntent().getStringExtra("CATEGORY");
        
        recyclerView = findViewById(R.id.azkarRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadAzkar();
    }

    private void loadAzkar() {
        List<Azkar> azkarList = null;
        String title = "";

        switch (category) {
            case "morning":
                azkarList = AzkarDatabase.getMorningAzkar();
                title = "Morning Azkar";
                break;
            case "evening":
                azkarList = AzkarDatabase.getEveningAzkar();
                title = "Evening Azkar";
                break;
            case "afterprayer":
                azkarList = AzkarDatabase.getAfterPrayerAzkar();
                title = "After Prayer Azkar";
                break;
            case "sleeping":
                azkarList = AzkarDatabase.getSleepingAzkar();
                title = "Sleeping Azkar";
                break;
        }

        getSupportActionBar().setTitle(title);
        adapter = new AzkarAdapter(azkarList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    // Adapter Class
    private class AzkarAdapter extends RecyclerView.Adapter<AzkarAdapter.AzkarViewHolder> {
        private List<Azkar> azkarList;

        public AzkarAdapter(List<Azkar> azkarList) {
            this.azkarList = azkarList;
        }

        @NonNull
        @Override
        public AzkarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_azkar, parent, false);
            return new AzkarViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AzkarViewHolder holder, int position) {
            Azkar azkar = azkarList.get(position);
            holder.bind(azkar);
        }

        @Override
        public int getItemCount() {
            return azkarList.size();
        }

        class AzkarViewHolder extends RecyclerView.ViewHolder {
            TextView arabicText, urduText, englishText, transliterationText, repetitionBadge;
            ImageButton playButton, copyButton, shareButton, bookmarkButton;

            public AzkarViewHolder(@NonNull View itemView) {
                super(itemView);
                arabicText = itemView.findViewById(R.id.arabicText);
                urduText = itemView.findViewById(R.id.urduText);
                englishText = itemView.findViewById(R.id.englishText);
                transliterationText = itemView.findViewById(R.id.transliterationText);
                repetitionBadge = itemView.findViewById(R.id.repetitionBadge);
                
                playButton = itemView.findViewById(R.id.playButton);
                copyButton = itemView.findViewById(R.id.copyButton);
                shareButton = itemView.findViewById(R.id.shareButton);
                bookmarkButton = itemView.findViewById(R.id.bookmarkButton);
            }

            public void bind(Azkar azkar) {
                arabicText.setText(azkar.getArabic());
                urduText.setText(azkar.getUrdu());
                englishText.setText(azkar.getEnglish());
                transliterationText.setText(azkar.getTransliteration());
                
                if (azkar.getRepetitions() > 1) {
                    repetitionBadge.setText(azkar.getRepetitions() + "x");
                    repetitionBadge.setVisibility(View.VISIBLE);
                } else {
                    repetitionBadge.setVisibility(View.GONE);
                }

                copyButton.setOnClickListener(v -> {
                    String text = azkar.getArabic() + "\n" + 
                                 azkar.getTransliteration() + "\n" + 
                                 azkar.getEnglish();
                    ClipboardManager clipboard = (ClipboardManager) 
                            getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("Azkar", text);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(AzkarDetailActivity.this, "Copied to clipboard", 
                            Toast.LENGTH_SHORT).show();
                });

                shareButton.setOnClickListener(v -> {
                    String text = azkar.getArabic() + "\n" + 
                                 azkar.getTransliteration() + "\n" + 
                                 azkar.getEnglish() + "\n\n" +
                                 "Shared via Azkaar360";
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(shareIntent, "Share Azkar"));
                });

                bookmarkButton.setOnClickListener(v -> {
                    azkar.setBookmarked(!azkar.isBookmarked());
                    Toast.makeText(AzkarDetailActivity.this, 
                            azkar.isBookmarked() ? "Bookmarked" : "Bookmark removed", 
                            Toast.LENGTH_SHORT).show();
                });

                playButton.setOnClickListener(v -> {
                    Toast.makeText(AzkarDetailActivity.this, 
                            "Audio playback - Add your audio files", 
                            Toast.LENGTH_SHORT).show();
                });
            }
        }
    }
}
