package com.example.atividade_firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Date;
import java.util.Calendar;

public class RegistrarTarefa extends AppCompatActivity {

    private FirebaseFirestore db;
    private EditText editTitulo;
    private EditText editCategoria;
    private Spinner spinPrioridade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tarefa);

        editTitulo = findViewById(R.id.editTitulo);
        spinPrioridade = findViewById(R.id.prioridade);
        editCategoria = findViewById(R.id.editCategoria);
    }

    @Override
    protected void onStart(){
        super.onStart();
        db = FirebaseFirestore.getInstance();
    }

    public void salvarTarefa(View view) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String titulo = editTitulo.getText().toString();
        String prioridade = spinPrioridade.getSelectedItem().toString();
        String categoria = editCategoria.getText().toString();
        Date dataCriacao = Calendar.getInstance().getTime();
        Tarefa tarefa = new Tarefa(titulo,categoria,prioridade, dataCriacao);

        db.collection("usuarios").document(user.getEmail()).collection("tarefas").add(tarefa).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(RegistrarTarefa.this,"Tarefa cadastrada!",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegistrarTarefa.this,"Falha em cadastrar tarefa!",Toast.LENGTH_SHORT).show();
            }
        });

        Intent retornar = new Intent(RegistrarTarefa.this, DashActivity.class);
        startActivity(retornar);
        finish();
    }
}
