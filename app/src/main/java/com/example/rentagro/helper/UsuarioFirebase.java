package com.example.rentagro.helper;

import com.google.firebase.auth.FirebaseAuth;

public class UsuarioFirebase {

    public static  String getIdentificadorUsuario(){
        FirebaseAuth usuario = ConfigFirebase.getFirebaseAuth();
        String email = usuario.getCurrentUser().getEmail();
        String identificadorUsuario = Base64Custom.codificarBase64(email);

        return identificadorUsuario;
    }
}
