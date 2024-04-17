package demo.Invernadero.lalo.dto;


public class Verreportedto {
    private Long id_reporte;
    private String fecha;
    private String hora;
    private String observaciones;

    public Verreportedto(Long id_reporte, String fecha, String hora, String observaciones) {
        this.id_reporte = id_reporte;
        this.fecha = fecha;
        this.hora = hora;
        this.observaciones = observaciones;
    }

    public Long getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(Long id_reporte) {
        this.id_reporte = id_reporte;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
