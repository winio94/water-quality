package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Michał on 2016-12-05.
 */
@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "REGION_NAME")
    @NotNull
    private String name;

    @Column(name = "POPULATION")
    @NotNull
    private int population;

    @Column(name = "TERRITORY")
    @NotNull
    private int territory;

    @Column(name = "ECONOMIC_SYSTEM")
    @Enumerated(EnumType.STRING)
    @NotNull
    private EconomySystem economicSystem;

    @Column(name = "REGION_TYPE")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getTerritory() {
        return territory;
    }

    public void setTerritory(int territory) {
        this.territory = territory;
    }

    public EconomySystem getEconomicSystem() {
        return economicSystem;
    }

    public void setEconomicSystem(EconomySystem economicSystem) {
        this.economicSystem = economicSystem;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}