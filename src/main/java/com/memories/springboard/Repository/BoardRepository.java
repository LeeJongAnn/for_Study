package com.memories.springboard.Repository;

import com.memories.springboard.Entity.Board;
import com.memories.springboard.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BoardRepository extends PagingAndSortingRepository<Board,Integer> {

}
