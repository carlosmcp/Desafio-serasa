package br.com.desafio.serasa.desafio.util;

import com.google.gson.Gson;

public class TestUtil {

    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
