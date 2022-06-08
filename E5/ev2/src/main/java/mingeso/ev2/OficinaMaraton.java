package mingeso.ev2;

import java.util.ArrayList;
import java.util.List;


public class OficinaMaraton {
    List<Corredor> Corredores;

    // Constructor
    public OficinaMaraton(){
        Corredores = new ArrayList<Corredor>();
    }

    // Getter
    public List<Corredor> getCorredores(){
        return this.Corredores;
    }

    // Methods
    public String calcularCorredorPrimerPuesto(){
        return "";
    }
    public String calcularTiempoPromedioCorredores(){
        return "";
    }
    public String calcularPorcentajeCorredoresQueLlegaronMeta(){
        return "";
    }
    public String calcularPorcentajeCorredoresQueNoCorrieron(){
        return "";
    }
}
