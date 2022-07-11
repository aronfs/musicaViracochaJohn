/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.musica.service;

import com.example.musica.model.ListaReproducion;
import com.example.musica.model.Musica;
import java.util.List;

/**
 *
 * @author arons
 */
public interface listaReproduccionService {

    public ListaReproducion crear(ListaReproducion listaReproducion, Musica musica);

    public ListaReproducion findById(Integer id);

    public List<ListaReproducion> findByAll();
   
    public void delete(Integer id);

}
