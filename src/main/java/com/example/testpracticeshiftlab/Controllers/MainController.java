package com.example.testpracticeshiftlab.Controllers;

import com.example.testpracticeshiftlab.Repositories.ComputersRepository;
import com.example.testpracticeshiftlab.Repositories.HDDRepository;
import com.example.testpracticeshiftlab.Repositories.LaptopsRepository;
import com.example.testpracticeshiftlab.Repositories.MonitorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/shop")
public class MainController {

    @Autowired
    private ComputersRepository computersRepository;
    @Autowired
    private LaptopsRepository laptopsRepository;
    @Autowired
    private MonitorsRepository monitorsRepository;
    @Autowired
    private HDDRepository hddRepository;

    @GetMapping("/getAllGoods")
    public List<Object> getAllGoods(){
        List<Object> list = Stream.concat(computersRepository.findAll().stream(),laptopsRepository.findAll().stream()).toList();
        List<Object> list1 = Stream.concat(monitorsRepository.findAll().stream(),hddRepository.findAll().stream()).toList();
        return Stream.concat(list1.stream(),list.stream()).toList();
    }

}
