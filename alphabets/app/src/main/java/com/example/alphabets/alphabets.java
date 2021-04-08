package com.example.alphabets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class alphabets extends AppCompatActivity {
    String myTitle[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String myDescription[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    int myImage[]={R.drawable.apple,R.drawable.baseball,R.drawable.clock,R.drawable.donkey,R.drawable.elephant,R.drawable.father,R.drawable.grandmother,R.drawable.hungry,R.drawable.internet,R.drawable.justice,R.drawable.kangro,R.drawable.london,R.drawable.monkey,R.drawable.norway,R.drawable.overtime,R.drawable.pillow,R.drawable.question,R.drawable.rab,R.drawable.superman,R.drawable.telephone,R.drawable.uw,R.drawable.vac,R.drawable.www,R.drawable.xp,R.drawable.yogurt,R.drawable.zebra};
    ListView listView;
    ImageView myImg;
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
        listView=findViewById(R.id.myListView);
        //myImg=findViewById(R.id.myimage);
        // myText=findViewById(R.id.myTitle);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myTitle);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent=new Intent( alphabets.this, detail.class);
                Bundle bundle=new Bundle();
                bundle.putInt("images",myImage[i]);
                intent.putExtras(bundle);
                intent.putExtra("title",myTitle[i]);
                intent.putExtra("desc",myDescription[i]);
                startActivity(intent);
            }
        });
    }


}