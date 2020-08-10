package com.kostya_zinoviev.taining_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private  ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setClickable(true);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        final ExampleAsyncTask exampleAsyncTask = new ExampleAsyncTask();
        exampleAsyncTask.execute();
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(0);
                final ExampleAsyncTask2 exampleAsyncTask2 = new ExampleAsyncTask2();
                exampleAsyncTask.execute();
            }
        });

    }
    class ExampleAsyncTask extends AsyncTask<Void,Integer,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Началась загрузка данных");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            int counter = 0;
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++counter;
                publishProgress(counter);
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            textView.setText("Закачек выполнилось, " + "" + values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.setText("Загрузка данных закончилась");
        }

    }
    class ExampleAsyncTask2 extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Началась загрузка данных");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            int counter = 0;
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++counter;
                publishProgress(counter);
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            textView.setText("Закачек выполнилось, " + "" + values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.setText("Загрузка данных закончилась");
        }
    }

}
