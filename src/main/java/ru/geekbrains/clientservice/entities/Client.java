package ru.geekbrains.clientservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "client", schema = "shorty")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer roleId;
    private boolean enabled;
    private String secondName;
    private String age;
    private boolean sex;
    private String password;
    private String photo;

    @Transient
    private transient String confPassword;


}