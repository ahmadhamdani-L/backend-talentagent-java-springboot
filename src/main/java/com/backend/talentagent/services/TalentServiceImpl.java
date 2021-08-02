package com.backend.talentagent.services;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.models.Talent;
import com.backend.talentagent.repository.TalentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalentServiceImpl implements TalentService{

    @Autowired
    private TalentRepository talentRepository;

    @Override
    public List<Talent> findAllTalent() {
        
        return talentRepository.findAll();
    }

    @Override
    public Talent addTalent(Talent talent) {
        
        return talentRepository.save(talent);
    }

    @Override
    public Optional<Talent> findTalentById(Long id) {
        
        return talentRepository.findById(id);
    }

    @Override
    public void deleteTalentById(Long id) {
        talentRepository.deleteById(id);
        
    }
    
}