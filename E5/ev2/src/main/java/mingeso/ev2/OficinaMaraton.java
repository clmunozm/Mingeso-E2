package mingeso.ev2;

import java.util.ArrayList;


public class OficinaMaraton {
    ArrayList<Corredor> Corredores;

    // Constructor
    public OficinaMaraton(){
    }


    // Methods
    public int calcularTiempo(String checkpoint){
        String unidades[] = new String[3];
        int horas, minutos, segundos, tiempo;
        unidades = checkpoint.split(":");
        horas = Integer.parseInt(unidades[0]);
        minutos = Integer.parseInt(unidades[1]);
        segundos = Integer.parseInt(unidades[2]);
        tiempo = segundos + (minutos*60) + (horas*3600);
        return tiempo;
    }
    public String calcularCorredorPrimerPuesto(ArrayList<Corredor> corredores){
        int termino, minimo, ganador;
        ganador = -1; //Empate
        minimo = calcularTiempo(corredores.get(0).checkPointLlegada);
        for(int i=0; i<corredores.size(); i++){
            termino = calcularTiempo(corredores.get(i).checkPointLlegada);
            if (termino < minimo && termino != 0){
                ganador = i;
                minimo = termino;
            }
        }
        return corredores.get(ganador).nombre;
    }
    public String calcularTiempoPromedioCorredores(ArrayList<Corredor> corredores){
        int termino, tiempo, hora, minutos, segundos;
        String promedio = "";
        tiempo = 0;
        for(int i=0; i<corredores.size(); i++){
            termino = calcularTiempo(corredores.get(i).checkPointLlegada);
            tiempo = tiempo + (termino);
        }
        tiempo = (tiempo/corredores.size());
        hora = tiempo/3600;
        if(hora<10){promedio = "0" + hora + ":";}
        else{promedio = hora + ":";}
        tiempo = tiempo - (hora*3600);
        minutos = tiempo/60;
        if(minutos<10){promedio = promedio + "0" + minutos + ":";}
        else{promedio = promedio + minutos + ":";}
        tiempo = tiempo - (minutos*60);
        segundos = tiempo;
        if(segundos<10){promedio = promedio + "0" + segundos;}
        else{promedio = promedio + segundos;}
        return promedio;
    }
    public double calcularPorcentajeCorredoresQueLlegaronMeta(ArrayList<Corredor> corredores){
        int contador;
        double porcentaje;
        String termino;
        contador = 0;
        for(int i=0; i<corredores.size(); i++){
            termino = corredores.get(i).checkPointLlegada;
            if (termino == "00:00:00" || termino == "NULL" || termino == null){
                contador = contador + 1;
            }
        }
        porcentaje = 100 - (contador*100/corredores.size());
        return porcentaje;
    }
    public double calcularPorcentajeCorredoresQueNoCorrieron(ArrayList<Corredor> corredores){
        int contador;
        double porcentaje;
        String inicio;
        contador = 0;
        for(int i=0; i<corredores.size(); i++){
            inicio = corredores.get(i).checkPointPartida;
            if (inicio == "00:00:00" ||inicio == "NULL" || inicio == null){
                contador = contador + 1;
            }
        }
        porcentaje = contador*100/corredores.size();
        return porcentaje;
    }
}
