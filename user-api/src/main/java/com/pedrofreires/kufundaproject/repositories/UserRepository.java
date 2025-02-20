package com.pedrofreires.kufundaproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrofreires.kufundaproject.domain.user.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByCpf(String cpf);
    List<User> queryByNomeLike(String nome);
}