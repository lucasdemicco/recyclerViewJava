package com.lucas.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lucas.recyclerview.R;

import java.util.List;

import model.Filme;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        //onCreateViewHolder cria os itens na RecyclerView
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new myViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull Adapter.myViewHolder holder, int position) {
        //onBindViewHolder é quem vai mostrar e reciclar os itens na tela
        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    @Override
    public int getItemCount() {
        //Retorna a quantidade de itens que serão exibidos na tela
        return listaFilmes.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        //Função que busca no XML os itens para exibição

        TextView titulo;
        TextView ano;
        TextView genero;

        public myViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtTitulo);
            ano = itemView.findViewById(R.id.txtAno);
            genero = itemView.findViewById(R.id.txtGenero);
        }
    };
}
