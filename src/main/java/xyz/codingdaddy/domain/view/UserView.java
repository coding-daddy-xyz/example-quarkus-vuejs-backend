package xyz.codingdaddy.domain.view;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

/**
 * Data transfer object for user entity
 *
 * @author serhiy
 */
@Data
@RegisterForReflection
public class UserView {
    private Long id;
    private String username;
    private String email;
}