package mit.grau.animequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ListOfLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_levels);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //back_btn on ListOfLevels (от ListOfLevels к MainActivity)
        Button back_btn_for_levels = findViewById(R.id.back_btn_for_list_of_levels);
        back_btn_for_levels.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        //senen_btn on ListOfLevels (от ListOfLevels к Levels(сёнэн))
        ImageButton senen_imbtn = findViewById(R.id.senen_imbtn);
        senen_imbtn.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfLevels.this, Levels.class);
            startActivity(intent);
            finish();
        });
    }

    //remake of System's back_btn on ListOfLevels
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ListOfLevels.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}