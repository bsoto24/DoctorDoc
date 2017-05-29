package com.doctordocplus.doctordoc.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doctordocplus.doctordoc.R;
import com.doctordocplus.doctordoc.data.entity.PreguntaTO;

import java.util.ArrayList;

public class PreguntasAdapter extends RecyclerView.Adapter<PreguntasAdapter.PreguntaViewHolder> {


    private ArrayList<PreguntaTO> data;
    private Context context;

    public PreguntasAdapter(ArrayList<PreguntaTO> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public PreguntaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pregunta, parent, false);
        PreguntaViewHolder holder = new PreguntaViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PreguntaViewHolder holder, int position) {
        holder.tvPregunta.setText(data.get(position).getPregunta());
        holder.tvRespuesta.setText(data.get(position).getRespuesta());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PreguntaViewHolder extends RecyclerView.ViewHolder {

        TextView tvPregunta;
        TextView tvRespuesta;

        public PreguntaViewHolder(View itemView) {
            super(itemView);
            tvPregunta = (TextView) itemView.findViewById(R.id.tv_pregunta);
            tvRespuesta = (TextView) itemView.findViewById(R.id.tv_respuesta);
        }
    }
}
