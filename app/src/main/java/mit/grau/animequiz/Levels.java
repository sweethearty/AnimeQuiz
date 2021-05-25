package mit.grau.animequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //back_btn on Levels (от Levels(сёнэн) к ListOfLevels)
        Button back_btn_for_levels = findViewById(R.id.back_btn_for_levels);
        back_btn_for_levels.setOnClickListener(v -> {
            Intent intent = new Intent(Levels.this, ListOfLevels.class);
            startActivity(intent);
            finish();
        });

        //one_btn on Levels(сёнэн) (от Levels(сёнэн) к Level2) for the second level
        TextView senenlevel1 = findViewById(R.id.level1);
        senenlevel1.setOnClickListener(v -> {
            Intent intent = new Intent(Levels.this, Level2.class);
            intent.putExtra("LVL", 1);
            startActivity(intent);
            finish();
        });

        //two_btn on Levels(сёнэн) (от Levels(сёнэн) к SenenLevel1) for the first level
        TextView senenlevel2 = findViewById(R.id.level2);
        senenlevel2.setOnClickListener(v -> {
            Intent intent = new Intent(Levels.this, SenenLevel1.class);
            intent.putExtra("LVL", 2);
            startActivity(intent);
            finish();
        });

        //three_btn on Levels(сёнэн) (от Levels(сёнэн) к SenenLevel1) for the second level
        TextView senenlevel3 = findViewById(R.id.level3);
        senenlevel3.setOnClickListener(v -> {
            Intent intent = new Intent(Levels.this, SenenLevel1.class);
            intent.putExtra("LVL", 3);
            startActivity(intent);
            finish();
        });

        //four_btn on Levels(сёнэн) (от Levels(сёнэн) к Level2) for the second level
        TextView senenlevel4 = findViewById(R.id.level4);
        senenlevel4.setOnClickListener(v -> {
            Intent intent = new Intent(Levels.this, Level2.class);
            intent.putExtra("LVL", 4);
            startActivity(intent);
            finish();
        });
    }
    //remake of System's back_btn on Levels
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Levels.this, ListOfLevels.class);
        startActivity(intent);
        finish();
    }
}