package mit.grau.animequiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog lvl_preview;
    Dialog want_leave;
    Dialog lvl_end_window;

    Random random = new Random();
    Array array = new Array();
    public int right_answers = 0;
    public int count = 0;

    //arrays with right answers
    int first, second, third, fourth;
    int[] answers1 = new int[] {1, 0, 0, 0, 1, 0, 0, 0, 1, 0};
    int[] answers2 = new int[] {0, 1, 0, 0, 0, 1, 0, 0, 0, 1};
    int[] answers3 = new int[] {0, 0, 1, 0, 0, 0, 1, 0, 0, 0};
    int[] answers4 = new int[] {0, 0, 0, 1, 0, 0, 0, 1, 0, 0};

    ImageView img;
    Button first_q;
    Button second_q;
    Button third_q;
    Button fourth_q;

    Animation a;

    int[] anime_nameArr = null;
    int[] imgArr = null;

    int[] first_qArr = null;
    int[] second_qArr = null;
    int[] third_qArr = null;
    int[] fourth_qArr = null;


    @SuppressLint({"ResourceAsColor", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_test);

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
        imgArr = Array.getTestImgData(lvl_num);

        first_qArr = Array.getFirstQData(lvl_num);
        second_qArr = Array.getSecondQData(lvl_num);
        third_qArr = Array.getThirdQData(lvl_num);
        fourth_qArr = Array.getFourthQData(lvl_num);

        //number of level
        TextView lvl_number = findViewById(R.id.number_of_lvls);
        lvl_number.setText(array.nums_of_lvls[lvl_num]);

        //circle corners for img
        img = findViewById(R.id.img);
        img.setClipToOutline(true);

        //way to animenames
        first_q = findViewById(R.id.txt_for_q_first);
        second_q = findViewById(R.id.txt_for_q_second);
        third_q = findViewById(R.id.txt_for_q_third);
        fourth_q = findViewById(R.id.txt_for_q_fourth);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //__________________________________________________________________________________________

        //making lvl_preview before lvl
        lvl_preview = new Dialog(this); //making dialog window
        lvl_preview.requestWindowFeature(Window.FEATURE_NO_TITLE); //heading is hiding
        lvl_preview.setContentView(R.layout.lvl_preview); //way to the dialog window
        lvl_preview.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //noncolor color of dialog window
        lvl_preview.setCancelable(false); //window can't be closed by system back btn

        //close_btn on lvl_preview для перехода назад (от Level2 к Levels(сёнэн))
        TextView preview_close_btn = lvl_preview.findViewById(R.id.preview_close_btn);
        preview_close_btn.setOnClickListener(v -> {
            Intent intent = new Intent(Level2.this, Levels.class);
            startActivity(intent);
            finish();
            lvl_preview.dismiss(); //closing dialog window
        });

        //continue_btn on lvl_preview для перехода дальше (от Levels(сёнэн) к Level2)
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

        //back_btn on Level2 (от Level2 к leave_lvl_window)
        Button back_btn_for_senen_lvl2 = findViewById(R.id.back_btn_for_senen_lvl2);
        back_btn_for_senen_lvl2.setOnClickListener(v -> want_leave.show());

        //yes_btn on leave_lvl_window для перехода назад (от Level2 к Levels(сёнэн))
        Button yes_btn = want_leave.findViewById(R.id.yes_btn);
        yes_btn.setOnClickListener(v -> {
            Intent intent = new Intent(Level2.this, Levels.class);
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

        //close_btn on lvl_preview для перехода назад (от Level2 к Levels(сёнэн))
        TextView lvl_endwindow_close_btn = lvl_end_window.findViewById(R.id.preview_close_btn);
        lvl_endwindow_close_btn.setOnClickListener(v -> {
            Intent intent = new Intent(Level2.this, Levels.class);
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
        a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);

        for (int i = 0; i < 10; i++) {
            nextQuestion.add(i);
        }
        nextQuart();

        //handle clicking on first ask
        int finalLvl_num = lvl_num + 1;
        first_q.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //finger touched image
                second_q.setEnabled(false);
                third_q.setEnabled(false);
                fourth_q.setEnabled(false);
                if (first == 1) {
                    right_answers ++;
                } else {}
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //finger removed from the image
                if (first == 1) {
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
                        Intent intent = new Intent(Level2.this, StoryActivity.class);
                        intent.putExtra("LEVEL", finalLvl_num);
                        startActivity(intent);
                        finish();
                    } else {
                        lvl_end_window.show();
                    }
                } else {
                    nextQuart();
                    second_q.setEnabled(true);
                    third_q.setEnabled(true);
                    fourth_q.setEnabled(true);
                }
            }
            return true;
        });

        //handle clicking on second ask
        second_q.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //finger touched image
                first_q.setEnabled(false);
                third_q.setEnabled(false);
                fourth_q.setEnabled(false);
                if (second == 1) {
                    right_answers ++;
                } else {}
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //finger removed from the image
                if (second == 1) {
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
                        Intent intent = new Intent(Level2.this, StoryActivity.class);
                        intent.putExtra("LEVEL", finalLvl_num);
                        startActivity(intent);
                        finish();
                    } else {
                        lvl_end_window.show();
                    }
                } else {
                    nextQuart();
                    first_q.setEnabled(true);
                    third_q.setEnabled(true);
                    fourth_q.setEnabled(true);
                }
            }
            return true;
        });

        //handle clicking on third ask
        third_q.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //finger touched image
                first_q.setEnabled(false);
                second_q.setEnabled(false);
                fourth_q.setEnabled(false);
                if (third == 1) {
                    right_answers ++;
                } else {}
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //finger removed from the image
                if (third == 1) {
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
                        Intent intent = new Intent(Level2.this, StoryActivity.class);
                        intent.putExtra("LEVEL", finalLvl_num);
                        startActivity(intent);
                        finish();
                    } else {
                        lvl_end_window.show();
                    }
                } else {
                    nextQuart();
                    first_q.setEnabled(true);
                    second_q.setEnabled(true);
                    fourth_q.setEnabled(true);
                }
            }
            return true;
        });

        //handle clicking on fourth ask
        fourth_q.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //finger touched image
                first_q.setEnabled(false);
                second_q.setEnabled(false);
                third_q.setEnabled(false);
                if (fourth == 1) {
                    right_answers ++;
                } else {}
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //finger removed from the image
                if (fourth == 1) {
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
                        Intent intent = new Intent(Level2.this, StoryActivity.class);
                        intent.putExtra("LEVEL", finalLvl_num);
                        startActivity(intent);
                        finish();
                    } else {
                        lvl_end_window.show();
                    }
                } else {
                    nextQuart();
                    first_q.setEnabled(true);
                    second_q.setEnabled(true);
                    third_q.setEnabled(true);
                }
            }
            return true;
        });
    }

    private void setQuart(int trueQuart) {
        img.setImageResource(imgArr[trueQuart]);

        first_q.setText(first_qArr[trueQuart]);
        second_q.setText(second_qArr[trueQuart]);
        third_q.setText(third_qArr[trueQuart]);
        fourth_q.setText(fourth_qArr[trueQuart]);

        first = answers1[trueQuart];
        second = answers2[trueQuart];
        third = answers3[trueQuart];
        fourth = answers4[trueQuart];
    }

    //algorithm for showing each pair of cards once
    List<Integer> nextQuestion = new ArrayList<>();
    private void nextQuart() {
        int nextQuart = random.nextInt(nextQuestion.size());
        int trueQuart = nextQuestion.get(nextQuart);
        nextQuestion.remove(nextQuart);
        setQuart(trueQuart);
    }

    //remake of System's back_btn on SenenLevel1
    @Override
    public void onBackPressed() {
        want_leave.show();
    }
}