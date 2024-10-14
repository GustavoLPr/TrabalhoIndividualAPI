package br.org.serratec.Biblioteca.exception;

public class Exception {
    private String campo;
    private String mensagem;

    public Exception(String campo, String mensagem){
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
