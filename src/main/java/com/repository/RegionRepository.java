package com.repository;

import com.domain.Region;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Michał on 2016-12-05.
 */
public interface RegionRepository extends CrudRepository<Region, Long> {
}
