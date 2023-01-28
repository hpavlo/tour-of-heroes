package com.example.tourofheroes.controller;

import com.example.tourofheroes.dto.HeroRequestDto;
import com.example.tourofheroes.dto.HeroResponseDto;
import com.example.tourofheroes.dto.mapper.HeroMapper;
import com.example.tourofheroes.model.Hero;
import com.example.tourofheroes.service.HeroService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {
    private final HeroService heroService;
    private final HeroMapper heroMapper;

    public HeroController(HeroService heroService, HeroMapper heroMapper) {
        this.heroService = heroService;
        this.heroMapper = heroMapper;
    }

    @PostMapping
    public HeroResponseDto add(@RequestBody HeroRequestDto heroRequestDto) {
        Hero hero = heroMapper.toModel(heroRequestDto);
        return heroMapper.toDto(heroService.add(hero));
    }

    @PutMapping("/{id}")
    public HeroResponseDto update(@PathVariable Long id,
                                  @RequestBody HeroRequestDto heroRequestDto) {
        Hero hero = heroMapper.toModel(heroRequestDto);
        hero.setId(id);
        return heroMapper.toDto(heroService.update(hero));
    }

    @GetMapping("/{id}")
    public HeroResponseDto get(@PathVariable Long id) {
        return heroMapper.toDto(heroService.get(id));
    }

    @GetMapping
    public List<HeroResponseDto> getAll() {
        return heroService.getAll()
                .stream()
                .map(heroMapper::toDto)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        heroService.delete(id);
    }

    @GetMapping("/search")
    public List<HeroResponseDto> search(@RequestParam String name) {
        return heroService.search(name)
                .stream()
                .map(heroMapper::toDto)
                .toList();
    }
}
