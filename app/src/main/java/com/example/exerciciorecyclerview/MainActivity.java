package com.example.exerciciorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editarTextoNome;
    private Button botaoAdicionar;
    private RecyclerView recyclerView;
    private List<NameItem> listaDeNomes;
    private NameAdapter nameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editarTextoNome = findViewById(R.id.editarTextoNome);
        editarTextoNome.setSingleLine(true);
        botaoAdicionar = findViewById(R.id.botaoAdicionar);
        recyclerView = findViewById(R.id.recyclerView);

        listaDeNomes = new ArrayList<>();

        // Configurar o adaptador
        nameAdapter = new NameAdapter(listaDeNomes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(nameAdapter);

        botaoAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String name = editarTextoNome.getText().toString().trim();
                if (!name.isEmpty())
                {
                    listaDeNomes.add(new NameItem(name));
                    nameAdapter.notifyDataSetChanged();
                    editarTextoNome.setText("");
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence mensagem = "Texto em branco não é permitido";
                    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}