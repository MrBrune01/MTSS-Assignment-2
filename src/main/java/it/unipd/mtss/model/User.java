////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
//////////////////////////////////////////////////////////////////// 

package it.unipd.mtss.model;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User {

    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;

    public User(String nome, String cognome, LocalDate datanascita){
        name = nome;
        surname = cognome;
        dateOfBirth = datanascita;

        if(dateOfBirth == null) {
            throw new IllegalArgumentException("La data di nascita è null");
        }
        if(dateOfBirth.isBefore(LocalDate.now())) {
            this.dateOfBirth   = datanascita;
        }else {
            throw new IllegalArgumentException("La data di nascita deve essere precedente alla data odierna");
        }
        
    }
    public User() {
        super();
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public Boolean isMinor(){
        long age = dateOfBirth.until(LocalDate.now(), ChronoUnit.YEARS);
        if(age < 18){
            return true;
        }
        return false;
    }
   
}