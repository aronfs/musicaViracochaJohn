/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.musica.service;

import com.example.musica.dao.*;
import com.example.musica.model.ListaReproducion;
import com.example.musica.model.Musica;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arons
 */
@Service
public class listaReproduccionServiceImpl implements listaReproduccionService{

    @Autowired
    private listarepository Repository;
    
    @Autowired
    private MusicaService musicaSer;
   
    @Override
    public ListaReproducion crear(ListaReproducion listaReproducion, Musica musica) {
       Repository.findById(listaReproducion.getIdLista()).map((t) -> {
          musica.setIdLista(t);
          return musicaSer.crear(musica);
        });
        return Repository.save(listaReproducion);
    }

    @Override
    public ListaReproducion findById(Integer id) {
        return Repository.findById(id).orElse(null);
    }

    @Override
    public List<ListaReproducion> findByAll() {
     return Repository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Repository.deleteById(id);
    }

 
    
    
}
