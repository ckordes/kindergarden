package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Allergie;
import pl.coderslab.repository.AddressRepository;
import pl.coderslab.repository.AllergieRepository;

public class AllergieConverter implements Converter<String, Allergie> {
    @Autowired
    AllergieRepository allergieRepository;

    @Override
    public Allergie convert(String s) {
        return allergieRepository.findById(Long.parseLong(s));
    }
}
