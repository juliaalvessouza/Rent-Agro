package com.example.rentagro.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rentagro.R;
import com.example.rentagro.model.Maquina;
import com.example.rentagro.util.DiasUtil;
import com.example.rentagro.util.MoedaUtil;
import com.example.rentagro.util.ResourceUtil;

import java.util.List;

public class ListaMaquinasAdapter extends BaseAdapter {

    private final List<Maquina> maquinas;
    private final Context context;

    public ListaMaquinasAdapter(List<Maquina> maquinas, Context context) {
        this.maquinas = maquinas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return maquinas.size();
    }

    @Override
    public Maquina getItem(int position) {
        return maquinas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_maquina, parent, false);
        Maquina maquina = maquinas.get(position);

        mostraCidade(viewCriada, maquina);
        mostraImagem(viewCriada, maquina);
        mostraDias(viewCriada, maquina);
        mostraPrecos(viewCriada, maquina);
        mostraTelefone(viewCriada, maquina);
        mostraNome(viewCriada, maquina);
//        mostraDescricao(viewCriada, maquina);

        return viewCriada;
    }

    private void mostraNome(View viewCriada, Maquina maquina) {
        TextView nome = viewCriada.findViewById(R.id.item_maquina_text_nome);
        nome.setText(maquina.getNome());
    }

    private void mostraPrecos(View viewCriada, Maquina maquina) {
        TextView preco = viewCriada.findViewById(R.id.item_maquina_text_preco);
        preco.setText(maquina.getPreco());
    }

    private void mostraDias(View viewCriada, Maquina maquina) {
        TextView dias = viewCriada.findViewById(R.id.item_maquina_text_dias);
        dias.setText(maquina.getDias());
    }

    private void mostraImagem(View viewCriada, Maquina maquina) {
        ImageView imagem = viewCriada.findViewById(R.id.item_maquina_image_maquina);
        Drawable drawableImagePAcote = ResourceUtil.devolveDrawable(context, maquina.getImagem());
        imagem.setImageDrawable(drawableImagePAcote);
    }

    private void mostraCidade(View viewCriada, Maquina maquina) {
        TextView local = viewCriada.findViewById(R.id.item_maquina_text_cidade);
        local.setText(maquina.getCidade());
    }

    private void mostraTelefone(View viewCriada, Maquina maquina) {
        TextView telefone = viewCriada.findViewById(R.id.item_maquina_text_telefone);
        telefone.setText(maquina.getTelefone());
    }

//    private void mostraDescricao(View viewCriada, Maquina maquina) {
//        TextView descricao = viewCriada.findViewById(R.id.item_maquina_descricao);
//        descricao.setText(maquina.getDescricao());
//    }
}
