package com.example.rentagro.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.rentagro.R;
import com.example.rentagro.model.Maquina;
import com.example.rentagro.util.ResourceUtil;

import org.w3c.dom.Text;

import static com.example.rentagro.ui.Constantes.CHAVE;

public class ResumoMaquinaActivity extends AppCompatActivity {

    public TextView telefone;

    public static final String TITLE_APP_BAR = "Resumo Maquina";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_maquina);
        setTitle(TITLE_APP_BAR);
        carregaMaquinaRecebida();
        abrirTelefone();

        TextView termo_uso = findViewById(R.id.activity_resumo_maquina_termo);
        termo_uso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResumoMaquinaActivity.this,
                        PoliticaPrivacidadeActivity.class);
                startActivity(i);
            }
        });
    }

    private void abrirTelefone() {
        telefone = findViewById(R.id.activity_resumo_maquina_telefone);
        telefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if (ActivityCompat.checkSelfPermission(ResumoMaquinaActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ResumoMaquinaActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, 123);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + telefone.getText()));
                    startActivity(intent);
                }
                return;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_resumo_activity_maquina_voltar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_resumo_maquina_item_voltar:
                Intent intent= new Intent(ResumoMaquinaActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void carregaMaquinaRecebida() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE)) {
            final Maquina maquina = (Maquina) intent.getSerializableExtra(CHAVE);
            inicializaCampos(maquina);
        }
    }

    private void inicializaCampos(Maquina maquina) {
        mostraNome(maquina);
        mostraImagem(maquina);
        mostraDias(maquina);
        mostraPreco(maquina);
        mostraTelefone(maquina);
    }

    private void mostraPreco(Maquina maquina) {
        TextView preco = findViewById(R.id.activity_resumo_maquina_valor);
        preco.setText(maquina.getPreco());
    }

    private void mostraDias(Maquina maquina) {
        TextView dias = findViewById(R.id.activity_resumo_maquina_text_dias);
        dias.setText(maquina.getDias());
    }

    private void mostraImagem(Maquina maquina) {
        ImageView imagem = findViewById(R.id.activity_resumo_maquina_image_maquina);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, maquina.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraNome(Maquina maquina) {
        TextView nome = findViewById(R.id.activity_resumo_maquina_text_nome);
        nome.setText(maquina.getNome());
    }

    private void mostraTelefone(Maquina maquina) {
        telefone = findViewById(R.id.activity_resumo_maquina_telefone);
        telefone.setText(maquina.getTelefone());

    }
}
