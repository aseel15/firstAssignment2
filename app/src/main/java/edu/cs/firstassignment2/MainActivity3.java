package edu.cs.firstassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.cs.firstassignment2.model.Food;
import edu.cs.firstassignment2.model.FoodFactory;
import edu.cs.firstassignment2.model.IFoodDa;

public class MainActivity3 extends AppCompatActivity {
    TextView txtName;
    Food f=new Food();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        String item = intent.getStringExtra("data");
        populateData(item);


    }
    public void populateData(String item){
        FoodFactory foodFactory = new FoodFactory();
        IFoodDa foodDa = foodFactory.getModel();
        List<Food> foods = foodDa.getFoods();
        f = foodDa.getFoodObj(item);
        txtName = findViewById(R.id.txtNameContent);
        txtName.setText(f.getFoodName());
        ImageView img = findViewById(R.id.imgContent);
        int imgResource=getResources().getIdentifier("@drawable/"+f.getImgUrl(),null,this.getPackageName());
        img.setImageResource(imgResource);

    }


    public void btnDoneOnClick(View view) {
        EditText num=findViewById(R.id.edtNum);
        int n = Integer.parseInt(String.valueOf(num.getText()));
        ListView listView=findViewById(R.id.listView);
        ArrayList<String>arr=new ArrayList<>();
        arr.add("Cal:\t"+(n*f.getNumOfCal()));
        arr.add("Carb:\t"+(n*f.getCarb()));
        arr.add("Fat:\t"+(n*f.getFat()));
        arr.add("Protein:\t"+(n*f.getProtein()));
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        listView.setAdapter(arrayAdapter);

    }

    public void btnBackOnClick(View view) {
       finish();
    }


}