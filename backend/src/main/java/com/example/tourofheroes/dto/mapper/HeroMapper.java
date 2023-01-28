package com.example.tourofheroes.dto.mapper;

import com.example.tourofheroes.dto.HeroRequestDto;
import com.example.tourofheroes.dto.HeroResponseDto;
import com.example.tourofheroes.model.Hero;
import org.springframework.stereotype.Component;

@Component
public class HeroMapper {
    public Hero toModel(HeroRequestDto heroRequestDto) {
        Hero hero = new Hero();
        hero.setName(heroRequestDto.getName());
        return hero;
    }

    public HeroResponseDto toDto(Hero hero) {
        HeroResponseDto heroResponseDto = new HeroResponseDto();
        heroResponseDto.setId(hero.getId());
        heroResponseDto.setName(hero.getName());
        return heroResponseDto;
    }
}
