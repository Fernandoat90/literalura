package com.AluraChallengeLiteratura.LiterAlura.repository;

import com.AluraChallengeLiteratura.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
