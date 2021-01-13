package xyz.codingdaddy.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Optional;

/**
 * User entity which provides access to user objects in database
 *
 * @author serhiy
 */
@Data
@EqualsAndHashCode(callSuper = false)
@RegisterForReflection
@Entity(name="users")
public class User extends PanacheEntity {
    @Column(unique=true)
    private String username;
    @Column(unique=true)
    private String email;
    private String password;

    public static Optional<User> findById(Long id) {
        return Optional.ofNullable(find("id", id).firstResult());
    }
}