package mit.grau.animequiz;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    //array with numbers of levels
    final int[] nums_of_lvls = {
            R.string.number_of_lvl_1,
            R.string.number_of_lvl_2,
            R.string.number_of_lvl_3,
            R.string.number_of_lvl_4,
            R.string.number_of_lvl_5,
            R.string.number_of_lvl_6,
            R.string.number_of_lvl_7,
            R.string.number_of_lvl_8,
            R.string.number_of_lvl_9,
            R.string.number_of_lvl_10
    };

    //-----------------

    //arrays for all components on prewiew window
    //array with images on preview window
    final int[] preview_img = {
            R.drawable.card_for_1st_preview,
            R.drawable.card_for_1st_preview,
            R.drawable.card_for_1st_preview,
            R.drawable.card_for_1st_preview,
    };

    //array with big texts on preview window
    final int[] preview_lvl_name = {
            R.string.senen_lvl_one1,
            R.string.senen_lvl_two1,
            R.string.senen_lvl_three1,
            R.string.senen_lvl_one1,
    };

    //array with small texts on preview window
    final int[] preview_txt_description = {
            R.string.senen_lvl_one2,
            R.string.senen_lvl_two2,
            R.string.senen_lvl_three2,
            R.string.senen_lvl_one2,
    };

    //-----------------

    //array with small texts on end_preview window
    final int[] end_window_txt_description = {
            R.string.senen_end_lvl_one2,
            R.string.senen_end_lvl_two2,
            R.string.senen_end_lvl_three2,
            R.string.senen_end_lvl_four2,
    };

    //-----------------

    //arrays for greetings
    final int[] greetings_txt_part1 = {
            R.string.part1_greeting1,
            R.string.part1_greeting2,
            R.string.part1_greeting3,
            R.string.part1_greeting4,
            R.string.part1_greeting5,
            R.string.part1_greeting6,
            R.string.part1_greeting7,
            R.string.part1_greeting8,
            R.string.part1_greeting9,
            R.string.part1_greeting10,
            R.string.part1_greeting11,
            R.string.part1_greeting12,
            R.string.part1_greeting13,
            R.string.part1_greeting14,
            R.string.part1_greeting15,
            R.string.part1_greeting16,
            R.string.part1_greeting17,
            R.string.part1_greeting18,
            R.string.part1_greeting19,
            R.string.part1_greeting20,
            R.string.part1_greeting21,
            R.string.part1_greeting22,
            R.string.part1_greeting23
    };

    final int[] greetings_txt_part2 = {
            R.string.part2_greeting1,
            R.string.part2_greeting2,
            R.string.part2_greeting3,
            R.string.part2_greeting4,
            R.string.part2_greeting5,
            R.string.part2_greeting6,
            R.string.part2_greeting7,
            R.string.part2_greeting8,
            R.string.part2_greeting9,
            R.string.part2_greeting10,
            R.string.part2_greeting11,
            R.string.part2_greeting12,
            R.string.part2_greeting13,
            R.string.part2_greeting14,
            R.string.part2_greeting15,
            R.string.part2_greeting16,
            R.string.part2_greeting17,
            R.string.part2_greeting18,
            R.string.part2_greeting19,
            R.string.part2_greeting20,
            R.string.part2_greeting21,
            R.string.part2_greeting22,
            R.string.part2_greeting23
    };

    final int[] greetings_img_part1 = {
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_normal,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_comehere,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_normal,
            R.drawable.coordinator_normal,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_laughing,
            R.drawable.coordinator_normal,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_normal,
            R.drawable.coordinator_normal
    };

    final int[] greetings_img_part2 = {
            R.drawable.coordinator_comehere,
            R.drawable.coordinator_comehere,
            R.drawable.coordinator_laughing,
            R.drawable.coordinator_laughing,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_comehere,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_comehere_bad,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_normal,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_laughing,
            R.drawable.coordinator_normal,
            R.drawable.coordinator_laughing,
            R.drawable.coordinator_comehere_bad,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_comehere,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_surprised,
            R.drawable.coordinator_haaa,
            R.drawable.coordinator_laughing,
            R.drawable.coordinator_surprised
    };

    private static final ArrayList<int[]> anime_nameData = new ArrayList<>();
    private static final ArrayList<int[]> cardsData = new ArrayList<>();
    private static final ArrayList<int[]> character_namesData = new ArrayList<>();

    private static final ArrayList<int[]> test_imgData = new ArrayList<>();
    private static final ArrayList<int[]> first_qData = new ArrayList<>();
    private static final ArrayList<int[]> second_qData = new ArrayList<>();
    private static final ArrayList<int[]> third_qData = new ArrayList<>();
    private static final ArrayList<int[]> fourth_qData = new ArrayList<>();

    private static final ArrayList<int[]> textData = new ArrayList<>();
    private static final ArrayList<int[]> imageData = new ArrayList<>();

    public static void init() {
        //empty array for filling the gaps
        final int[] empty = {};

        //------------------------------------------------------------------------------------------

        //arrays for senen lvl_1
        final int[] sen_animenames1 = {
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3
        };

        final int[] sen_img1 = {
                R.drawable.noragami,
                R.drawable.promised_neverland,
                R.drawable.doctor_stone,
                R.drawable.jojo,
                R.drawable.tokyo_gul,
                R.drawable.stray_dogs,
                R.drawable.shield_hero,
                R.drawable.soma,
                R.drawable.seven_sins,
                R.drawable.mob
        };

        final int[] sen_fiq1 = {
                R.string.lvl3_noragami,
                R.string.lvl3_promise_for_blue_sky,
                R.string.lvl3_doctor_ramune,
                R.string.lvl3_sinbad_adventures,
                R.string.lvl3_tokyo_gul,
                R.string.lvl3_dog_me_and_secret_job,
                R.string.lvl3_hero_with_enemy,
                R.string.lvl3_cooker_of_heaven_hotel,
                R.string.lvl3_seven_sins,
                R.string.lvl3_monster
        };

        final int[] sen_seq1 = {
                R.string.lvl3_nice_to_meet_u_kami_sama,
                R.string.lvl3_promised_neverland,
                R.string.lvl3_doctor_for_monster_girls,
                R.string.lvl3_aleinas_trip,
                R.string.lvl3_tokyo_mew,
                R.string.lvl3_stray_dogs,
                R.string.lvl3_heroes_of_forgiveness_times,
                R.string.lvl3_cafe_from_different_world,
                R.string.lvl3_seven_yamato,
                R.string.lvl3_mob,
        };

        final int[] sen_thq1 = {
                R.string.lvl3_goddess_student,
                R.string.lvl3_morning_with_promises_flowers,
                R.string.lvl3_doctor_stone,
                R.string.lvl3_cinema_trip,
                R.string.lvl3_tokyo_ravens,
                R.string.lvl3_legend_of_eight_dogs,
                R.string.lvl3_shield_hero,
                R.string.lvl3_koizumi_loves_ramen,
                R.string.lvl3_seven_idols,
                R.string.lvl3_psychopass
        };

        final int[] sen_foq1 = {
                R.string.lvl3_momo_goddess_of_death,
                R.string.lvl3_deadman_wonderland,
                R.string.lvl3_medical_jacks_cards,
                R.string.lvl3_jojo,
                R.string.lvl3_tokyo_school_of_death,
                R.string.lvl3_dogs_voise_in_darkness,
                R.string.lvl3_heroes_of_six_colors,
                R.string.lvl3_soma,
                R.string.lvl3_seven_pleyadas,
                R.string.lvl3_psycho_girlfriend
        };



        //array for novel_lvl1
        final int[] novel_lvl1_txt = {
                R.string.lvl1_novel1,
                R.string.lvl1_novel2,
                R.string.lvl1_novel3,
                R.string.lvl1_novel4,
                R.string.lvl1_novel5,
                R.string.lvl1_novel6,
                R.string.lvl1_novel7,
                R.string.lvl1_novel8,
                R.string.lvl1_novel9,
                R.string.lvl1_novel10,
                R.string.lvl1_novel11,
                R.string.lvl1_novel12,
                R.string.lvl1_novel13,
                R.string.lvl1_novel14,
                R.string.lvl1_novel15,
                R.string.lvl1_novel16
        };

        final int[] novel_lvl1_img = {
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_2,
                R.drawable.senen_lecture_5,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_6,
                R.drawable.senen_lecture_7,
                R.drawable.senen_lecture_5,
                R.drawable.senen_lecture_8,
                R.drawable.senen_lecture_9,
                R.drawable.senen_lecture_3,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_11,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_8,
                R.drawable.senen_lecture_5,
                R.drawable.senen_lecture_10
        };

        //------------------------------------------------------------------------------------------

        //arrays for senen lvl_2
        final int[] sen_animenames2 = {
                R.string.lvl1_MyHeroAcademia,
                R.string.lvl1_AttackOnTitan,
                R.string.lvl1_HunterXHunter,
                R.string.lvl1_AkameGaKill,
                R.string.lvl1_DemonSlayer,
                R.string.lvl1_BlueExorcist,
                R.string.lvl1_Haikyuu,
                R.string.lvl1_OwariNoSeraf,
                R.string.lvl1_MasamuneNoRevenge,
                R.string.lvl1_Bakuman
        };

        final int[] sen_images2 = {
                R.drawable.onelvl_bakugo,
                R.drawable.onelvl_midoria,
                R.drawable.onelvl_eren,
                R.drawable.onelvl_levi,
                R.drawable.onelvl_killua,
                R.drawable.onelvl_gon,
                R.drawable.onelvl_akame,
                R.drawable.onelvl_tatsumi,
                R.drawable.onelvl_tanjiro,
                R.drawable.onelvl_giu,
                R.drawable.onelvl_yukio,
                R.drawable.onelvl_rin,
                R.drawable.onelvl_hinata,
                R.drawable.onelvl_kageyama,
                R.drawable.onelvl_yuichiro,
                R.drawable.onelvl_mikaela,
                R.drawable.onelvl_aki,
                R.drawable.onelvl_masamune,
                R.drawable.onelvl_moritaka,
                R.drawable.onelvl_akito
        };

        final int[] sen_texts2 = {
                R.string.lvl1_bakugo,
                R.string.lvl1_midoria,
                R.string.lvl1_eren,
                R.string.lvl1_levi,
                R.string.lvl1_killua,
                R.string.lvl1_gon,
                R.string.lvl1_akame,
                R.string.lvl1_tatsumi,
                R.string.lvl1_tanjiro,
                R.string.lvl1_giu,
                R.string.lvl1_yukio,
                R.string.lvl1_rin,
                R.string.lvl1_hinata,
                R.string.lvl1_kageyama,
                R.string.lvl1_yuichiro,
                R.string.lvl1_mikaela,
                R.string.lvl1_aki,
                R.string.lvl1_masamune,
                R.string.lvl1_moritaka,
                R.string.lvl1_akito
        };

        //array for novel_lvl2
        final int[] novel_lvl2_txt = {
                R.string.lvl3_novel1,
                R.string.lvl3_novel2,
                R.string.lvl3_novel3,
                R.string.lvl3_novel4,
                R.string.lvl3_novel5,
                R.string.lvl3_novel6,
                R.string.lvl3_novel7,
                R.string.lvl3_novel8,
                R.string.lvl3_novel9,
                R.string.lvl3_novel10,
                R.string.lvl3_novel11
        };

        final int[] novel_lvl2_img = {
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_2,
                R.drawable.senen_lecture_3,
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_2,
                R.drawable.senen_lecture_3,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_5,
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_5
        };

        //------------------------------------------------------------------------------------------

        //arrays for senen lvl_3
        final int[] sen_animenames3 = {
                R.string.lvl2_SteinsGates,
                R.string.lvl2_ReZero,
                R.string.lvl2_Naruto,
                R.string.lvl2_SoulEater,
                R.string.lvl2_SAO,
                R.string.lvl2_Overlord,
                R.string.lvl2_AssassinationClassroom,
                R.string.lvl2_Danganronpa,
                R.string.lvl2_Apocrypha,
                R.string.lvl2_UQHolder
        };

        final int[] sen_images3 = {
                R.drawable.twolvl_maho,
                R.drawable.twolvl_ruka,
                R.drawable.twolvl_felix,
                R.drawable.twolvl_krush,
                R.drawable.twolvl_suiren,
                R.drawable.twolvl_haku,
                R.drawable.twolvl_maka,
                R.drawable.twolvl_hrona,
                R.drawable.twolvl_kirito,
                R.drawable.twolvl_sinon,
                R.drawable.twolvl_aura,
                R.drawable.twolvl_mare,
                R.drawable.twolvl_nagisa,
                R.drawable.twolvl_kaede,
                R.drawable.twolvl_chihiro,
                R.drawable.twolvl_monaka,
                R.drawable.twolvl_archer,
                R.drawable.twolvl_raider,
                R.drawable.twolvl_tokisaka,
                R.drawable.twolvl_yukihime
        };

        final int[] sen_texts3 = {
                R.string.lvl2_maho,
                R.string.lvl2_ruka,
                R.string.lvl2_felix,
                R.string.lvl2_krush,
                R.string.lvl2_suiren,
                R.string.lvl2_haku,
                R.string.lvl2_maka,
                R.string.lvl2_hrona,
                R.string.lvl2_kirito,
                R.string.lvl2_sinon,
                R.string.lvl2_aura,
                R.string.lvl2_mare,
                R.string.lvl2_nagisa,
                R.string.lvl2_kaede,
                R.string.lvl2_chihiro,
                R.string.lvl2_monaka,
                R.string.lvl2_archer,
                R.string.lvl2_raider,
                R.string.lvl2_tokisaka,
                R.string.lvl2_yukihime
        };


        //array for novel_lvl3
        final int[] novel_lvl3_txt = {
                R.string.lvl2_novel1,
                R.string.lvl2_novel2,
                R.string.lvl2_novel3,
                R.string.lvl2_novel4,
                R.string.lvl2_novel5,
                R.string.lvl2_novel6,
                R.string.lvl2_novel7,
                R.string.lvl2_novel8,
                R.string.lvl2_novel9,
                R.string.lvl2_novel10,
                R.string.lvl2_novel11
        };

        final int[] novel_lvl3_img = {
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_2,
                R.drawable.senen_lecture_3,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_5,
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_2,
                R.drawable.senen_lecture_3,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_5,
                R.drawable.senen_lecture_1
        };

        //------------------------------------------------------------------------------------------

        //arrays for senen lvl_4
        final int[] sen_animenames4 = {
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3,
                R.string.anime_name3
        };

        final int[] sen_img4 = {
                R.drawable.astra_in_cosmos,
                R.drawable.champlu_samurai,
                R.drawable.city_where_u_live,
                R.drawable.insects_destroyers,
                R.drawable.login_horizont,
                R.drawable.onmyoji_stars,
                R.drawable.psionic_saiki_kusuo,
                R.drawable.stop_this_sound,
                R.drawable.trigun,
                R.drawable.slime_rebirth
        };

        final int[] sen_fiq4 = {
                R.string.lvl4_astra_in_cosmos,
                R.string.lvl4_samurais_willed,
                R.string.lvl4_yet_city_moves,
                R.string.lvl4_assassination_classroom,
                R.string.lvl4_login_horizont,
                R.string.lvl4_first_stars,
                R.string.lvl4_different_side_of_glass,
                R.string.lvl4_sounds_of_glass,
                R.string.lvl4_trigun,
                R.string.lvl4_unemployed_reincarnation
        };

        final int[] sen_seq4 = {
                R.string.lvl4_space_stellvia,
                R.string.lvl4_champlu_samurai,
                R.string.lvl4_city_where_no_me,
                R.string.lvl4_goblin_slayer,
                R.string.lvl4_horizon_on_the_border_of_emptiness,
                R.string.lvl4_onmyoji_stars,
                R.string.lvl4_makross_delta,
                R.string.lvl4_clear_sound,
                R.string.lvl4_mobile_warrior_gandam,
                R.string.lvl4_slime_rebirth
        };

        final int[] sen_thq4 = {
                R.string.lvl4_moon_mile,
                R.string.lvl4_seven_samurais,
                R.string.lvl4_city_where_u_live,
                R.string.lvl4_akame_ga_kill,
                R.string.lvl4_border_of_emptiness,
                R.string.lvl4_sky_where_stars_met,
                R.string.lvl4_psionic_saiki_kusuo,
                R.string.lvl4_sounds_of_heaven,
                R.string.lvl4_spriggan,
                R.string.lvl4_fist_of_blue_sky
        };

        final int[] sen_foq4 = {
                R.string.lvl4_voice_of_distant_star,
                R.string.lvl4_afrosamurai,
                R.string.lvl4_disappeared_town,
                R.string.lvl4_insects_destroyers,
                R.string.lvl4_girls_conquer_new_horizons,
                R.string.lvl4_stars_blink_together,
                R.string.lvl4_google_it_kokkuri,
                R.string.lvl4_stop_this_sound,
                R.string.lvl4_danganronpa,
                R.string.lvl4_villain_reincarnation
        };


        //array for novel_lvl4
        final int[] novel_lvl4_txt = {
                R.string.lvl4_novel1,
                R.string.lvl4_novel2,
                R.string.lvl4_novel3,
                R.string.lvl4_novel4,
                R.string.lvl4_novel5,
                R.string.lvl4_novel6,
                R.string.lvl4_novel7,
                R.string.lvl4_novel8,
                R.string.lvl4_novel9,
                R.string.lvl4_novel10,
                R.string.lvl4_novel11
        };

        final int[] novel_lvl4_img = {
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_2,
                R.drawable.senen_lecture_3,
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_2,
                R.drawable.senen_lecture_3,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_5,
                R.drawable.senen_lecture_1,
                R.drawable.senen_lecture_4,
                R.drawable.senen_lecture_5
        };

        //------------------------------------------------------------------------------------------


        anime_nameData.addAll(Arrays.asList(sen_animenames1, sen_animenames2, sen_animenames3, sen_animenames4));
        cardsData.addAll(Arrays.asList(empty, sen_images2, sen_images3, empty));
        character_namesData.addAll(Arrays.asList(empty, sen_texts2, sen_texts3, empty));

        test_imgData.addAll(Arrays.asList(sen_img1, empty, empty, sen_img4));
        first_qData.addAll(Arrays.asList(sen_fiq1, empty, empty, sen_fiq4));
        second_qData.addAll(Arrays.asList(sen_seq1, empty, empty, sen_seq4));
        third_qData.addAll(Arrays.asList(sen_thq1, empty, empty, sen_thq4));
        fourth_qData.addAll(Arrays.asList(sen_foq1, empty, empty, sen_foq4));

        textData.addAll(Arrays.asList(novel_lvl1_txt, novel_lvl2_txt, novel_lvl3_txt, novel_lvl4_txt));
        imageData.addAll(Arrays.asList(novel_lvl1_img, novel_lvl2_img, novel_lvl3_img, novel_lvl4_img));
    }

    public static int[] getAnime_nameData(int lvl_num) { return anime_nameData.get(lvl_num); }
    public static int[] getCardsData(int lvl_num) {
        return cardsData.get(lvl_num);
    }
    public static int[] getCharacter_namesData(int lvl_num) {
        return character_namesData.get(lvl_num);
    }

    public static int[] getTestImgData(int lvl_num) { return test_imgData.get(lvl_num); }
    public static int[] getFirstQData(int lvl_num) { return first_qData.get(lvl_num); }
    public static int[] getSecondQData(int lvl_num) { return second_qData.get(lvl_num); }
    public static int[] getThirdQData(int lvl_num) { return third_qData.get(lvl_num); }
    public static int[] getFourthQData(int lvl_num) { return fourth_qData.get(lvl_num); }

    public static int[] getTextData(int window_num) { return textData.get(window_num); }
    public static int[] getIDData(int window_num) {
        return imageData.get(window_num);
    }
}
