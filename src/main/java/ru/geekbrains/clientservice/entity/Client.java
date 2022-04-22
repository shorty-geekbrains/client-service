package ru.geekbrains.clientservice.entity;

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
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "client_second_name")
    private String clientSecondName;

    private int age;
    private boolean sex;

    @Column(name = "client_password")
    private String clientPassword;

    @Column(name = "client_photo")
    private String clientPhoto;

    @Transient
    private transient String confPassword;


    public Client(String clientName, int roleId, boolean enabled, String clientSecondName,
                  int age, boolean sex, String clientPassword, String clientPhoto,
                  String confPassword) {
        this.clientName = clientName;
        this.roleId = roleId;
        this.enabled = enabled;
        this.clientSecondName = clientSecondName;
        this.age = age;
        this.sex = sex;
        this.clientPassword = clientPassword;
        this.clientPhoto = clientPhoto;
        this.confPassword = confPassword;
    }
}
