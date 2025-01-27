package com.pedrofreires.kufundaproject.domain.dtoConvert;

import com.pedrofreires.converter.dtos.UserDTO;
import com.pedrofreires.kufundaproject.domain.user.User;

public class DTOConvert {

    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setCpf(user.getCpf());
        userDTO.setNome(user.getNome());
        userDTO.setEmail(user.getEmail());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;
    }
}
