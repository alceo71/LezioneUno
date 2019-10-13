package com.example.lezioneuno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.common.model.Utente;
import com.example.lezioneuno.common.util.LogUtil;
import com.google.gson.Gson;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.io.StringWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] valori = {"uno", "due"};
        Gson gson = new Gson();
        Log.d("MIO", gson.toJson(valori));


        provaMetodo();

        try {
            Document doc = new Document(new Element("data"));
            StringWriter writer = new StringWriter();
            XMLOutputter xMLOutputter = new XMLOutputter();
            xMLOutputter.output(doc,writer);
            Log.d("MIO",writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Utente utente = new Utente();

        ///////////////////////////////////
        // Sezione con i messaggi di Log //
        ///////////////////////////////////

        // Invia due messaggi
        LogUtil.debug("Messaggio di debug");
        LogUtil.warn("Messaggio di warning");

        // Disattiva i messaggi di debug e
        LogUtil.livello = LogUtil.Verbosity.INFO;
        // Invia due messaggi
        LogUtil.debug("Secondo messaggio di debug");
        LogUtil.warn("Secondo messaggio di warning");



        try {
            causaEccezione();
        } catch (Exception e) {
           LogUtil.error("Errore in MainActivity",e);
        }

    }

    public void provaMetodo(){
        String valore = "primo";
        for(int loop = 0;loop < 20;loop++){
            valore = valore + "1";
        }
        Log.d("MIO", valore+"");
    }

    public void causaEccezione(){
        // Esempio di eccezione
        String valore = null;
        if(valore.equals("altro")){

        }
    }


    public void click(View view){
        String valore = "click ";
        for(int loop = 0;loop < 20;loop++){
            valore = valore + "1";
        }
        LogUtil.info(valore+"");
    }

}
