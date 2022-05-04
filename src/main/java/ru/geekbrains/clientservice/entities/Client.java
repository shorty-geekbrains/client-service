package ru.geekbrains.clientservice.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client", schema = "shorty")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer role_id;
    private boolean enabled;
    private String second_name;
    private String age;
    private boolean sex;
    private String password;
    private String photo;

    @Transient
    private transient String confPassword;

}