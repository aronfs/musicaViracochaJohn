/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.musica.controller;

import com.example.musica.model.ListaReproducion;
import com.example.musica.model.Musica;
import com.example.musica.service.listaReproduccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author arons
 */
@RestController
@RequestMapping("/api/listaReproduccion")
public class listaReproduccionController {

    @Autowired
     listaReproduccionService Service;

    @GetMapping("/mostrar")
    public List<ListaReproducion> mostrar(){
        return Service.findByAll();
    }
    
    @PostMapping("/crearListaReproduccion")
    public ResponseEntity<ListaReproducion> crear (@RequestBody ListaReproducion p, @RequestBody Musica musica){
        return new ResponseEntity<>(Service.crear(p, musica), HttpStatus.CREATED);
    }
    
    @GetMapping("/buscarListaReproduccion/{id}")
    public ResponseEntity<ListaReproducion> buscar (@PathVariable Integer id){
        return new ResponseEntity<>(Service.findById(id), HttpStatus.OK);
    }
    
    @PutMapping("/actualizarListaReproduccion/{id}")
    public ResponseEntity<ListaReproducion> actualizar(@PathVariable Integer id, @RequestBody ListaReproducion per, @RequestBody Musica musica){
        ListaReproducion lista = buscarPorID(id);
        
        if(lista == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
               lista.setDescripcion(per.getDescripcion());
               lista.setNombre(per.getNombre());
                return new ResponseEntity<>(Service.crear(lista,musica), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
   
    public ListaReproducion buscarPorID(Integer id){
        return Service.findById(id);
    }
    
    @DeleteMapping("/eliminarlistaReproduccion/{id}")
    public ResponseEntity<ListaReproducion> eliminar(@PathVariable Integer id){
        Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    


    
}
