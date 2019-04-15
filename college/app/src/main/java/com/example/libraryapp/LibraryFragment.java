package com.example.libraryapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class LibraryFragment extends Fragment {
    public TextView bookid, bookname, Author;
    public Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final JSONParser parser = new JSONParser();
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        bookid = (TextView) view.findViewById(R.id.bookidtxt);
        bookname = (TextView) view.findViewById(R.id.booknametxt);
        Author = (TextView) view.findViewById(R.id.Authortxt);
        button = (Button) view.findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Object obj = parser.parse(new FileReader("C:\\xampp\\htdocs\\data.json"));

                    JSONObject jsonObj = (JSONObject) obj;
                    //Log.i("jsonobject", "jsonObject");

                    int bkid = (int) jsonObj.get("bookid");
                    //Log.i("bookid", "bookid");
                    bookid.setText("12");

                    String bkname = (String) jsonObj.get("bookname");
                    //Log.i("bookname", "Bookname");
                    bookname.setText("abc");

                    String Auth = (String) jsonObj.get("Author");
                    //Log.i("Author", "Author");
                    Author.setText("Rk");

         /*   // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });







        return view;
    }


}
