package com.example.test_quiz.Splash_Activity;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.example.test_quiz.Chat_Section.Chat_Handler;
import com.example.test_quiz.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashAnimation extends AwesomeSplash {

    private boolean isAdmin = false;
    @Override
    public void initSplash(ConfigSplash configSplash) {

        isAdmin = getIntent().getBooleanExtra("ChatAdmin",false);
        configSplash.setBackgroundColor(R.color.colorPrimary);
        configSplash.setAnimCircularRevealDuration(300);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);

        configSplash.setLogoSplash(0);
        configSplash.setAnimLogoSplashDuration(0);
        configSplash.setAnimLogoSplashTechnique(Techniques.Bounce);

        configSplash.setOriginalHeight(400);
        configSplash.setOriginalWidth(400);
        configSplash.setAnimPathStrokeDrawingDuration(0);
        configSplash.setPathSplashStrokeSize(3);
        configSplash.setPathSplashStrokeColor(R.color.btn_logout_bg);
        configSplash.setAnimPathFillingDuration(500);
        configSplash.setPathSplashFillColor(R.color.strokeColor);

        configSplash.setTitleSplash("");
        configSplash.setTitleTextColor(R.color.btn_logout_bg);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(0);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
    }

    @Override
    public void animationsFinished() {

        Intent intent = new Intent(SplashAnimation.this, Chat_Handler.class);
        intent.putExtra("ChatAdmin",isAdmin);
        startActivity(intent);
        finish();
    }
}
