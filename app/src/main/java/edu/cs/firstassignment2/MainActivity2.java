package edu.cs.firstassignment2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.List;

import edu.cs.firstassignment2.model.Food;
import edu.cs.firstassignment2.model.FoodFactory;
import edu.cs.firstassignment2.model.IFoodDa;

public class MainActivity2 extends AppCompatActivity {
    Spinner spinner;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner= (Spinner) findViewById(R.id.spinFood);
        spinner.setPrompt("➕ Add Food");
        btn=findViewById(R.id.btnDone);
        saveData();
        loadData2ToSpinner();
    }

    public void saveData(){
        FoodFactory foodFactory = new FoodFactory();
        IFoodDa foodDa = foodFactory.getModel();
        List<Food> foods = foodDa.getFoods();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();

        String foodString1=gson.toJson(foods);
        editor.putString("Data1", foodString1);
        editor.commit();
    }

    public void loadData2ToSpinner(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("Data1", "");

        Food[] foodFoods = gson.fromJson(str, Food[].class);
        String []foodNames=new String[foodFoods.length];
        int i=0;
        for (Food f:
                foodFoods) {
            foodNames [i]=f.getFoodName();
            i++;
        }

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, foodNames);
        spinner.setAdapter(arrayAdapter);


    }

    public void donOnClick(View view) {
        Intent intent = new Intent(this, MainActivity3.class);

        String item= spinner.getSelectedItem().toString();
        intent.putExtra("data",item);
        //startActivityForResult(intent,1);
        startActivity(intent);
    }


  /*  @Override
    public void onActivityResult(int requestCode, int resultCode,  Intent data) {

        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String n=data.getStringExtra("dataM");
            Log.i("MyApp", "res is "+n);
           /* ListView list = findViewById(R.id.listBreakFast);
            ArrayList<String> arr = new ArrayList<>();
            arr.add(data.getData().toString());
            ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
            list.setAdapter(arrayAdapter);
        }
    }*/
}