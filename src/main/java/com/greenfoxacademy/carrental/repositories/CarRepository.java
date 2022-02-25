package com.greenfoxacademy.carrental.repositories;

import com.greenfoxacademy.carrental.models.Car;
import com.greenfoxacademy.carrental.models.BrandCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {

  List<Car> findAll();

  @Query(value = "SELECT brand, COUNT(brand) AS count FROM cars GROUP BY brand", nativeQuery = true)
  List<BrandCount> brandCounts();

  @Query(value =
          "SELECT brand " +
          "FROM cars " +
          "GROUP BY brand " +
          "ORDER BY COUNT(brand) DESC " +
          "LIMIT 1",
        nativeQuery = true)
  String mostFrequentBrand();

  @Query(value="SELECT manufacturer FROM cars GROUP BY (manufacturer) ORDER BY COUNT(manufacturer) DESC LIMIT 1", nativeQuery=true)
  String findMax();

}
