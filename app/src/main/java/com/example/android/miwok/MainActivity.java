/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // 给 Numbers 设置监听器
        TextView numbers = findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            /**
             * 点击 Numbers
             * 发送 显式Intent
             * 跳转到 NumbersActivity
             * (将NumbersActivity放到MainActivity上面，通过返回键返回)
             * @param v Numbers按钮
             */
            @Override
            public void onClick(View v) {
                //显式Intent
                Intent intent = new Intent(MainActivity.this,
                        NumbersActivity.class);
                startActivity(intent);
            }
        });

        // 给 Family 设置监听器
        TextView family = findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            /**
             * 点击 Family Members
             * 发送 显式Intent
             * 跳转到 FamilyActivity
             * @param v Family Members按钮
             */
            @Override
            public void onClick(View v) {
                // 显式Intent
                Intent intent = new Intent(MainActivity.this,
                        FamilyActivity.class);
                startActivity(intent);
            }
        });

        // 给 Colors 设置监听器
        TextView colors = findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            /**
             * 点击 Colors
             * 发送 显式Intent
             * 跳转到 ColorsActivity
             * @param v Colors按钮
             */
            @Override
            public void onClick(View v) {
                // 显式Intent
                Intent intent = new Intent(MainActivity.this,
                        ColorsActivity.class);
                startActivity(intent);
            }
        });

        // 给 Phrases 设置监听器
        TextView phrases = findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            /**
             * 点击 Phrases
             * 发送 显式Intent
             * 跳转到 PhrasesActivity
             * @param v Phrases按钮
             */
            @Override
            public void onClick(View v) {
                // 显式Intent
                Intent intent = new Intent(MainActivity.this,
                        PhrasesActivity.class);
                startActivity(intent);
            }
        });

    }

}
