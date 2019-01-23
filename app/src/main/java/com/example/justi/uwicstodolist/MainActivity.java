package com.example.justi.uwicstodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Suggested Ideas to improve app:
 * 1) Add a splash screen to demonstrate intents.
 * 2) Use SharedPreferences to show data persistence.
 */
public class MainActivity extends AppCompatActivity {
    EditText task_input;
    ListView tasks_list;
    ArrayList<String> tasks;
    ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Initalize widgets and other objects.
         * Sets list view to adapter
         */
        tasks=new ArrayList<>();
        task_input=findViewById(R.id.task);
        tasks_list=findViewById(R.id.list);
        mAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, tasks);
        tasks_list.setAdapter(mAdapter);

        /**
         * Checks to see if an item in the list is clicked. If clicked it will be removed from the list and update the view.
         */
        tasks_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tasks.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * When the add task button is clicked this method will take the text from task_input and add it to ArrayList.
     * It also updates and displays new task in the ListView
     */
    public void addTask(View v){
        String new_task=task_input.getText().toString();
        tasks.add(new_task);
        mAdapter.notifyDataSetChanged();
    }
}
