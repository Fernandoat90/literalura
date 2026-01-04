package com.AluraChallengeLiteratura.LiterAlura.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name="autores")

public class Autor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;

    private String nombre;
    private Integer birth_year;
    private Integer death_year;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Libros> libros = new ArrayList<>();

    public Autor(){}

    public Autor(String nombre,Integer birth_year,Integer death_year){
        this.nombre=nombre;
        this.birth_year=birth_year;
        this.death_year=death_year;
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Integer getNaci_date() {
            return birth_year;
        }

        public void setNaci_date(Integer birth_year) {
            this.birth_year = birth_year;
        }

        public Integer getDefuncion_date() {
            return death_year;
        }

        public void setDefuncion_date(Integer death_year) {
            this.death_year = death_year;
        }
    }
