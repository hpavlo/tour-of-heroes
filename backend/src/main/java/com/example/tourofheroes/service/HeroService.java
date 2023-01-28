package com.example.tourofheroes.service;

import com.example.tourofheroes.model.Hero;
import java.util.List;

public interface HeroService {
    Hero add(Hero hero);

    Hero update(Hero hero);

    Hero get(Long id);

    List<Hero> getAll();

    void delete(Long id);

    List<Hero> search(String name);
}
