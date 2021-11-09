package edu.cs.firstassignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.List;

import edu.cs.firstassignment2.model.User;
import edu.cs.firstassignment2.model.UserFactory;
import edu.cs.firstassignment2.model.IUserDa;

public class MainActivity1 extends AppCompatActivity {
   EditText edtName;
   EditText edtWeight;
   EditText edtHeight;
   RadioGroup radioGroup;
   RadioButton radioButton;
   CheckBox ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        edtName=findViewById(R.id.edtName);
        edtHeight=findViewById(R.id.edtHeight);
        edtWeight=findViewById(R.id.edtWeight);
        radioGroup=findViewById(R.id.radioGroup);
        ch=findViewById(R.id.txtRememberMe);
    }

    public void saveData(View view) {
      if(ch.isChecked()) {
          UserFactory UserFactory = new UserFactory();
          IUserDa UserDa = UserFactory.getModel();
          List<User> Users = UserDa.getUsers();
          int selected = radioGroup.getCheckedRadioButtonId();
          radioButton = (RadioButton) findViewById(selected);
          String str = radioButton.getText().toString();

          Users.add(new User(edtName.getText().toString(), edtWeight.getText().toString(), edtHeight.getText().toString(), str));
          SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
          SharedPreferences.Editor editor = sharedPreferences.edit();

          Gson gson = new Gson();

          String UserString1 = gson.toJson(Users);
          editor.putString("Data1", UserString1);
          editor.commit();
      }
    }

    public void getDataOnclick(View view) {
        if(ch.isChecked()){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("Data1", "");
            User[] users = gson.fromJson(str, User[].class);

            Toast.makeText(this, users[0].getName()+"\n"+
                            users[0].getHeight()+"\n"+users[0].getWeight()+
                            "\n"+users[0].getGender()
                           , Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "there is no data saved", Toast.LENGTH_SHORT).show();
        }

    }
    public void nextOnclick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }




}