/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.musica.controller;

import com.example.musica.model.Musica;
import com.example.musica.service.MusicaService;
import com.example.musica.service.listaReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author arons
 */
@RestController
@RequestMapping("/api/musica")
public class musicaController {
    
    
    @Autowired
    MusicaService musicaSer;
    
    @Autowired
    listaReproduccionService listaSer;
    
    
    @PostMapping("/crearMusica")
    public Musica crear( @RequestBody Musica musica){
        return musicaSer.crear(musica);
    }
    
    
    
    
    
    
}
