package com.AluraChallengeLiteratura.LiterAlura.service;

import org.springframework.stereotype.Service;
import com.AluraChallengeLiteratura.LiterAlura.model.Autor;
import com.AluraChallengeLiteratura.LiterAlura.model.Libros;
import com.AluraChallengeLiteratura.LiterAlura.repository.AutorRepository;
import com.AluraChallengeLiteratura.LiterAlura.repository.LibrosRepository;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class LibroService {

    private final LiterAluraService literService;
    private final LibrosRepository librosRepository;
    private final AutorRepository autorRepository;

    public LibroService(LiterAluraService literService,
                        LibrosRepository librosRepository,
                        AutorRepository autorRepository) {

        this.literService = literService;
        this.librosRepository = librosRepository;
        this.autorRepository = autorRepository;
    }

    // -------------------------------------------------------------------------
    // BUSCAR POR TÍTULO
    // -------------------------------------------------------------------------
    public Libros buscarYGuardar(String titulo) {
        String json = literService.BuscarLibroPorTitulo(titulo);

        JSONObject jsonObj = new JSONObject(json);
        JSONArray resultados = jsonObj.getJSONArray("results");

        if (resultados.isEmpty()) {
            System.out.println("No se encontró el libro.");
            return null;
        }

        JSONObject libroJson = resultados.getJSONObject(0);

        return guardarLibroDesdeJSON(libroJson);
    }

    // -------------------------------------------------------------------------
    // BUSCAR POR ID CORREGIDO
    // -------------------------------------------------------------------------
    public Libros buscarYGuardarPorId(int id) {
        String json = literService.BuscarLibroPorID(id);

        JSONObject jsonObj = new JSONObject(json);
        JSONArray resultados = jsonObj.getJSONArray("results");

        if (resultados.isEmpty()) {
            System.out.println("No se encontró el libro con el ID " + id);
            return null;
        }

        JSONObject libroJson = resultados.getJSONObject(0);

        return guardarLibroDesdeJSON(libroJson);
    }

    // -------------------------------------------------------------------------
    // MÉTODO REUTILIZABLE QUE GUARDA EL LIBRO Y EL AUTOR
    // -------------------------------------------------------------------------
    private Libros guardarLibroDesdeJSON(JSONObject libroJson) {

        String nombreLibro = libroJson.getString("title");
        String idioma = libroJson.getJSONArray("languages").getString(0);
        int descargas = libroJson.getInt("download_count");

        JSONObject autorJson = libroJson.getJSONArray("authors").getJSONObject(0);
        String nombreAutor = autorJson.getString("name");
        Integer nacimiento = autorJson.optInt("birth_year", 0);
        Integer fallecimiento = autorJson.optInt("death_year", 0);

        Autor autor = new Autor(nombreAutor, nacimiento, fallecimiento);
        autorRepository.save(autor);

        Libros libro = new Libros(nombreLibro, idioma, descargas, autor);
        librosRepository.save(libro);

        System.out.println("Libro guardado: " + nombreLibro);
        return libro;
    }
}
