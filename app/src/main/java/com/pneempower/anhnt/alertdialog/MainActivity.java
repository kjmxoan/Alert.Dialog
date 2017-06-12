package com.pneempower.anhnt.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvDialog;
    ArrayList<String> arrayName;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDialog = (ListView) findViewById(R.id.LvDialog);
        arrayName = new ArrayList<>();
        Addadapter();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayName);
        lvDialog.setAdapter(adapter);

        lvDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                XacNhanXoa(position);
            }
        });
    }

    private void XacNhanXoa(final int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo !");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn có muốn xóa !");
        alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayName.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }

    private void Addadapter() {

        arrayName.add("Android");
        arrayName.add("IOS");
        arrayName.add("PHP");
        arrayName.add(".NET");
        arrayName.add("C#");
        arrayName.add("NodeJS");
        arrayName.add("ASP.NET");
    }
}
