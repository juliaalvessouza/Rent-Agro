package com.example.rentagro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rentagro.R;
import com.example.rentagro.helper.ConfigFirebase;
import com.example.rentagro.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class EntrarActivity extends AppCompatActivity {
    private EditText email, senha;
    private Button btn_entrar;
    private Usuario usuario;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);

        TextView btn_politicas = findViewById(R.id.activity_entrar_politicas);
        btn_politicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPoliticas = new Intent(EntrarActivity.this, PoliticaPrivacidadeActivity.class);
                startActivity(intentPoliticas);
            }
        });


        TextView btn_cadastrar = findViewById(R.id.activity_entrar_cadastro);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadastro = new Intent(EntrarActivity.this, CadastroActivity.class);
                startActivity(intentCadastro);
            }
        });
        email = findViewById(R.id.activity_entrar_text_email);
        senha = findViewById(R.id.activity_entrar_text_senha);
        btn_entrar = findViewById(R.id.activity_entrar_btn_entrar);
        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textEmail = email.getText().toString();
                String textSenha = senha.getText().toString();
                if(!textEmail.isEmpty()){
                    if(!textSenha.isEmpty()){
                        usuario = new Usuario();
                        usuario.setEmail(textEmail);
                        usuario.setSenha(textSenha);
                        validarLogin();

                    }else{
                        Toast.makeText(EntrarActivity.this,
                                "Preencha a senha!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(EntrarActivity.this,
                            "Preencha o email!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void validarLogin(){
        auth = ConfigFirebase.getFirebaseAuth();
        auth.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    abrirTelaPrincipal();
                }else {
                    String excecao ="";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Usuário não cadastrado!";
                    }catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Email e senha não corresponde ao cadastro do usuário";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(EntrarActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void abrirTelaPrincipal(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}