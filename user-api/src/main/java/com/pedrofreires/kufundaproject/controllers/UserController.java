package com.pedrofreires.kufundaproject.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedrofreires.converter.dtos.UserDTO;
import com.pedrofreires.kufundaproject.services.UserServices;


@RestController
public class UserController {
    @Autowired
    private UserServices userService;

    @GetMapping("/user/")
    public List<UserDTO> getUsers() {
        return  userService.getAll();
    }

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/user/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    Boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/user/search")
        public List<UserDTO> queryByName(
            @RequestParam(name="nome", required = true) String nome){

        return userService.queryByName(nome);
    }
}