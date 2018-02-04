package dominicpfeifer.srl;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class Lernen_reihen extends AppCompatActivity implements
        TextToSpeech.OnInitListener {
    private final int[] reihe = new int[]{1,2,3,4,5,6,7,8,9,10};
    ArrayList<Integer> ergebnisse;
    private TextToSpeech tts;

    private TextView textView;
    private TextView textView2;
    private TextView erg;
    private TextView currentReihe;

    private Button btn1;
    private Button btn2;
    private Button vorlesen;

    private int current;
    String j = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lernen_reihen);
        ergebnisse = new ArrayList<Integer>();
        tts = new TextToSpeech(this, this);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        erg = (TextView)findViewById(R.id.erg);
        currentReihe = (TextView)findViewById(R.id.currentReihe);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        vorlesen = (Button)findViewById(R.id.vorlesen);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        current = 0;
        if(b!=null)
        {
            j =(String) b.get("reihe");
            textView2.setText(j);
            currentReihe.setText("Wir lernen die: "+j+"er Reihe");
        }
        for(int k=1; k<=reihe.length; k++){
            ergebnisse.add(k*reihe[k-1]);
        }

        textView.setText(reihe[current]+ "");
        erg.setText("1");
        Log.d("Current: ",String.valueOf(current));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current -1>=0){
                    Log.d("Current: ",String.valueOf(current));
                    current = current -1;
                    textView.setText(String.valueOf(reihe[current]));
                    erg.setText(""+reihe[current]*Integer.valueOf(j));
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current +1<=9){
                    Log.d("Current: ",String.valueOf(current));
                    current = current +1;
                    textView.setText(String.valueOf(reihe[current]));
                    erg.setText(""+reihe[current]*Integer.valueOf(j));
                }
            }
        });
        vorlesen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String spk = textView.getText()+ " mal "+textView2.getText()+" gleich "+erg.getText();
                    speakOut(spk);
            }
        });
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
                vorlesen.setEnabled(true);
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
