package pe.edu.upeu.registro;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import pe.edu.upeu.registro.bean.Person;
import pe.edu.upeu.registro.dao.PersonDAO;

public class VistaMVC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_mvc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TableLayout tlListPerson = (TableLayout) findViewById(R.id.tlListPerson);

        PersonDAO dao = new PersonDAO(this);

        List<Person> list = dao.findPersonAll();
        for(Person person: list){
            TableRow tw01=new TableRow(this);
            TextView tv01=new TextView(this);
            tv01.setText(person.getName());
            tw01.addView(tv01);

            TextView tv02=new TextView(this);
            tv02.setText(person.getLastNameF());
            tw01.addView(tv02);

            EditText et01=new EditText(this);
            et01.setTag(person.getLastNameM());
            tw01.addView(et01);

            tlListPerson.addView(tw01);
        }

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
