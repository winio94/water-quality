package com.service;

import com.domain.EconomySystem;
import com.domain.Region;
import com.domain.Type;
import com.repository.RegionRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

/**
 * Created by Michał on 2016-12-05.
 */
@Named
public class InitWaterQualityService {

    private static final int MIN_POPULATION = 100_000;
    private static final int MAX_POPULATION = 1_000_000;
    private static final int MIN_TERRITORY = 10_000;
    private static final int MAX_TERRITORY = 1_000_000;
    private final Random random = new Random();
    private final EconomySystem[] economySystems = EconomySystem.values();
    private final Type[] types = Type.values();

    @Inject
    private RegionRepository regionRepository;

    @PostConstruct
    private void postConstruct() {
        initializeRegions();
    }

    private void initializeRegions() {
        regionRepository.save(region("Schlogen", getPopulation(), getEconomySystem(), getTerritory(), getType()));
        regionRepository.save(region("Linz", getPopulation(), getEconomySystem(), getTerritory(), getType()));
        regionRepository.save(region("Enns", getPopulation(), getEconomySystem(), getTerritory(), getType()));
        regionRepository.save(region("Grein", getPopulation(), getEconomySystem(), getTerritory(), getType()));
        regionRepository.save(region("Melk", getPopulation(), getEconomySystem(), getTerritory(), getType()));
        regionRepository.save(region("Krems", getPopulation(), getEconomySystem(), getTerritory(), getType()));
        regionRepository.save(region("Traismauer", getPopulation(), getEconomySystem(), getTerritory(), getType()));
        regionRepository.save(region("Tulln", getPopulation(), getEconomySystem(), getTerritory(), getType()));
        regionRepository.save(region("Vienna", getPopulation(), getEconomySystem(), getTerritory(), getType()));
    }

    private Type getType() {
        return types[random.nextInt(types.length)];
    }

    private EconomySystem getEconomySystem() {
        return economySystems[random.nextInt(economySystems.length)];
    }

    private int getTerritory() {
        return MIN_TERRITORY + random.nextInt(MAX_TERRITORY);
    }

    private int getPopulation() {
        return MIN_POPULATION + random.nextInt(MAX_POPULATION);
    }

    private Region region(String name, int population, EconomySystem economicSystem, int teritory, Type type) {
        Region region = new Region();
        region.setName(name);
        region.setPopulation(population);
        region.setEconomicSystem(economicSystem);
        region.setTerritory(teritory);
        region.setType(type);
        return region;
    }
}