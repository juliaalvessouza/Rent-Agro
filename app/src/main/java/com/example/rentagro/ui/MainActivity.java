package com.example.rentagro.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rentagro.R;
import com.example.rentagro.adapter.ListaMaquinasAdapter;
import com.example.rentagro.dao.MaquinaDAO;
import com.example.rentagro.helper.Permissao;
import com.example.rentagro.model.Maquina;

import java.util.List;

import static com.example.rentagro.ui.Constantes.CHAVE;

public class MainActivity extends AppCompatActivity {

    private String[] permissoesNecessarias = new String []{
            Manifest.permission.CALL_PHONE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configuraLista();
        setTitle(null);
        Permissao.validarPermissoes(permissoesNecessarias, this, 1 );

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int permissaoResultado : grantResults){
            if(permissaoResultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
    }

    private void alertaValidacaoPermissao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para utilizar o aplicativo com boa performance é necessário aceitar as permissões");
        builder.setCancelable(false);
        builder.setPositiveButton("Confimar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void configuraLista() {
        ListView listaMaquinas = findViewById(R.id.listMaquinas);
        List<Maquina> maquinas = new MaquinaDAO().lista();
        listaMaquinas.setAdapter(new ListaMaquinasAdapter(maquinas, this));
        listaMaquinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Maquina maquinaClicada = maquinas.get(position);
                vaiParaResumoMaquina(maquinaClicada);
            }
        });
    }

    private void vaiParaResumoMaquina(Maquina maquinaClicada) {
        Intent intent = new Intent(MainActivity.this, ResumoMaquinaActivity.class);
        intent.putExtra(CHAVE, maquinaClicada);
        startActivity(intent);
    }
}