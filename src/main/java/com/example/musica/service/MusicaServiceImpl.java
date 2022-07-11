/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.musica.service;

import com.example.musica.dao.musicarepository;
import com.example.musica.model.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arons
 */
@Service
public class MusicaServiceImpl implements MusicaService{

    @Autowired
    private musicarepository musicarepo;
    
    @Override
    public  Musica crear(Musica musica) {
       return musicarepo.save(musica);
    }
    
    
}
