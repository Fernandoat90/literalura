package com.AluraChallengeLiteratura.LiterAlura.repository;

import com.AluraChallengeLiteratura.LiterAlura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libros,Long> {
}
