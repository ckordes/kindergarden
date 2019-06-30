package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Parent;
import pl.coderslab.repository.ParentRepository;

public class ParentConverter implements Converter<String, Parent> {
    @Autowired
    ParentRepository parentRepository;

    @Override
    public Parent convert(String s) {
        return parentRepository.findById(Long.parseLong(s));
    }
}
