package br.edu.fatecsbc.sigapi.api.dto.response;

public class ErroResponse {

    private final String mensagem;

    public ErroResponse(final String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}
