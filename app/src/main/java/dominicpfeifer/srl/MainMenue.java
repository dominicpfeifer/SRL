package dominicpfeifer.srl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenue extends AppCompatActivity {

    private Button btnSpielen;
    private Button btnLernen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menue);

        btnSpielen = (Button)findViewById(R.id.btnSpielen);
        btnLernen = (Button)findViewById(R.id.btnLernen);


        btnSpielen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainMenue.this,MainActivity.class);
                startActivity(intent);

            }
        });
        btnLernen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainMenue.this,Lernen.class);
                startActivity(intent);

            }
        });
    }
}
