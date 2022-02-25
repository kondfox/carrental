package com.greenfoxacademy.carrental.services;

import com.greenfoxacademy.carrental.models.Car;
import com.greenfoxacademy.carrental.models.BrandCount;
import com.greenfoxacademy.carrental.models.CarStat;

import java.util.List;

public interface CarService {

  List<Car> findAll();

  List<String> brandList();

  Car save(Car car);

  List<CarStat> countBrands();

  String mostFrequentBrand();

  void delete(Integer id);

}
