package pe.edu.upeu.registro;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.registro.bean.Person;

public class ContactActivity extends AppCompatActivity {

    public static List<Person> listPerson = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView=(ListView)findViewById(R.id.listView);

        listPerson.add(new Person(1,"Omar","Calsin","Curo","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        listPerson.add(new Person(2,"Juan","Perez","Perez","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        listPerson.add(new Person(3,"Lesly","Aguilar","Chaguares","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        listPerson.add(new Person(4,"Jose Manuel","Limachi","Chavez","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));

        PersonaListAdapter adapter = new PersonaListAdapter(this,listPerson);

        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
