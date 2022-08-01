package br.com.fiap.epictaskapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.epictaskapi.model.Task;

@Service
public class TaskService {

    public List<Task> listAll() {
        //Mock
        List<Task> lista = new ArrayList<>();
        lista.add(new Task("Modelar o DB", "Definir as tabelas"));
        lista.add(new Task("Prototipo", "Prototipo da GUI"));

        return lista;

    }
    
}
