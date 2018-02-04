package dominicpfeifer.srl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Highscore extends AppCompatActivity {

    private TextView txtEnde;
    private TextView txtHighscore;
    private int punkte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        txtEnde = (TextView) findViewById(R.id.txtEnde);
        txtEnde.setText("Leider ist es zu ende! Vielleicht schaffst du beim nächsten mal mehr Punkte!");

        txtHighscore = (TextView) findViewById(R.id.txtHighscore);

        int value = 0;
        Intent intent = getIntent();
        value = intent.getIntExtra("highscore",0);

        txtHighscore.setText("Dein Higscore war diesmal: " + value);


    }


}
