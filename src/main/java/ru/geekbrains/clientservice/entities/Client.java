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
@Table(name = "client", schema = "shorty_video_service")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String clientName;
    private Integer roleId;
    private boolean enabled;
    private String clientSecondName;
    private Integer age;
    private boolean sex;
    private String clientPassword;
    private String clientPhoto;

    @Transient
    private transient String confPassword;

//    @ManyToOne
//    @JoinTable(name = "client_role", joinColumns = @JoinColumn(name = "role_id"),
//    inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Role clientRole;

}