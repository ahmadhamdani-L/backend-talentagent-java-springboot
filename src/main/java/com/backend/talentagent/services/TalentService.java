package com.backend.talentagent.services;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.models.Talent;

public interface TalentService {
    //show list all categogry
    List<Talent> findAllTalent();
    
    // insert object Talent ke db
    Talent addTalent(Talent talent);

    // cari data Talent sesuai id yg dikirim
    Optional<Talent> findTalentById(Long id);

    // delete Talent sesuai id yg dikirim
    void deleteTalentById(Long id);
}
