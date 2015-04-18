package gamejam.liu.se.tammytherabbit;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by golen on 2015-04-17.
 */
public class Rabbit implements View.OnClickListener {
    private Activity parent;
    public Rabbit(Activity parent) {
        this.parent = parent;
    }

    @Override
    public void onClick(View v) {
        Log.d("MainActivity", "Play with my rabbit");
        Animation shake = AnimationUtils.loadAnimation(parent, R.anim.shake);
        parent.findViewById(R.id.rabbitButton).startAnimation(shake);
    }
}
