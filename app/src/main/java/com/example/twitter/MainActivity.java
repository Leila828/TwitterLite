package com.example.twitter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener  {
    Dialog dialog;
    String text ="";
    ArrayList<Tweet> tweets;
    TweetAdapter adapter;
    ListView mListView;
    FragmentTransaction trans;
    Frag frag;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.List);

        final FrameLayout frameLayout=(FrameLayout) findViewById(R.id.fraglay1);
        final TextView textViewfrag=(TextView)findViewById(R.id.textView2);
        final TextView textView=(TextView)findViewById(R.id.textView2);
        tweets = new ArrayList<Tweet>();
        manager = getSupportFragmentManager();
        frag=(Frag) manager.findFragmentById(R.id.fraglay1);

        trans = manager.beginTransaction();
        //  final TweetAdapter adapter = new TweetAdapter(MainActivity.this, tweets);
        tweets.add(new Tweet("HABIB Lila", "Hello in my twitter",R.drawable.jkhh));
      TweetAdapter adapter = new TweetAdapter(MainActivity.this, tweets);
        mListView.setAdapter(adapter);
        mListView.setOnItemLongClickListener( this);

        int displaymode = getResources().getConfiguration().orientation;

        if (displaymode == Configuration.ORIENTATION_PORTRAIT)
        {

            frameLayout.setVisibility(View.GONE);
        }
      mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
                   {  String text;
                       Intent intent=new Intent(MainActivity.this,Detail.class);
                        text=tweets.get(position).content;
                        intent.putExtra("text",text);
                       startActivity(intent);


                   }
                   else {  frameLayout.setVisibility(View.VISIBLE);
                       text=tweets.get(position).content;
                       Bundle bundle=new Bundle();
                       bundle.putString("name",text);

                       Frag frag=new Frag();
                       frag.setArguments(bundle);
                       FragmentManager fm=getSupportFragmentManager();
                       FragmentTransaction ft=fm.beginTransaction();
                       ft.replace(R.id.fraglay1,frag);
                       ft.commit();

/*
                      //  textView.setText(text);
                       frag=new Frag();
                       TextView textView=(TextView) view.findViewById(R.id.textView2);
                       text=tweets.get(position).content;
//if (frag!=null){
                         frag.getTextView().setText(text);
  //                     frag.setElements(text);}
                       frameLayout.setVisibility(View.VISIBLE);

                       trans.add(R.id.fraglay1, new Frag());

                      // Bundle bundle = new Bundle();
                       //bundle.putString("test",text);

                       //frag.setArguments(bundle);
                       //trans.replace(R.id.fraglay1,frag);
                       trans.commit();

*/
                       Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();


                 //    textViewfrag.setText(text);
                     //  textView.setText(text);

                  //     Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();

                   }

               }
           });

}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogue);
        dialog.setTitle("Création");
        dialog.show();


                Button btnValider = (Button) dialog.findViewById(R.id.dialog_btn_valider);
                btnValider.setOnClickListener(new View.OnClickListener() {
                                                          @Override public void onClick(View v) {

                                                              EditText content=(EditText) dialog.findViewById(R.id.dialog_libelle);
                                                              ListView mListView = (ListView) findViewById(R.id.List);
                                                              tweets.add(new Tweet("HABIB Lila",content.getText().toString(),R.drawable.jkhh));
                                                              adapter = new TweetAdapter(MainActivity.this, tweets);
                                                              mListView.setAdapter(adapter);
                                                              dialog.dismiss();


                                                          }
                                                      });

                return true;



    }


@Override
 public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
        mListView=(ListView) findViewById(R.id.List);
        AlertDialog.Builder confirm = new AlertDialog.Builder(MainActivity.this);
        confirm.setTitle("Suppression");
        confirm.setIcon(android.R.drawable.ic_dialog_alert);
        confirm.setMessage("Vous confirmez la suppression ?");

        confirm.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int idBtn) {
                        tweets.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
        confirm.setNegativeButton(android.R.string.no, null);
        confirm.show();
        return false;}









}

