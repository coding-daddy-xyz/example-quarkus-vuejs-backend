package xyz.codingdaddy.mapping;

import org.mapstruct.Mapper;
import xyz.codingdaddy.config.MappingConfig;
import xyz.codingdaddy.domain.User;
import xyz.codingdaddy.domain.dto.UserDto;
import xyz.codingdaddy.domain.view.UserView;

/**
 * Performs mapping for {@link User} entity
 *
 * @author serhiy
 */
@Mapper(config = MappingConfig.class)
public interface UserMapper {
    /**
     * Maps {@link User} entity to {@link UserView}
     *
     * @param user to be mapped
     * @return mapped dto
     */
    UserView toView(User user);

    /**
     * Maps {@link UserDto} to {@link User} entity
     *
     * @param dto to be mapped
     * @return mapped entity
     */
    User fromDto(UserDto dto);
}