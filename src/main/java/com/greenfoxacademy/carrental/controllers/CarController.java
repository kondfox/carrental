package com.greenfoxacademy.carrental.controllers;

import com.greenfoxacademy.carrental.models.Car;
import com.greenfoxacademy.carrental.models.BrandCount;
import com.greenfoxacademy.carrental.models.CarStat;
import com.greenfoxacademy.carrental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {

  private CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("/")
  public String renderMainPage(Model model) {
    List<Car> cars = carService.findAll();
    model.addAttribute("cars", cars);
    model.addAttribute("brandCounts", carService.countBrands());
    model.addAttribute("mostFrequentBrand", carService.mostFrequentBrand());
    return "index";
  }

  @GetMapping("/new-car")
  public String renderNewCarPage(Model model) {
    model.addAttribute("brands", carService.brandList());
    return "newCar";
  }

  @PostMapping("/new-car")
  public String saveNewCar(@ModelAttribute Car car) {
    carService.save(car);
    return "redirect:/";
  }

  @PostMapping("/cars/{id}/delete")
  public String deleteCar(@PathVariable Integer id) {
    carService.delete(id);
    return "redirect:/";
  }

}
