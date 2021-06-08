package com.booking.online_booking.service;

import com.booking.online_booking.model.UserAgence;
import com.booking.online_booking.repository.UserAgenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAgenceService {

    @Autowired
    UserAgenceRepository userAgenceRepository;

    public UserAgence createUserAgence(UserAgence user) {
        return userAgenceRepository.save(user);
    }

    public UserAgence findById(UserAgence user) {
        return userAgenceRepository.findById(user.getId_agence()).orElse(null);
    }

    public UserAgence findByMatricule(UserAgence u) {
        return userAgenceRepository.findByMatriculeFiscale(u.getMatricule_fiscale());
    }
    
}
