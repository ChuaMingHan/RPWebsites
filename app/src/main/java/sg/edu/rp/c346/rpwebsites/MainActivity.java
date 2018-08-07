package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnGo;

    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        alNumbers = new ArrayList<>();
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        spn2.setAdapter(aaNumbers);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] strNumbers;
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                switch (i){
                    case 0:
                        strNumbers = getResources().getStringArray(R.array.subcategory1);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(0);

                        btnGo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view){
                                int pos = spn2.getSelectedItemPosition();
                                alNumbers.clear();

                                if(pos == 0){
                                    String url = getResources().getString(R.string.homepage);
                                    Intent intent = new Intent(getBaseContext(), Webpage.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                } else {
                                    String url = getResources().getString(R.string.studentlife);
                                    Intent intent = new Intent(getBaseContext(), Webpage.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                }
                            }

                        });

                        break;
                    case 1:
                        strNumbers = getResources().getStringArray(R.array.subcategory2);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(0);

                        btnGo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view){
                                int pos = spn2.getSelectedItemPosition();
                                alNumbers.clear();

                                if(pos == 0){
                                    String url = getResources().getString(R.string.DMSD);
                                    Intent intent = new Intent(getBaseContext(), Webpage.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                } else {
                                    String url = getResources().getString(R.string.DIT);
                                    Intent intent = new Intent(getBaseContext(), Webpage.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                }
                            }

                        });

                        break;
                }
                aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });
    }
}
