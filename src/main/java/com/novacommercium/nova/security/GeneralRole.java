package com.novacommercium.nova.security;

//Permet d'énumerer les différents roles que l'application va utiliser (doit figurer de la meme maniere que la base de donnée !)
public enum GeneralRole {
    ADMIN("ADMIN"),
    CLIENT("CLIENT"),
    UTILISATEUR("UTILISATEUR");

    private String role = "";

    GeneralRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString(){
        return role;
    }
}
