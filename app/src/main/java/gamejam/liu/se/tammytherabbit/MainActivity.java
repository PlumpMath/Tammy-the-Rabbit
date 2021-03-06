package gamejam.liu.se.tammytherabbit;

import android.app.IntentService;
import android.content.Intent;
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
    private Rabbit rabbit = new Rabbit(this);
    private TimeConnection tc = new TimeConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, Time.class);
        this.startService(intent);
        this.bindService(intent, tc, BIND_AUTO_CREATE);

        buttonEat = (Button) findViewById(R.id.buttonEat);
        buttonEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "EAAAT");
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

                displayShit(1); // TODO: Fix IPC with Time.
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
        touchRabbit.setOnClickListener(rabbit);
    }

    private void displayShit(int numberOfShits){
        for (int i = 0; i < numberOfShits; i++){
            // TODO: Implement the display of crap on the screen.
        }
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
