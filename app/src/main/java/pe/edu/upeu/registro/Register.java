package pe.edu.upeu.registro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import pe.edu.upeu.registro.bean.Person;

public class Register extends AppCompatActivity {

    EditText txtNombre;
    EditText txtLastNameF;
    EditText txtLastNameM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtLastNameF = (EditText) findViewById(R.id.txtLastNameF);
        txtLastNameM = (EditText) findViewById(R.id.txtLastNameM);
        Button btnSave = (Button)findViewById(R.id.btnSave);




        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Random rn = new Random();
                int answer = rn.nextInt(1000) + 1;
                MainActivity.listPerson.add(new Person(answer,txtNombre.getText().toString(),txtLastNameF.getText().toString(),txtLastNameM.getText().toString(),"www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
                goMain();
            }
        });
    }

    public void goMain(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_back:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
