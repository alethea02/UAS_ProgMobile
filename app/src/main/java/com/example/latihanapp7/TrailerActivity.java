package com.example.latihanapp7;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class TrailerActivity extends AppCompatActivity {

    private SimpleExoPlayer player;
    private int videoRawResourceId = R.raw.cts;
    private StyledPlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_comedy);

        // Inisialisasi ExoPlayer
        player = new SimpleExoPlayer.Builder(this).build();

        // Menggunakan tombol untuk langsung memainkan video
        Button trailerButton = findViewById(R.id.trailer); // Ganti dengan ID tombol yang sesuai di layout Anda
        trailerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTrailerPopup();
            }
        });
    }

    // Metode untuk menampilkan popup trailer
    private void showTrailerPopup() {
        // Buat URI dari resource ID video di folder raw
        Uri videoUri = Uri.parse("rawresource://" + getPackageName() + "/" + R.raw.cts);
        MediaItem mediaItem = MediaItem.fromUri(videoUri);

        // Set sumber video ke ExoPlayer
        player.setMediaItem(mediaItem);
        player.prepare();

        // Inflasi layout popup
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.popup_trailer, null);

        // Ambil referensi ke StyledPlayerView di dalam popup
        StyledPlayerView popupPlayerView = dialogView.findViewById(R.id.playerView);
        popupPlayerView.setPlayer(player); // Set player di dalam popupPlayerView

        // Tampilkan popup
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        player.setPlayWhenReady(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.release();
            player = null;
        }
    }
}
