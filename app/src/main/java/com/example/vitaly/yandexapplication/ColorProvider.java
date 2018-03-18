package com.example.vitaly.yandexapplication;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by vitaly on 19.03.18.
 */

public class ColorProvider {

    public static Random random = new Random();
    public static int[] colors = new int[]{ Color.WHITE, Color.GRAY, Color.YELLOW };

    public static int getRandomColor() {
        return colors[random.nextInt(colors.length)];
    }

}
