package dominicpfeifer.srl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lernen extends AppCompatActivity {
    private Button btn_1er;
    private Button btn_2er;
    private Button btn_3er;
    private Button btn_4er;
    private Button btn_5er;
    private Button btn_6er;
    private Button btn_7er;
    private Button btn_8er;
    private Button btn_9er;
    private Button btn_10er;

    private void reset() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lernen);
        btn_1er = (Button) findViewById(R.id.btn_1er);
        btn_2er = (Button) findViewById(R.id.btn_2er);
        btn_3er = (Button) findViewById(R.id.btn_3er);
        btn_4er = (Button) findViewById(R.id.btn_4er);
        btn_5er = (Button) findViewById(R.id.btn_5er);
        btn_6er = (Button) findViewById(R.id.btn_6er);
        btn_7er = (Button) findViewById(R.id.btn_7er);
        btn_8er = (Button) findViewById(R.id.btn_8er);
        btn_9er = (Button) findViewById(R.id.btn_9er);
        btn_10er = (Button) findViewById(R.id.btn_10er);
        final Intent i = new Intent(Lernen.this, Lernen_reihen.class);


        btn_1er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "1");
                String reihe = "1";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_2er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "2");
                String reihe = "2";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_3er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "3");
                String reihe = "3";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_4er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "4");
                String reihe = "4";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_5er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "5");
                String reihe = "5";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_6er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "6");
                String reihe = "6";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_7er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "7");
                String reihe = "7";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_8er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "8");
                String reihe = "8";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_9er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "9");
                String reihe = "9";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
        btn_10er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("reihe", "10");
                String reihe = "10";
                i.putExtra("reihe", reihe);
                startActivity(i);
            }
        });
    }

}
