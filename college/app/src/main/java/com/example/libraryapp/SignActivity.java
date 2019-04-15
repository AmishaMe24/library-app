package com.example.libraryapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignActivity extends AppCompatActivity implements View.OnClickListener {

        private EditText editTextUsername, editTextPassword, editTextEmail;
        private Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextUsername = (EditText)findViewById(R.id.editTextUsername);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
    }
    private void registerUser(){
       final String email = editTextEmail.getText().toString().trim();
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        StringRequest  stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
            /**
             * Returns a Map of parameters to be used for a POST or PUT request.  Can throw
             * {@link AuthFailureError} as authentication may be required to provide these values.
             *
             * <p>Note that you can directly override {@link #getBody()} for custom data.</p>
             *
             * @throws AuthFailureError in the event of auth failure
             */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("username",username);
                params.put("email",email);
                params.put("password",password);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


    }

    @Override
    public void onClick(View v) {
        if (v == buttonRegister)
            registerUser();
    }
}
