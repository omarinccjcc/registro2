package pe.edu.upeu.registro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.registro.bean.Person;

public class MainActivity extends AppCompatActivity {

    public static List<Person> listPerson = new ArrayList<Person>();

    public int personId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);

        // String[] arrayNombres = {"Omar Calsin Curo","Juan Perez Perez","Elisabeth Choque","Lesly Aguilar","Jose Manuel Limachi"};

        // listPerson.add(new Person(1,"Omar","Calsin","Curo","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        // listPerson.add(new Person(2,"Juan","Perez","Perez","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        // listPerson.add(new Person(3,"Lesly","Aguilar","Chaguares","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        // listPerson.add(new Person(4,"Jose Manuel","Limachi","Chavez","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));

        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(this, layout,listPerson);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = (Person)parent.getItemAtPosition(position);
                personId=person.getId();
                Toast.makeText(MainActivity.this, person.getId()+" Hola: "+person.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRegister();
            }
        });
    }

    public void goRegister(){
        Intent i = new Intent(this,Register.class);
        i.putExtra("personId",0);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_synchronize:
                //Intent i = new Intent(this,Register.class);
                //startActivity(i);
                break;
            case R.id.action_edit:
                Intent i = new Intent(this,Register.class);
                // envia id persona a la otra actividad
                i.putExtra("personId",personId);
                startActivity(i);
                break;
            case R.id.action_about:
                Intent ii = new Intent(this,About.class);
                startActivity(ii);
                break;
        }
        /*
        int id = item.getItemId();
      //noinspection SimplifiableIfStatement
        if (id == R.id.action_new_person) {
            return true;
        }
        if (id == R.id.action_about){

        }
        */
        return super.onOptionsItemSelected(item);
    }
}
