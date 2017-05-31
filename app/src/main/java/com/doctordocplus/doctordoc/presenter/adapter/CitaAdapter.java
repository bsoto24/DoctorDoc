package com.doctordocplus.doctordoc.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doctordocplus.doctordoc.R;
import com.doctordocplus.doctordoc.data.entity.CitaTO;

import java.util.List;

/**
 * Created by Bryam Soto on 29/05/2017.
 */

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.CitaViewHolder> {

    private List<CitaTO> citas;
    private Context context;

    public CitaAdapter(List<CitaTO> citas, Context context){
        this.citas = citas;
        this.context = context;
    }

    @Override
    public CitaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cita, parent, false);
        CitaViewHolder holder = new CitaViewHolder(v);
        return holder;
    }

    @Override
    public int getItemCount() {
        return citas.size();
    }

    @Override
    public void onBindViewHolder(CitaViewHolder holder, final int position) {
        final CitaTO cita = citas.get(position);
        holder.tvFechaConsulta.setText(cita.getFecha());
        holder.tvHoraConsulta.setText(cita.getHora());
        holder.tvNumConsulta.setText(cita.getNumCita());
        holder.tvPaciente.setText(cita.getPaciente());

        if (position < 3){
            holder.tvEstado.setText("ESTA SEMANA");
            holder.tvEstado.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }else{
            holder.tvEstado.setText("ESTE MES");
            holder.tvEstado.setBackgroundColor(context.getResources().getColor(R.color.secondaryText));
        }
    }


    public static class CitaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNumConsulta ;
        private TextView tvFechaConsulta ;
        private TextView tvHoraConsulta ;
        private TextView tvPaciente ;
        private TextView tvEstado ;

        public CitaViewHolder(View itemView) {
            super(itemView);
            tvFechaConsulta = (TextView) itemView.findViewById(R.id.tv_fecha);
            tvHoraConsulta = (TextView) itemView.findViewById(R.id.tv_hora);
            tvNumConsulta = (TextView) itemView.findViewById(R.id.tv_num_consulta);
            tvPaciente = (TextView) itemView.findViewById(R.id.tv_paciente);
            tvEstado = (TextView) itemView.findViewById(R.id.tv_estado);

        }
    }
}
