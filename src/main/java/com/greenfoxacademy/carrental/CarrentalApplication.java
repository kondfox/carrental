package com.greenfoxacademy.carrental;

import com.greenfoxacademy.carrental.models.Car;
import com.greenfoxacademy.carrental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CarrentalApplication implements CommandLineRunner {

	private CarRepository carRepository;

	@Autowired
	public CarrentalApplication(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarrentalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Car> cars = Arrays.asList(
						new Car("Audi", "A4", 2020, "fekete", 20000),
						new Car("Porsche", "Cayen", 2022, "fehér", 50000),
						new Car("Suzuki", "Swift", 2021, "piros", 10000),
						new Car("Suzuki", "Swift", 2022, "fekete", 10000)
		);
		carRepository.saveAll(cars);
	}
}
