package ru.geekbrains.clientservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "client", schema = "shorty_video_service")
public class Client {

    @Id
    private long clientId;

    private String clientName;

    private int roleId;

    private String clientSecondName;

    private int age;

    private boolean sex;

    private String clientPassword;

    private String clientPhoto;

    @Transient
    private transient String confPassword;

    public Client(String clientName, int roleId, String clientSecondName,
                  int age, boolean sex, String clientPassword, String clientPhoto,
                  String confPassword) {
        this.clientName = clientName;
        this.roleId = roleId;
        this.clientSecondName = clientSecondName;
        this.age = age;
        this.sex = sex;
        this.clientPassword = clientPassword;
        this.clientPhoto = clientPhoto;
        this.confPassword = confPassword;
    }


}
