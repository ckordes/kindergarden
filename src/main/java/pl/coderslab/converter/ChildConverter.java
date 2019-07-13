package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Child;
import pl.coderslab.repository.ChildRepository;

public class ChildConverter implements Converter<String, Child> {
    @Autowired
    ChildRepository childRepository;

    @Override
    public Child convert(String s) {
        return childRepository.findById(Long.parseLong(s));
    }
}