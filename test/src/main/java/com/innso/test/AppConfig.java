package com.innso.test;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
pour fournir les informations de configuration au conteneur léger
à le rôle du fichier xml application-context.xml
permet de scanner les composants et permet aussi de créer des beans via des méthodes
 */

@ComponentScan(basePackages = {"com.innso.test.Controller","com.innso.test.entity","com.innso.test.repository","com.innso.test.service"})
@Configuration
public class AppConfig {
}
