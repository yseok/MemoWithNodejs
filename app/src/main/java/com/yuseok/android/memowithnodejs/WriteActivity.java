package com.yuseok.android.memowithnodejs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.yuseok.android.memowithnodejs.domain.Qna;

public class WriteActivity extends AppCompatActivity {

    EditText editTitle, editAuth, editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTitle = (EditText) findViewById(R.id.editTitle);
        editAuth = (EditText) findViewById(R.id.editAuth);
        editContent = (EditText) findViewById(R.id.editContent);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask<String, Void, String> networkTask = new AsyncTask<String, Void, String>() {

                    @Override
                    protected String doInBackground(String... params) {
                        String title = params[0];
                        String name = params[1];
                        String content = params[2];

                        Qna qna = new Qna();
                        qna.setTitle(title);
                        qna.setName(name);
                        qna.setContent(content);

                        Gson gson = new Gson();
                        String jsonString = gson.toJson(qna);

                        String result = Remote.postJson(MainActivity.SITE_URL + "bbs", jsonString);

                        return result;
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        Snackbar.make(view, result, Snackbar.LENGTH_LONG).show();
                    }
                };

                networkTask.execute(editTitle.getText().toString(),
                        editAuth.getText().toString(),
                        editContent.getText().toString());
            }
        });
    }

}
