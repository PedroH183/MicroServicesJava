package com.pedrofreires.kufundaproject.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.pedrofreires.converter.dtos.UserDTO;
import com.pedrofreires.kufundaproject.domain.user.User;
import com.pedrofreires.kufundaproject.repositories.UserRepository;
import com.pedrofreires.kufundaproject.domain.dtoConvert.DTOConvert;


@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public UserDTO findById(Long id){
        Optional<User> user = userRepository.findById(id);

        if( !user.isEmpty() ){
            return DTOConvert.convert(user.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO){
        userDTO.setDataCadastro(new Date());
        User user = userRepository.save(User.convert(userDTO));
        return DTOConvert.convert(user);
    }

    public Boolean delete(Long id){
        Optional<User> user = userRepository.findById(id);

        if( user.isPresent() ){
            userRepository.deleteById(id);
        }
        return true;
    }

    public UserDTO findByCpf(String cpf){
        Optional<User> user = userRepository.findByCpf(cpf);

        if( user.isPresent() ){
            return DTOConvert.convert(user.get());
        }
        return null;
    }

    public List<UserDTO> queryByName(String name){
        List<User> users = userRepository.queryByNomeLike(name);

        return users.stream().map(DTOConvert::convert).collect(Collectors.toList());
    }

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream().map(DTOConvert::convert).collect(Collectors.toList());
    }
}
