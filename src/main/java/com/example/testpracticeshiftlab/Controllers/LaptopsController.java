package com.example.testpracticeshiftlab.Controllers;

import com.example.testpracticeshiftlab.Entities.Computer;
import com.example.testpracticeshiftlab.Entities.Laptop;
import com.example.testpracticeshiftlab.Repositories.LaptopsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("shop/laptops")
public class LaptopsController {
    @Autowired
    private LaptopsRepository laptopsRepository;

    @PostMapping("/add")
    public String addLaptop(@Valid @RequestBody Laptop laptop) throws HttpMediaTypeException {
        if (laptop.getLaptopsSize() % 2 == 0){
            throw new HttpMediaTypeException("Should be 13, 15, 17 or 19") {
                @Override
                public HttpStatusCode getStatusCode() {
                    return HttpStatusCode.valueOf(403);
                }
            };
        }
        laptopsRepository.save(laptop);
        return "Laptop saved....";
    }

    @GetMapping("/getAll")
    public List<Laptop> getAllLaptops(){
        return laptopsRepository.findAll();
    }

    @GetMapping("/getAllBySerialVersionID/{serialVersionID}")
    public List<Laptop> getAllLaptopsBySerialVersionID(@PathVariable String serialVersionID){
        List<Laptop> laptops = laptopsRepository.findAll();
        return laptops.stream().filter(x -> x.getSerialVersionID().equals(serialVersionID)).collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public String updateLaptop(@PathVariable Long id, @Valid @RequestBody Laptop laptop) throws HttpMediaTypeException {
        laptop.setId(id);
        if (laptop.getLaptopsSize() % 2 == 0){
            throw new HttpMediaTypeException("Should be 13, 15, 17 or 19") {
                @Override
                public HttpStatusCode getStatusCode() {
                    return HttpStatusCode.valueOf(400);
                }
            };
        }
        laptopsRepository.save(laptop);
        return "Laptop has been updated....";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLaptop(@PathVariable Long id){
        laptopsRepository.deleteById(id);
        return "Laptop has been deleted....";
    }
}
