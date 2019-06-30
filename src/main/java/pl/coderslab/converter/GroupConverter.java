package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Group;
import pl.coderslab.repository.GroupRepository;

public class GroupConverter implements Converter<String, Group> {
    @Autowired
    GroupRepository groupRepository;

    @Override
    public Group convert(String s) {
        return groupRepository.findById(Long.parseLong(s));
    }
}
