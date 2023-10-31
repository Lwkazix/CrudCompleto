package com.finalprojeto.projetofinal.repositories;

import com.finalprojeto.projetofinal.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModels,Integer>{
}
