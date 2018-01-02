package com.example.administrator.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button start, cancel;
    ProgressBar progressBar;
    BackgroundTask task;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        start = (Button) findViewById(R.id.startBtn);
        cancel = (Button) findViewById(R.id.stopBtn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               task = new BackgroundTask();
               task.execute(100);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.cancel(true);
            }
        });

    }



    class BackgroundTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            value=0;
            progressBar.setProgress(value);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0].intValue());
            textView.setText("Current Value : "+values[0].intValue());
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            progressBar.setProgress(0);
            textView.setText("Finish");

        }

        @Override
        protected Integer doInBackground(Integer... params) {

            while(value<20) {
                value++;
                publishProgress(value);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {}

            }

            return value;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            progressBar.setProgress(0);
            textView.setText("취소되었습니다.");
        }
    }
}

