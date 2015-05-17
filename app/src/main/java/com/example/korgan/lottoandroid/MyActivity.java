package com.example.korgan.lottoandroid;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.lottoAndroid.MESSAGE";

    /*
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    */

    Button mButton;
    EditText mEdit;
    EditText mEdit1;
    EditText mEdit2;
    EditText mEdit3;
    EditText mEdit4;
    EditText mEdit5;
    EditText mEdit6;
    TextView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

       final List<Integer> lottoLista = new ArrayList<Integer>();

        mButton = (Button)findViewById(R.id.button);
        mEdit = (EditText)findViewById(R.id.edit_message0);
        mEdit1 = (EditText)findViewById(R.id.edit_message1);
        mEdit2 = (EditText)findViewById(R.id.edit_message2);
        mEdit3 = (EditText)findViewById(R.id.edit_message3);
        mEdit4 = (EditText)findViewById(R.id.edit_message4);
        mEdit5 = (EditText)findViewById(R.id.edit_message5);
        mEdit6 = (EditText)findViewById(R.id.edit_message6);
        myList = (TextView)findViewById(R.id.lottoList);


            mButton.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view)
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


                          StringBuilder builder = new StringBuilder();
                          for (int lottoNumerot: lottoLista)
                            {
                                 builder.append(lottoNumerot);
                                 myList.setText(builder.toString());


                            }


                        }
                    });
    }

    public void countLotto()
    {

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
