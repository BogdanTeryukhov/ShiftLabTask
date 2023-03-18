package com.example.testpracticeshiftlab.Controllers;

import com.example.testpracticeshiftlab.Entities.Computer;
import com.example.testpracticeshiftlab.Repositories.ComputersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("shop/computers")
public class ComputersController {
    @Autowired
    private ComputersRepository computersRepository;

    @PostMapping("/add")
    public String addComputer(@RequestBody Computer computer) throws HttpMediaTypeException {
        if (!(computer.getFormFactor().equals("Desktop")
                || computer.getFormFactor().equals("Nettop")
                || computer.getFormFactor().equals("Monoblok"))) {
            throw new HttpMediaTypeException("Should be Desktop, Nettop or Monoblok") {
                @Override
                public HttpStatusCode getStatusCode() {
                    return HttpStatusCode.valueOf(400);
                }
            };
        }
        computersRepository.save(computer);
        return "Computer saved....";
    }

    @GetMapping("/getAll")
    public List<Computer> getAllComputers() {
        return computersRepository.findAll();
    }

    @GetMapping("/getAllBySerialVersionID/{serialVersionID}")
    public List<Computer> getAllComputersBySerialVersionID(@PathVariable String serialVersionID) {
        List<Computer> computers = computersRepository.findAll();
        return computers.stream().filter(x -> x.getSerialVersionID().equals(serialVersionID)).collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public String updateComputer(@PathVariable Long id, @RequestBody Computer computer) throws HttpMediaTypeException {
        computer.setId(id);
        if (computer.getFormFactor().equals("Desktop")
                || computer.getFormFactor().equals("Nettop")
                || computer.getFormFactor().equals("Monoblok")) {
            throw new HttpMediaTypeException("Should be Desktop, Nettop or Monoblok") {
                @Override
                public HttpStatusCode getStatusCode() {
                    return HttpStatusCode.valueOf(400);
                }
            };
        }
        computersRepository.save(computer);
        return "Computer has been updated....";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteComputer(@PathVariable Long id) {
        computersRepository.deleteById(id);
        return "Computer has been deleted....";
    }
}
