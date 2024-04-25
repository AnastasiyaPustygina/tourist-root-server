package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.Tourist;
import com.polytech.touristrootserver.exception.TouristAlreadyExists;
import com.polytech.touristrootserver.exception.TouristNotFound;
import com.polytech.touristrootserver.repository.TouristRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TouristServiceJpa implements TouristService{
    private final TouristRepository touristRepository;

    private final PasswordEncryptionBCrypt passwordEncryptionBCrypt;

//    public TouristServiceJpa(TouristRepository touristRepository, PasswordEncryptionBCrypt passwordEncryptionBCrypt) {
//        this.touristRepository = touristRepository;
//        this.passwordEncryptionBCrypt = passwordEncryptionBCrypt;
//        touristRepository.findAll().forEach(t -> {
//            t.setPassword(passwordEncryptionBCrypt.encrypt(t.getPassword()));
//            touristRepository.save(t);
//        });
//    }

    @Override
    @Transactional
    public Tourist register(Tourist tourist) {
        touristRepository.findByEmail(tourist.getEmail()).ifPresent(t -> {
    throw new TouristAlreadyExists("Tourist with email " + tourist.getEmail() + " already exists");});
        tourist.setPassword(passwordEncryptionBCrypt.encrypt(tourist.getPassword()));
        return touristRepository.save(tourist);
    }

    @Override
    @Transactional(readOnly = true)
    public Tourist login(String email, String password) {
        Tourist tourist = touristRepository.findByEmail(email).orElseThrow(() ->
                new TouristNotFound("Tourist with email " + email + " is not found"));
        if(!passwordEncryptionBCrypt.isSamePassword(password, tourist.getPassword())) throw new TouristNotFound(
                "tourist with this credentials is not found");
        return tourist;
    }

    @Override
    @Transactional
    public Tourist update(Tourist tourist) {
        return touristRepository.save(getByIdEndUpdateValues(tourist));
    }

    @Override
    @Transactional
    public Tourist updatePassword(String newPassword, long touristId) {
        Tourist touristOld = getTouristById(touristId);
        touristOld.setPassword(newPassword);
        return touristRepository.save(touristOld);
    }
    @Override
    @Transactional
    public Tourist getTouristById(long id){
        return touristRepository.findById(id).orElseThrow(() -> new TouristNotFound(
                "Tourist with id " + id + " was not found"));
    }
    private Tourist getByIdEndUpdateValues(Tourist tourist){
        Tourist oldTourist = touristRepository.findById(tourist.getId()).orElseThrow(() ->
                new TouristNotFound("Tourist with id " + tourist.getId() + " is not found"));
        oldTourist.setId(tourist.getId());
        oldTourist.setName(tourist.getName());
        oldTourist.setEmail(tourist.getEmail());
        oldTourist.setGender(oldTourist.getGender());
        oldTourist.setAgePeriod(tourist.getAgePeriod());
        oldTourist.setInformation(tourist.getInformation());
        oldTourist.setImage(tourist.getImage());
        return oldTourist;
    }
}
