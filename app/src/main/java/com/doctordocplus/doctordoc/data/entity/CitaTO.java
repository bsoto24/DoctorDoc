package com.doctordocplus.doctordoc.data.entity;

/**
 * Created by Bryam Soto on 29/05/2017.
 */

public class CitaTO {
    private String numCita;
    private String fecha;
    private String hora;
    private String paciente;
    private String estado;

    public CitaTO() {
    }

    public CitaTO(String numCita, String fecha, String hora, String paciente, String estado) {
        this.numCita = numCita;
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.estado = estado;
    }

    public String getNumCita() {
        return numCita;
    }

    public void setNumCita(String numCita) {
        this.numCita = numCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CitaTO{" +
                "numCita='" + numCita + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", paciente='" + paciente + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
