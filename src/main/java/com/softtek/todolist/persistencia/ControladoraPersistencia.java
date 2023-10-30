
package com.softtek.todolist.persistencia;

import com.softtek.todolist.logica.Tarea;
import com.softtek.todolist.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    TareaJpaController tareaJpa = new TareaJpaController();

    public void agregarTarea(Tarea nuevaT) {
        
        tareaJpa.create(nuevaT);
        
    }


    public List<Tarea> traerTarea() {
        return tareaJpa.findTareaEntities();
    }

    public void borrarTarea(int idTarea) {
        
        //con este try intenta eliminar y si no puede porque el id no existe, nos permite seguir sin que caiga el programa
        try {
            tareaJpa.destroy(idTarea);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tarea traerTareas(int idTarea) {
        return tareaJpa.findTarea(idTarea);
    }

    public void modificarTarea(Tarea tarea) {
        try {
            tareaJpa.edit(tarea);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
