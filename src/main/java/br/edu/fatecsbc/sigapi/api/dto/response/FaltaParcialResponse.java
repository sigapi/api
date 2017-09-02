package br.edu.fatecsbc.sigapi.api.dto.response;

public class FaltaParcialResponse {

    private String siglaDisciplina;
    private String nomeDisciplina;
    private int quantidadeAusencias;
    private int quantidadePresencas;

    public String getSiglaDisciplina() {
        return siglaDisciplina;
    }

    public void setSiglaDisciplina(final String siglaDisciplina) {
        this.siglaDisciplina = siglaDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(final String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getQuantidadeAusencias() {
        return quantidadeAusencias;
    }

    public void setQuantidadeAusencias(final int quantidadeAusencias) {
        this.quantidadeAusencias = quantidadeAusencias;
    }

    public int getQuantidadePresencas() {
        return quantidadePresencas;
    }

    public void setQuantidadePresencas(final int quantidadePresencas) {
        this.quantidadePresencas = quantidadePresencas;
    }

}
