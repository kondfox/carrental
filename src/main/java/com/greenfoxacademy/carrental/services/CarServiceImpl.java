package com.greenfoxacademy.carrental.services;

import com.greenfoxacademy.carrental.models.Car;
import com.greenfoxacademy.carrental.models.BrandCount;
import com.greenfoxacademy.carrental.models.CarStat;
import com.greenfoxacademy.carrental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

  private CarRepository carRepository;

  @Autowired
  public CarServiceImpl(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Override
  public List<Car> findAll() {
    return carRepository.findAll();
  }

  @Override
  public List<String> brandList() {
    return Arrays.asList("Audi", "Porsche", "Suzuki", "Opel");
  }

  @Override
  public Car save(Car car) {
    return carRepository.save(car);
  }

  @Override
  public List<CarStat> countBrands() {
    List<BrandCount> brandCounts = carRepository.brandCounts();
    return brandCounts.stream()
            .map(brandCount -> new CarStat(brandCount.getBrand(), brandCount.getCount()))
            .collect(Collectors.toList());
  }

  @Override
  public String mostFrequentBrand() {
    return carRepository.mostFrequentBrand();
  }

  @Override
  public void delete(Integer id) {
    carRepository.deleteById(id);
  }

}
