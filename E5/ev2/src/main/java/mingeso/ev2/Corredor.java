package mingeso.ev2;

public class Corredor {

    // Atributos
    String rut;
    String nombre;
    String checkPointPartida; // HH:MM:SS
    String checkPoint1; // HH:MM:SS
    String checkPoint2; // HH:MM:SS
    String checkPointLlegada; // HH:MM:SS

    // Getters and setters
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCheckPointPartida() {
        return checkPointPartida;
    }
    public void setCheckPointPartida(String checkPointPartida) {
        this.checkPointPartida = checkPointPartida;
    }
    public String getCheckPoint1() {
        return checkPoint1;
    }
    public void setCheckPoint1(String checkPoint1) {
        this.checkPoint1 = checkPoint1;
    }
    public String getCheckPoint2() {
        return checkPoint2;
    }
    public void setCheckPoint2(String checkPoint2) {
        this.checkPoint2 = checkPoint2;
    }
    public String getCheckPointLlegada() {
        return checkPointLlegada;
    }
    public void setCheckPointLlegada(String checkPointLlegada) {
        this.checkPointLlegada = checkPointLlegada;
    }

}
