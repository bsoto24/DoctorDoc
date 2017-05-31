package com.doctordocplus.doctordoc.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doctordocplus.doctordoc.R;
import com.doctordocplus.doctordoc.data.entity.CitaTO;

import java.util.ArrayList;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.CitaViewHolder> {

    private ArrayList<CitaTO> data;
    private Context context;
    private String query = "";

    public HistorialAdapter(ArrayList<CitaTO> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public HistorialAdapter.CitaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistorialAdapter.CitaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cita, parent, false));
    }

    @Override
    public void onBindViewHolder(CitaViewHolder holder, int position) {
        final CitaTO cita = data.get(position);
        String name = cita.getPaciente().toLowerCase();
        holder.tvFechaConsulta.setText(cita.getFecha());
        holder.tvHoraConsulta.setText(cita.getHora());
        holder.tvNumConsulta.setText(cita.getNumCita());
        holder.tvPaciente.setText(cita.getPaciente());
        holder.tvEstado.setText(cita.getEstado());

        if (cita.getEstado().equals("Resuelta")) {
            holder.tvEstado.setBackgroundColor(context.getResources().getColor(R.color.secondaryText));
        } else {
            holder.tvEstado.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }

        if (name.contains(query)) {
            int startPos = name.indexOf(query);
            int endPos = startPos + query.length();

            Spannable spanString = Spannable.Factory.getInstance().newSpannable(holder.tvPaciente.getText());
            spanString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.colorAccent)), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.tvPaciente.setText(spanString);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CitaViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNumConsulta;
        private TextView tvFechaConsulta;
        private TextView tvHoraConsulta;
        private TextView tvPaciente;
        private TextView tvEstado;

        public CitaViewHolder(View itemView) {
            super(itemView);
            tvFechaConsulta = (TextView) itemView.findViewById(R.id.tv_fecha);
            tvHoraConsulta = (TextView) itemView.findViewById(R.id.tv_hora);
            tvNumConsulta = (TextView) itemView.findViewById(R.id.tv_num_consulta);
            tvPaciente = (TextView) itemView.findViewById(R.id.tv_paciente);
            tvEstado = (TextView) itemView.findViewById(R.id.tv_estado);

        }
    }

    public void filter(ArrayList data, String query) {
        this.data = data;
        this.query = query;
        notifyDataSetChanged();
    }
}
