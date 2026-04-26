package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    // Aqui o Spring já cria automaticamente o SELECT, INSERT e DELETE para você!
}