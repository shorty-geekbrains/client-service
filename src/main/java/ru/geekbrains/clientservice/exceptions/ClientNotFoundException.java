package ru.geekbrains.clientservice.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException (String message){
        super(message);
    }
}
