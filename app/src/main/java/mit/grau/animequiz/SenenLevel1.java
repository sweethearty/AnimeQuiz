package mit.grau.animequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SenenLevel1 extends AppCompatActivity {

    Dialog lvl_preview;
    Dialog want_leave;
    Dialog lvl_end_window;

    Random random = new Random();
    Array array = new Array();
    public int right_answers = 0;
    public int count = 0;
    public int numLeft, numRight;

    //array with right answers
    int[] answers = new int[] {1, 0, 1, 1, 0, 1, 0, 0, 1, 0};

    ImageView img_left;
    ImageView img_right;
    TextView heading_txt;
    TextView text_left;
    TextView text_right;

    Animation a;

    int[] anime_nameArr = null;
    int[] cardsArr = null;
    int[] character_namesArr = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_level);

        //get lvl_num
        int lvl_num = -1;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null)
                lvl_num = extras.getInt("LVL");
            else
                lvl_num = (Integer) savedInstanceState.getSerializable("LVL");
        }
        if (lvl_num == -1) {
            System.err.println("ERROR: You forgot to add LEVEL extra when calling this activity!");
            finish();
        }
        lvl_num--;

        //load data
        anime_nameArr = Array.getAnime_nameData(lvl_num);
        cardsArr = Array.getCardsData(lvl_num);
        character_namesArr = Array.getCharacter_namesData(lvl_num);

        //number of level
        TextView lvl_number = findViewById(R.id.number_of_lvls);
        lvl_number.setText(array.nums_of_lvls[lvl_num]);

        //circle corners for img_left
        img_left = findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        //circle corners for img_right
        img_right = findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        //way to animenames
        heading_txt = findViewById(R.id.anime_name);
        text_left = findViewById(R.id.txt_for_img_left);
        text_right = findViewById(R.id.txt_for_img_right);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //__________________________________________________________________________________________

        //making lvl_preview before lvl
        lvl_preview = new Dialog(this); //making dialog window
        lvl_preview.requestWindowFeature(Window.FEATURE_NO_TITLE); //heading is hiding
        lvl_preview.setContentView(R.layout.lvl_preview); //way to the dialog window
        lvl_preview.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //noncolor color of dialog window
        lvl_preview.setCancelable(false); //window can't be closed by system back btn

        //close_btn on lvl_preview для перехода назад (от SenenLevel1 к Levels(сёнэн))
        TextView preview_close_btn = lvl_preview.findViewById(R.id.preview_close_btn);
        preview_close_btn.setOnClickListener(v -> {
            Intent intent = new Intent(SenenLevel1.this, Levels.class);
            startActivity(intent);
            finish();
            lvl_preview.dismiss(); //closing dialog window
        });

        //continue_btn on lvl_preview для перехода дальше (от Levels(сёнэн) к SenenLevel1)
        Button preview_continue_btn = lvl_preview.findViewById(R.id.preview_continue_btn);
        preview_continue_btn.setOnClickListener(v -> lvl_preview.dismiss());
        lvl_preview.show();

        //__________________________________________________________________________________________

        //making leave_lvl_window after back_btn
        want_leave = new Dialog(this);
        want_leave.requestWindowFeature(Window.FEATURE_NO_TITLE);
        want_leave.setContentView(R.layout.leave_lvl_window);
        want_leave.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        want_leave.setCancelable(false);

        //back_btn on SenenLevel1 (от SenenLevel1 к leave_lvl_window)
        Button back_btn_for_senen_lvl1 = findViewById(R.id.back_btn_for_senen_lvl1);
        back_btn_for_senen_lvl1.setOnClickListener(v -> want_leave.show());

        //yes_btn on leave_lvl_window для перехода назад (от SenenLevel1 к Levels(сёнэн))
        Button yes_btn = want_leave.findViewById(R.id.yes_btn);
        yes_btn.setOnClickListener(v -> {
            Intent intent = new Intent(SenenLevel1.this, Levels.class);
            startActivity(intent);
            finish();
            want_leave.dismiss();
        });

        //no_btn on leave_lvl_window для перехода обратно к игре (на SenenLevel1)
        Button no_btn = want_leave.findViewById(R.id.no_btn);
        no_btn.setOnClickListener(v -> want_leave.dismiss());

        //__________________________________________________________________________________________

        //making lvl_preview before lvl
        lvl_end_window = new Dialog(this);
        lvl_end_window.requestWindowFeature(Window.FEATURE_NO_TITLE);
        lvl_end_window.setContentView(R.layout.lvl_end_window);
        lvl_end_window.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        lvl_end_window.setCancelable(false);

        //close_btn on lvl_preview для перехода назад (от SenenLevel1 к Levels(сёнэн))
        TextView lvl_endwindow_close_btn = lvl_end_window.findViewById(R.id.preview_close_btn);
        lvl_endwindow_close_btn.setOnClickListener(v -> {
            Intent intent = new Intent(SenenLevel1.this, Levels.class);
            startActivity(intent);
            finish();
            lvl_end_window.dismiss(); //closing dialog window
        });

        //all components for preview
        ImageView preview_img = lvl_preview.findViewById(R.id.img_preview);
        preview_img.setImageResource(array.preview_img[lvl_num]);

        TextView preview_lvl_name = lvl_preview.findViewById(R.id.preview_lvl_name);
        preview_lvl_name.setText(array.preview_lvl_name[lvl_num]);

        TextView preview_txt_description = lvl_preview.findViewById(R.id.preview_txt_description);
        preview_txt_description.setText(array.preview_txt_description[lvl_num]);

        //end_preview component
        TextView end_window_txt_description = lvl_end_window.findViewById(R.id.end_window_txt_description);
        end_window_txt_description.setText(array.end_window_txt_description[lvl_num]);


        //array for progress points
        final int[] progress = {
                R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10
        };

        //animation
        a = AnimationUtils.loadAnimation(SenenLevel1.this, R.anim.alpha);

        for (int i = 0; i < 10; i++) {
            nextCards.add(i);
        }
        nextPair();

        //handle clicking on left image
        int finalLvl_num = lvl_num + 1;
        img_left.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //finger touched image
                img_right.setEnabled(false);
                if (numLeft > numRight) {
                    img_left.setImageResource(R.drawable.true_img);
                    right_answers ++;
                } else {
                    img_left.setImageResource(R.drawable.false_img);
                }
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //finger removed from the image
                if (numLeft > numRight) {
                    //right answers become green
                    if (count == 0) {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_strt_point_green);
                    } else if (count == 9) {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_end_points_green);
                    } else {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                } else {
                    //wrong answers become red
                    if (count == 0) {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_strt_point_red);
                    } else if (count == 9) {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_end_points_red);
                    } else {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_red);
                    }
                }
                if (count < 10) {
                    count ++;
                }

                if (count == 10) {
                    //GAME OVER
                    if (right_answers > 5) {
                        Intent intent = new Intent(SenenLevel1.this, StoryActivity.class);
                        intent.putExtra("LEVEL", finalLvl_num);
                        startActivity(intent);
                    } else {
                        lvl_end_window.show();
                    }
                } else {
                    nextPair();
                    img_right.setEnabled(true);
                }
            }
            return true;
        });

        //handle clicking on right image
        img_right.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //finger touched image
                img_left.setEnabled(false);
                if (numLeft < numRight) {
                    img_right.setImageResource(R.drawable.true_img);
                    right_answers ++;
                } else {
                    img_right.setImageResource(R.drawable.false_img);
                }
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //finger removed from the image
                if (numLeft < numRight) {
                    //right answers become green
                    if (count == 0) {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_strt_point_green);
                    } else if (count == 9) {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_end_points_green);
                    } else {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                } else {
                    //wrong answers become red
                    if (count == 0) {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_strt_point_red);
                    } else if (count == 9) {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_end_points_red);
                    } else {
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_red);
                    }
                }
                if (count < 10) {
                    count ++;
                }
                if (count == 10) {
                    //GAME OVER
                    if (right_answers > 5) {
                        Intent intent = new Intent(SenenLevel1.this, StoryActivity.class);
                        intent.putExtra("LEVEL", finalLvl_num);
                        startActivity(intent);
                    } else {
                        lvl_end_window.show();
                    }
                } else {
                    nextPair();
                    img_left.setEnabled(true);
                }
            }
            return true;
        });
    }

    private void setPair(int truePair) {
        //choosing certain img to certain text
        heading_txt.setText(anime_nameArr[truePair]);

        img_left.setImageResource(cardsArr[truePair * 2]);
        img_left.startAnimation(a);
        text_left.setText(character_namesArr[truePair * 2]);

        img_right.setImageResource(cardsArr[truePair * 2 + 1]);
        img_right.startAnimation(a);
        text_right.setText(character_namesArr[truePair * 2 + 1]);

        numLeft = answers[truePair] == 0 ? 1 : 0;
        numRight = answers[truePair];
    }

    //algorithm for showing each pair of cards once
    List<Integer> nextCards = new ArrayList<>();
    private void nextPair() {
        int nextPair = random.nextInt(nextCards.size());
        int truePair = nextCards.get(nextPair);
        nextCards.remove(nextPair);
        setPair(truePair);
    }

    //remake of System's back_btn on SenenLevel1
    @Override
    public void onBackPressed() {
        want_leave.show();
    }
}