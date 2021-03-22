package com.springboot.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.domaine.Response;
import com.springboot.demo.model.Animals;
import com.springboot.demo.repository.AnimalsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/animal")
public class AnimalsController {
	@Autowired
	AnimalsRepository animalsRepository;
	
	@Autowired
	ServletContext context;
	
	@PostMapping("/create")
	public Animals postAnimals(@RequestBody Animals animals) {		
		Animals _animals = animalsRepository.save(new Animals(animals.getImage(), animals.getName(), animals.getActive(), animals.getBread()));
		return _animals;
	}
	
	@PostMapping("/saveAnimal")
	public ResponseEntity<Response> saveanimalprofile(@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name) throws IOException {

		Animals animals = new ObjectMapper().readValue(name, Animals.class);
		animals.setImage(file.getOriginalFilename());
		Animals dbanimals = animalsRepository.save(animals);
		if (dbanimals != null) {
			return new ResponseEntity<Response>(new Response("Animals is saved sucessfully"), HttpStatus.OK);
		}else {
			return new ResponseEntity<Response>(new Response("Animal is not saved"), HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/getAnimal/{id}")
	public ResponseEntity<Animals> getAnimalById(@PathVariable("id") long id){
		Optional<Animals> animalData = animalsRepository.findById(id);
		
		if(animalData.isPresent()) {
			return new ResponseEntity<>(animalData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAnimal")
	public ResponseEntity<List<Animals>> getAllAnimals(@RequestParam(required = false) String name) {
		try {
			List<Animals> animals = new ArrayList<Animals>();
			if(name == null) {
				animalsRepository.findAll().forEach(animals::add);
			}else {
				animalsRepository.findByNameContaining(name).forEach(animals::add);
			}
			if(animals.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(animals, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Animals> deleteAnimals(@PathVariable("id") long id) {
		System.out.println("Delete Animals with id = " + id + "....");
		animalsRepository.deleteById(id);

		return new ResponseEntity<Animals>(HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Animals> updateAnimals(@PathVariable("id") long id, @RequestBody Animals animals) {
		System.out.println("Update Animal with id = " + id + "...");
		Optional<Animals> animalData = animalsRepository.findById(id);

		if (animalData.isPresent()) {
			Animals _animals = animalData.get();
			_animals.setImage(animals.getImage());
			_animals.setName(animals.getName());
			_animals.setActive(animals.getActive());
			_animals.setBread(animals.getBread());
			return new ResponseEntity<>(animalsRepository.save(_animals), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
