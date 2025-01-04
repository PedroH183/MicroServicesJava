package com.pedrofreires.KufundaProject.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrofreires.KufundaProject.domain.user.User;
import com.pedrofreires.KufundaProject.domain.user.UserDTO;
import com.pedrofreires.KufundaProject.repositories.UserRepository;


@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public UserDTO findById(Long id){
        Optional<User> user = userRepository.findById(id);

        if( !user.isEmpty() ){
            return UserDTO.convert(user.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO){
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
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
            return UserDTO.convert(user.get());
        }
        return null;
    }

    public List<UserDTO> queryByName(String name){
        List<User> users = userRepository.queryByNomeLike(name);

        return users
            .stream()
            .map(UserDTO::convert)
            .collect(Collectors.toList());
    }

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
            .stream()
            .map(UserDTO::convert)
            .collect(Collectors.toList());
    }
}
