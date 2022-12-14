package br.com.desafio.serasa.desafio.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeingErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()) {
            case 400:
                return new Exception("Bad request");
            case 404:
                return new Exception("Not found");
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}