package com.memories.springboard.Repository;

import com.memories.springboard.Entity.Board;
import com.memories.springboard.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Integer> {

}
