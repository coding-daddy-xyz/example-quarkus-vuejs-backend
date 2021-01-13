package xyz.codingdaddy.domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

/**
 * Data transfer object for user entity
 *
 * @author serhiy
 */
@Data
@RegisterForReflection
public class UserDto {
    private String username;
    private String password;
    private String email;
}