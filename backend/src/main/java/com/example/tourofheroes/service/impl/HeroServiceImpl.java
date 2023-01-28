package com.example.tourofheroes.service.impl;

import com.example.tourofheroes.model.Hero;
import com.example.tourofheroes.repository.HeroRepository;
import com.example.tourofheroes.service.HeroService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;

    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public Hero add(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Hero update(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Hero get(Long id) {
        return heroRepository.getReferenceById(id);
    }

    @Override
    public List<Hero> getAll() {
        return heroRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    @Override
    public List<Hero> search(String name) {
        return heroRepository.findAllByNameContains(name);
    }
}
