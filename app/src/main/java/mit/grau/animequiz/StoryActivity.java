package mit.grau.animequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    TextView textV = null;
    ImageView imageV = null;
    int state = 0;
    int[] textArr = null;
    int[] imageIDsArr = null;

    Dialog want_leave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_novel_window);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //get window_num
        int window_num = -1;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null)
                window_num = extras.getInt("LEVEL");
        } else
            window_num = (Integer) savedInstanceState.getSerializable("LEVEL");

        //if forgot to make a level, showing an error
        if (window_num == -1) {
            System.err.println("ERROR: You forgot to add LEVEL extra when calling this activity!");
            finish();
        }
        window_num--;


        //load data
        textArr = Array.getTextData(window_num);
        imageIDsArr = Array.getIDData(window_num);

        //find Views
        textV = findViewById(R.id.novel_txt);
        imageV = findViewById(R.id.lecture_maket);

        Button back = findViewById(R.id.back_btn);
        Button next = findViewById(R.id.continue_btn);
        Button further = findViewById(R.id.further_btn);

        back.setVisibility(View.INVISIBLE);
        back.setActivated(false);

        further.setVisibility(View.INVISIBLE);
        further.setActivated(false);

        //making leave_lvl_window after back_btn
        want_leave = new Dialog(this);
        want_leave.requestWindowFeature(Window.FEATURE_NO_TITLE);
        want_leave.setContentView(R.layout.leave_lvl_window);
        want_leave.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        want_leave.setCancelable(false);

        //yes_btn on leave_lvl_window для перехода назад (от StoryActivity к Levels(сёнэн))
        Button yes_btn = want_leave.findViewById(R.id.yes_btn);
        yes_btn.setOnClickListener(v -> {
            Intent intent = new Intent(StoryActivity.this, Levels.class);
            startActivity(intent);
            finish();
            want_leave.dismiss();
        });

        //no_btn on leave_lvl_window для перехода обратно к игре (на StoryActivity)
        Button no_btn = want_leave.findViewById(R.id.no_btn);
        no_btn.setOnClickListener(v -> want_leave.dismiss());

        back.setOnClickListener(v -> {
            if (state == 1) {
                back.setVisibility(View.INVISIBLE);
                back.setActivated(false);
            } else if (state == textArr.length - 1) {
                further.setVisibility(View.INVISIBLE);
                further.setActivated(false);
                next.setVisibility(View.VISIBLE);
                next.setActivated(true);
            }
            state--;
            update();
        });

        next.setOnClickListener(v -> {
            if (state == textArr.length - 2) {
                next.setVisibility(View.INVISIBLE);
                next.setActivated(false);
                further.setVisibility(View.VISIBLE);
                further.setActivated(true);
            } else if (state == 0) {
                back.setVisibility(View.VISIBLE);
                back.setActivated(true);
            }
            state++;
            update();
        });

        int finalWindow_num = window_num;
        further.setOnClickListener(v -> {
            Intent intent = new Intent(StoryActivity.this, Levels.class);
            intent.putExtra("LEVEL", finalWindow_num);
            startActivity(intent);
            finish();
        });

        update();
    }

    private void update() {
        textV.setText(textArr[state]);
        imageV.setImageResource(imageIDsArr[state]);
    }

    //remake of System's back_btn on StoryActivity
    @Override
    public void onBackPressed() { want_leave.show(); }

}