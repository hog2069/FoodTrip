package com.hog2020.foodtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Tab4ClickActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayAdapter adapter ;
    ListView listView;
    StringBuffer buffer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab4_click);

        listView=findViewById(R.id.listview);
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        Thread thread = new Thread(){
            @Override
            public void run() {
                String address = "http://hog2069.dothome.co.kr/data/data.xml";

                try {
                    URL url = new URL(address);
                    InputStream is = url.openStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xpp =factory.newPullParser();

                    xpp.setInput(isr);

                    int eventType =xpp.getEventType();


                    while(eventType != XmlPullParser.END_DOCUMENT){
                        switch (eventType){
                            case XmlPullParser.START_DOCUMENT:
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                    }
                                });
                                break;
                            case XmlPullParser.START_TAG:
                                String tagname =xpp.getName();
                                if (tagname.equals("item")){
                                    buffer= new StringBuffer();

                                }else if (tagname.equals("name")){
                                    buffer.append("이름: ");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else  if (tagname.equals("food")){
                                    buffer.append("음식: ");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else if (tagname.equals("foodkit")){
                                    buffer.append("종류: ");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else if (tagname.equals("address1")){
                                    buffer.append("주소: ");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else if (tagname.equals("address2")){
                                    buffer.append("상세주소: ");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else if (tagname.equals("metadata")){
                                    buffer.append("설명: ");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");
                                }
                                break;

                            case XmlPullParser.TEXT:
                                break;
                            case XmlPullParser.END_TAG:
                                String tagname2 =xpp.getName();
                                if (tagname2.equals("item")){

                                   arrayList.add(buffer.toString());
                                }
                                break;
                        }
                        eventType=xpp.next();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }
}