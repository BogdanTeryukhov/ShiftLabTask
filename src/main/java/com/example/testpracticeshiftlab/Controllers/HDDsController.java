package com.example.testpracticeshiftlab.Controllers;

import com.example.testpracticeshiftlab.Entities.Computer;
import com.example.testpracticeshiftlab.Entities.HDD;
import com.example.testpracticeshiftlab.Repositories.ComputersRepository;
import com.example.testpracticeshiftlab.Repositories.HDDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop/hdd")
public class HDDsController {
    @Autowired
    private HDDRepository hddRepository;

    @PostMapping("/add")
    public String addHDD(@RequestBody HDD hdd){
        hddRepository.save(hdd);
        return "HDD saved....";
    }

    @GetMapping("/getAll")
    public List<HDD> getAllHDDs(){
        return hddRepository.findAll();
    }

    @GetMapping("/getAllBySerialVersionID/{serialVersionID}")
    public List<HDD> getAllHDDsBySerialVersionID(@PathVariable String serialVersionID){
        List<HDD> hdds = hddRepository.findAll();
        return hdds.stream().filter(x -> x.getSerialVersionID().equals(serialVersionID)).collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public String updateHDD(@PathVariable Long id, @RequestBody HDD hdd){
        hdd.setId(id);
        hddRepository.save(hdd);
        return "HDD has been updated....";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHDD(@PathVariable Long id){
        hddRepository.deleteById(id);
        return "HDD has been deleted....";
    }
}
