package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Address;
import pl.coderslab.repository.AddressRepository;

public class AddressConverter implements Converter<String, Address> {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address convert(String s) {
        return addressRepository.findById(Long.parseLong(s));
    }
}