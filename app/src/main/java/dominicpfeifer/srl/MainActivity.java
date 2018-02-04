package dominicpfeifer.srl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;
import android.os.Vibrator;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends Activity  implements
        TextToSpeech.OnInitListener{
//Test Raakulan
    private TextToSpeech tts;
    private Button btnSpeak;
    private Button btnCheck;
    private TextView txtZahl1;
    private TextView txtZahl2;
    private EditText editTextErgebnis;
    private TextView txtPunkte;
    private TextView txtLeben;
    private TextView txtMulti;
    private Vibrator v;
    private int points = 0;
    private int multiplikator = 0;
    private int leben = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, this);
        Log.e("TTS", "in onCreate!");
        btnSpeak = (Button) findViewById(R.id.btnSpeak);
        //btnSpeak.setText("Vorlesen");
        // Ich habe das auskommentiert, da dieser Textview durch ein .png ersetzt wurde @raakulan

        // button on click event
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                calculate();
            }

        });

        txtLeben = (TextView) findViewById(R.id.txtLeben);
        txtPunkte = (TextView) findViewById(R.id.txtPunkte);
        txtMulti = (TextView) findViewById(R.id.txtMulti);

        txtLeben.setText("Leben: " + leben);
        txtPunkte.setText("Punkte: " + points);
        txtMulti.setText("Multiplikator: " + multiplikator);


        btnCheck = (Button)findViewById(R.id.btnCheck);
        //btnCheck.setText("Lösen");
        //siehe zeile 48!
        btnCheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                check();
            }

        });

    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        Log.e("TTS", "in onDestroy!");
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    public void check(){

        editTextErgebnis = (EditText)findViewById(R.id.editTextErgebnis);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        int ergebnis = Integer.parseInt(editTextErgebnis.getText().toString());
        int zahl1 = Integer.parseInt(txtZahl1.getText().toString());
        int zahl2 = Integer.parseInt(txtZahl2.getText().toString());
        int check = zahl1 * zahl2;

        String text;
        long[] pattern = {0, 400, 200, 400, 200, 400 };
        long[] pattern2 = {0,100,100,100};

        if(check == ergebnis){
            text = "YES";
            points++;
            multiplikator++;
            if(points > 1){
                points = points * multiplikator;
            }
            txtPunkte.setText("Punkte: " + points);
            txtMulti.setText("Multiplikator: " + multiplikator);
            editTextErgebnis.setText("");
            calculate();
        }else{
            text = "NO";
            leben--;
            multiplikator = 0;
            txtLeben.setText("Leben: " + leben);
            v.vibrate(pattern2, -1);
            editTextErgebnis.setText("");
            if(leben == 0){
                v.vibrate(pattern, -1);
                Intent intent = new Intent(MainActivity.this,Highscore.class);
                intent.putExtra("highscore",points);
                startActivity(intent);
                //neue activity mit highscore
            }else{
                Context context = getApplicationContext();
                CharSequence text1 = "FALSCH! du hast noch 1 Versuch";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text1, duration);
                toast.show();
            }
        }

        Log.e("TTS", text + " Punkte: " + points + " Leben: " + leben);
    }


    public void calculate(){
        Log.e("TTS", "in calculate!");

        txtZahl1 = (TextView)findViewById(R.id.txtZahl1);
        txtZahl2 = (TextView)findViewById(R.id.txtZahl2);

        int lowerBound = 1;
        int upperBound = 10;
        int zahl1 = new Random().nextInt(upperBound)+lowerBound;
        int zahl2 = new Random().nextInt(upperBound)+lowerBound;

        txtZahl1.setText(zahl1+"");
        txtZahl2.setText(zahl2+"");

        String vorlesen = zahl1 + "mal" + zahl2;
        speakOut(vorlesen);
    }

    @Override
    public void onInit(int status) {
        Log.e("TTS", "in onINIT!");
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.GERMANY);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                //berechne();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    private void speakOut(String vorlesen) {

        String text = vorlesen;
        Log.e("TTS", "in speak!");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }



}
