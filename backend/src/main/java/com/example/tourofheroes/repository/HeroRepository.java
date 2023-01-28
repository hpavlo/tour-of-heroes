package com.example.tourofheroes.repository;

import com.example.tourofheroes.model.Hero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    List<Hero> findAllByNameContains(String name);
}
