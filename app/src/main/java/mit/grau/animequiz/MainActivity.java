package mit.grau.animequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private long systemBackbtnPressedTime;
    private Toast exitToast;

    public int random_greeting;
    Random random = new Random();
    Array array = new Array();

    int a = 1;

    final Handler handler = new Handler();

    private final TextView[] info = new TextView[2];
    private final TextView[] settings = new TextView[2];
    private final Animation[] rotate = new Animation[2];
    private final Animation[] fade = new Animation[2];

    ImageView info_btn;
    ImageView settings_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Array.init();

        info_btn = findViewById(R.id.btInfo);
        settings_btn = findViewById(R.id.btSettings);

        //load from layout
        info[0] = findViewById(R.id.textInfo1);
        info[1] = findViewById(R.id.textInfo2);
        settings[0] = findViewById(R.id.textSettings1);
        settings[1] = findViewById(R.id.textSettings2);

        //load anim
        rotate[0] = AnimationUtils.loadAnimation(this, R.anim.rotate_left);
        rotate[1] = AnimationUtils.loadAnimation(this, R.anim.rotate_right);
        fade[0] = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fade[1] = AnimationUtils.loadAnimation(this, R.anim.fade_out);


        //start_btn on MainActivity (от MainActivity к ListOfLevels)
        Button start_btn = findViewById(R.id.start_btn);
        start_btn.setOnClickListener(v -> {
            try {
                if (a == 1) {
                    setContentView(R.layout.welcome_novel_window);

                    //buttons on novel window
                    Button back_btn = findViewById(R.id.back_btn);
                    Button continue_btn = findViewById(R.id.continue_btn);
                    Button further_btn = findViewById(R.id.further_btn);

                    further_btn.setEnabled(false);
                    further_btn.setVisibility(View.GONE);
                    back_btn.setEnabled(false);
                    back_btn.setVisibility(View.GONE);

                    //making way to img "lecture_maket"
                    final ImageView lecture_maket = findViewById(R.id.lecture_maket);

                    //making way to tv "greeting_txt"
                    final TextView text_of_greeting = findViewById(R.id.novel_txt);

                    random_greeting = random.nextInt(23);
                    lecture_maket.setImageResource(array.greetings_img_part1[random_greeting]);
                    text_of_greeting.setText(array.greetings_txt_part1[random_greeting]);

                    continue_btn.setOnClickListener(v1 -> {
                        continue_btn.setEnabled(false);
                        continue_btn.setVisibility(View.GONE);
                        back_btn.setEnabled(true);
                        back_btn.setVisibility(View.VISIBLE);
                        further_btn.setEnabled(true);
                        further_btn.setVisibility(View.VISIBLE);

                        lecture_maket.setImageResource(array.greetings_img_part2[random_greeting]);
                        text_of_greeting.setText(array.greetings_txt_part2[random_greeting]);

                        back_btn.setOnClickListener(v11 -> {
                            back_btn.setEnabled(false);
                            back_btn.setVisibility(View.GONE);
                            further_btn.setEnabled(false);
                            further_btn.setVisibility(View.GONE);
                            continue_btn.setEnabled(true);
                            continue_btn.setVisibility(View.VISIBLE);

                            lecture_maket.setImageResource(array.greetings_img_part1[random_greeting]);
                            text_of_greeting.setText(array.greetings_txt_part1[random_greeting]);

                            continue_btn.setOnClickListener(v111 -> {
                                further_btn.setEnabled(true);
                                further_btn.setVisibility(View.VISIBLE);
                                back_btn.setEnabled(true);
                                back_btn.setVisibility(View.VISIBLE);
                                continue_btn.setEnabled(false);
                                continue_btn.setVisibility(View.GONE);

                                lecture_maket.setImageResource(array.greetings_img_part2[random_greeting]);
                                text_of_greeting.setText(array.greetings_txt_part2[random_greeting]);
                            });
                        });

                        continue_btn.setOnClickListener(v112 -> {
                            further_btn.setEnabled(true);
                            further_btn.setVisibility(View.VISIBLE);
                            back_btn.setEnabled(true);
                            back_btn.setVisibility(View.VISIBLE);

                            lecture_maket.setImageResource(array.greetings_img_part1[random_greeting]);
                            text_of_greeting.setText(array.greetings_txt_part1[random_greeting]);
                        });

                        further_btn.setOnClickListener(v113 -> {
                            a = 0;
                            Intent intent = new Intent(MainActivity.this, ListOfLevels.class);
                            startActivity(intent);
                            finish();
                        });
                    });
                } else {
                    Intent intent = new Intent(MainActivity.this, ListOfLevels.class);
                    startActivity(intent);
                    finish();
                }
            } catch (Exception ignored) {}
        });
    }

    //click handling method Info
    public void onInfoClick(View v) {
        int alpha = (int) info[0].getAlpha(); //making transparency 1 with alpha
        info_btn.setEnabled(true);
        settings_btn.setEnabled(false);
        if(alpha == 0) {
            info[0].setAlpha(1);
            info[1].setAlpha(1);
        } else {
            handler.postDelayed(() -> {
                info[0].setAlpha(0);
                info[1].setAlpha(0);
            }, 500);
        }
        v.startAnimation(rotate[alpha]);
        info[0].startAnimation(fade[alpha]);
        info[1].startAnimation(fade[alpha]);
        if (alpha == 1) {
            settings_btn.setEnabled(true);
        }
    }

    //click handling method for Settings
    public void onSettingsClick(View v) {
        int alpha = (int) settings[0].getAlpha();
        settings_btn.setEnabled(true);
        info_btn.setEnabled(false);
        if(alpha == 0) {
            settings[0].setAlpha(1);
            settings[1].setAlpha(1);
        } else {
            handler.postDelayed(() -> {
                settings[0].setAlpha(0);
                settings[1].setAlpha(0);
            }, 500);
        }
        v.startAnimation(rotate[alpha]);
        settings[0].startAnimation(fade[alpha]);
        settings[1].startAnimation(fade[alpha]);
        if (alpha == 1) {
            info_btn.setEnabled(true);
        }
    }

    //remake of System's back_btn on MainActivity
    @Override
    public void onBackPressed() {
        if (systemBackbtnPressedTime + 2000 > System.currentTimeMillis()) {
            exitToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            exitToast = Toast.makeText(getBaseContext(), "Чтобы выйти нажмите еще раз", Toast.LENGTH_SHORT);
            exitToast.show();
        }
        systemBackbtnPressedTime = System.currentTimeMillis();
    }
}