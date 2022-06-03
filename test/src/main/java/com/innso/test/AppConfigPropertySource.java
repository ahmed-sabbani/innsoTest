package com.innso.test;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
une deuxième class de configuration , qu'on veut qu'elle se charge que des properties
pour fournir les informations de configuration au conteneur léger
à le rôle du fichier xml application-context.xml
permet de scanner les composants et permet aussi de créer des beans via des méthodes
 */

@PropertySource("classpath:application.properties")
@Configuration
public class AppConfigPropertySource {
}
