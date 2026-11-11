
package com.it342g02.twobyte.learnlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it342g02.twobyte.learnlink.entity.QuizAttemptEntity;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttemptEntity, Integer> {

}
