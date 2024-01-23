package com.example.listsandadapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private StateAdapter adapter;
    private RecyclerView recyclerView;

    ArrayList<State> states = new ArrayList<State>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();

        RecyclerView recyclerView = findViewById(R.id.list);
        StateAdapter adapter = new StateAdapter(this, states);
        recyclerView.setAdapter(adapter);
        recyclerView = findViewById(R.id.list);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setInitialData(){
        states.add(new State ("Астра", "Астра новобельгийска - многолетнее травянистое растение. В высоту может достигать 60 см.", R.drawable.astra));
        states.add(new State ("Азалия", "Азалия PERSIL - невероятно красивоцветущий кустарник. Зацветает раньше распускания листвы (в конце мая - начале июня) многочисленными  крупными, в форме чаши или колокольчика, белоснежными с ярким золотым пятном цветами.", R.drawable.azal));
        states.add(new State ("Орхидея", "Орхидея Цимбидиум - многолетняя красивоцветущая орхидея с удлиненными килеватыми листьями и крупными цветками, собранными в многоцветковые соцветия.", R.drawable.orhidei));
        states.add(new State ("Пион", "Пион Лоллипоп - необычный пестрый сорт! Соцветия приятного светло-желтого цвета. На лепестках будто разбрызганы красно-фиолетовые мазки. На высоком, округлом кусте появляется много боковых бутонов. Пион-ИТО Лоллипоп - это настоящее произведение искусства!", R.drawable.pion));
        states.add(new State ("Роза", "Чайно-гибридная роза - любое, даже скупое и краткое описание чайно-гибридных роз позволяет считать этих  королев цветочного мира  общепризнанным эталоном великолепия, изящества и красоты.", R.drawable.roza));

        for (State state : states) {
            state.setQuantity(0);
        }
    }
}
