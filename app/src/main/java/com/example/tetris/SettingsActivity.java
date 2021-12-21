package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        String[] countries = {"en", "ru"};
        Spinner spinner = findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        Locale locale = getResources().getConfiguration().getLocales().get(0);
        int ind = Arrays.asList(countries).indexOf(locale.getLanguage());

        if (ind == -1) {
            spinner.setSelection(0);
        } else {
            spinner.setSelection(ind);
        }

//        TextView landText = findViewById(R.id.textView2);
//        landText.setText(locale.getLanguage());



        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String lang = (String) parent.getItemAtPosition(position);
                Locale locale = new Locale("ru");
                Configuration configuration;
                switch (lang){
                    case "ru":
                        locale = new Locale("ru");
                        break;
                    case "en":
                        locale = new Locale("en");
                        break;
                    default:
                        lang = "";
                        break;
                }
                if (lang.equals("") || getResources().getConfiguration().getLocales().get(0).getLanguage().equals(lang)){
                    return;
                }
                Locale.setDefault(locale);
                configuration = new Configuration();
                configuration.setLocale(locale);
                getBaseContext().getResources().updateConfiguration(configuration, null);
                finish();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }
}