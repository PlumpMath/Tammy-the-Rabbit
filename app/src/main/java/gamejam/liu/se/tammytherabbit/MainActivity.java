package gamejam.liu.se.tammytherabbit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    private Button buttonEat;
    private Button buttonClean;
    private Button buttonPay;
    private Button buttonPlay;
    private Button buttonKill;
    private ImageButton touchRabbit;
    private Rabbit rabbit = new Rabbit();

    private Rabbit rabbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rabbit = new Rabbit();

        buttonEat = (Button) findViewById(R.id.buttonEat);
        buttonEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "EAAAT");
                rabbit.eat();
            }
        });

        buttonPay = (Button) findViewById(R.id.buttonPay);
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "PAAY");
            }
        });

        buttonClean = (Button) findViewById(R.id.buttonClean);
        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "CLEAN");
            }
        });

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "PLAAAY");
            }
        });

        buttonKill = (Button) findViewById(R.id.buttonKill);
        buttonKill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "KIIILL");
            }
        });

        touchRabbit = (ImageButton) findViewById(R.id.rabbitButton);
        buttonKill.setOnClickListener(rabbit);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
