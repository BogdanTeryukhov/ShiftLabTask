package com.example.testpracticeshiftlab.Controllers;

import com.example.testpracticeshiftlab.Entities.Computer;
import com.example.testpracticeshiftlab.Entities.Laptop;
import com.example.testpracticeshiftlab.Entities.Monitor;
import com.example.testpracticeshiftlab.Repositories.LaptopsRepository;
import com.example.testpracticeshiftlab.Repositories.MonitorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("shop/monitors")
public class MonitorsController {
    @Autowired
    private MonitorsRepository monitorsRepository;

    @PostMapping("/add")
    public String addMonitor(@RequestBody Monitor monitor){
        monitorsRepository.save(monitor);
        return "Monitor saved....";
    }

    @GetMapping("/getAll")
    public List<Monitor> getAllMonitors(){
        return monitorsRepository.findAll();
    }

    @GetMapping("/getAllBySerialVersionID/{serialVersionID}")
    public List<Monitor> getAllMonitorsBySerialVersionID(@PathVariable String serialVersionID){
        List<Monitor> monitors = monitorsRepository.findAll();
        return monitors.stream().filter(x -> x.getSerialVersionID().equals(serialVersionID)).collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public String updateMonitor(@PathVariable Long id, @RequestBody Monitor monitor){
        monitor.setId(id);
        monitorsRepository.save(monitor);
        return "Monitor has been updated....";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMonitor(@PathVariable Long id){
        monitorsRepository.deleteById(id);
        return "Monitor has been deleted....";
    }
}
