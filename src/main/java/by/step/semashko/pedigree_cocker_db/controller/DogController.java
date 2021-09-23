package by.step.semashko.pedigree_cocker_db.controller;

import by.step.semashko.pedigree_cocker_db.model.entiy.Dog;
import by.step.semashko.pedigree_cocker_db.model.enums.Colour;
import by.step.semashko.pedigree_cocker_db.service.DogService;
import by.step.semashko.pedigree_cocker_db.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/dogs")
public class DogController {

    private DogService dogService;

    @GetMapping
    public String listDog(Model model){
        List<Dog> dogList = dogService.findAll();
        model.addAttribute("dogs",dogList);
        return "dogs";
    }

    @GetMapping("/personal_dog_page/{id}")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("dog", dogService.findById(id).orElse(new Dog()));
        return "personal_dog_page";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("dog",new Dog()) ;
        List<Colour> colours = dogService.getColour();
        model.addAttribute("colour", colours);
        return "new";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Dog dog, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        Dog father = dogService.findByName(dog.getFather().getName()).stream().findFirst().orElse(new Dog());
        Dog mother  = dogService.findByName(dog.getMother().getName()).stream().findFirst().orElse(new Dog());

        dog.setFather(father);
        dog.setMother(mother);

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        dog.setPhoto(fileName);
        dogService.add(dog);
        String uploadDir = "dog-photos/" + dog.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return "dogs";
    }
    @GetMapping("/search_dog")
    public String searchDog(String name, Model model){
        List<Dog> results = dogService.findByName(name);
        model.addAttribute("result", results);
        return "search_dog";
    }


    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }
}
