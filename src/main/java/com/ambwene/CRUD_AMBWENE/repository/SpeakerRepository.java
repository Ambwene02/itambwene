package com.ambwene.CRUD_AMBWENE.repository;

import com.ambwene.CRUD_AMBWENE.entity.SpeakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<SpeakerEntity, Long> {
    //all crud methods for database
}
