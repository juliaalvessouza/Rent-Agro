package com.example.rentagro.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConfigFirebase {

    private static FirebaseAuth auth;
    private static DatabaseReference firebase;
    private static StorageReference storage;

//    // retorna a instancia do storage (imagem)
//    public static StorageReference getFirebaseStorage(){
//        if(storage==null){
//            storage = FirebaseStorage.getInstance().getReference();
//        }
//        return storage;
//    }

    //    retorna a instancia do firebase auth (usuario)
    public static FirebaseAuth getFirebaseAuth(){
        if(auth==null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }

    //    retorna a instancia do firebase (BD)
    public static DatabaseReference getFirebaseDB(){
        if(firebase == null){
            firebase = FirebaseDatabase.getInstance().getReference();
        }
        return firebase;
    }
}
