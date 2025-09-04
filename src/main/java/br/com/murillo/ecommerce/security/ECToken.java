package br.com.murillo.ecommerce.security;

public class ECToken {
    private String token;

    public ECToken() {}

    public ECToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
