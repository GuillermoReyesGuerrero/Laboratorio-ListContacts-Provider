package com.example.guillermo.laboratorio_proveedor_contactos;

import android.content.ContentProvider;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listacont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listacont = findViewById(R.id.listcontacts);

        Cursor mCursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        startManagingCursor(mCursor);

        String[] from= {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};

        int [] to = {android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter listadapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,mCursor,from,to);
        listacont.setAdapter(listadapter);
        listacont.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }
}
