package com.example.korgan.lottoandroid;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;





public class MyActivity extends ActionBarActivity {


    final List<Integer> lottoLista = new ArrayList<Integer>();
    final List<Integer> arvottuLista = new ArrayList<Integer>();
    LottoArvontaTaustalla lotto = new LottoArvontaTaustalla();
    Button mButton;
    Button cancel;
    EditText mEdit;
    EditText mEdit1;
    EditText mEdit2;
    EditText mEdit3;
    EditText mEdit4;
    EditText mEdit5;
    EditText mEdit6;
    TextView myList;
    TextView randomList;


    private class LottoArvontaTaustalla extends AsyncTask<Void, Integer, Void> {

        boolean jatketaankoLaskua = true;
        int arvonnat = 0;
        int miljoonat = 0;
        @Override
        protected Void doInBackground(Void... params) {
            Random rand = new Random();
            while(arvottuLista.size() < 7)
             {
             arvottuLista.add(rand.nextInt(39));
             }
            Collections.sort(arvottuLista);
            Collections.sort(lottoLista);
            while(jatketaankoLaskua == true)
             {
                arvonnat++;

                if(arvonnat == 1000000)
                {
                    miljoonat++;
                    publishProgress(miljoonat);
                    arvonnat = 0;
                }

                if (lottoLista.equals(arvottuLista))
                {
                    jatketaankoLaskua = false;

                }
                 else{
                    arvottuLista.clear();
                    while(arvottuLista.size() < 7)
                    {
                        arvottuLista.add(rand.nextInt(39));
                    }
                    Collections.sort(arvottuLista);
                }
            }
            return null;
        }

        protected void onProgressUpdate(Integer... progress)
        {
            randomList.setText(progress[0].toString());

        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
           Paahtoleipa.p(MyActivity.this, "Voitit lotossa, onneksi olkoon!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);



        mButton = (Button)findViewById(R.id.button);
        cancel = (Button)findViewById(R.id.cancel);
        mEdit = (EditText)findViewById(R.id.edit_message0);
        mEdit1 = (EditText)findViewById(R.id.edit_message1);
        mEdit2 = (EditText)findViewById(R.id.edit_message2);
        mEdit3 = (EditText)findViewById(R.id.edit_message3);
        mEdit4 = (EditText)findViewById(R.id.edit_message4);
        mEdit5 = (EditText)findViewById(R.id.edit_message5);
        mEdit6 = (EditText)findViewById(R.id.edit_message6);

        myList = (TextView)findViewById(R.id.lottoList);
        randomList = (TextView) findViewById(R.id.randomLottoList);

    }

    public void nappiPainallus(View view)
    {

        final int arvo1 = Integer.parseInt(mEdit.getText().toString());
        final int arvo2 = Integer.parseInt(mEdit1.getText().toString());
        final int arvo3 = Integer.parseInt(mEdit2.getText().toString());
        final int arvo4 = Integer.parseInt(mEdit3.getText().toString());
        final int arvo5 = Integer.parseInt(mEdit4.getText().toString());
        final int arvo6 = Integer.parseInt(mEdit5.getText().toString());
        final int arvo7 = Integer.parseInt(mEdit6.getText().toString());

        lottoLista.add(arvo1);
        lottoLista.add(arvo2);
        lottoLista.add(arvo3);
        lottoLista.add(arvo4);
        lottoLista.add(arvo5);
        lottoLista.add(arvo6);
        lottoLista.add(arvo7);
        lotto.execute();

    }

    public void cancelCalculation(View view)
    {
        lotto.cancel(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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
