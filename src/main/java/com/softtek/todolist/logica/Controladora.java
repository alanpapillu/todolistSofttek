
package com.softtek.todolist.logica;
import com.softtek.todolist.persistencia.ControladoraPersistencia;
import java.util.List;


//esta clase se encarga de recibir las peticiones de la interfaz gráfica
public class Controladora {
    
    ControladoraPersistencia controladoraPersis = new ControladoraPersistencia();
    
    

    public void agregarTarea(String descripcion, String prioridad) {
        
        //Creo el objeto Tarea
        Tarea nuevaT = new Tarea();
        

        nuevaT.setDescripcion(descripcion);
        nuevaT.setPrioridad(prioridad);
        
        controladoraPersis.agregarTarea(nuevaT);

    }

    public List<Tarea> traerTareas() {
        
        return controladoraPersis.traerTarea();
        
    }

    public void borrarTarea(int idTarea) {
        controladoraPersis.borrarTarea(idTarea);
    }

    public Tarea traerTarea(int idTarea) {
        return controladoraPersis.traerTareas(idTarea);
    }

    public void modificarTarea(Tarea tarea, String descripcion, String prioridad) {
        
        tarea.setDescripcion(descripcion);
        tarea.setPrioridad(prioridad);
        
        //ordeno a la persistencia que lo modifique
        controladoraPersis.modificarTarea(tarea);
        
        
    }


    
}
