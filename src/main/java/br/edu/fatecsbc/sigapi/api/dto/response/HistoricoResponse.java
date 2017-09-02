package br.edu.fatecsbc.sigapi.api.dto.response;

public class HistoricoResponse {

    private String siglaDisciplina;
    private String nomeDisciplina;
    private int quantidadeAulasSemanais;
    private int ano;
    private int semestre;
    private boolean aprovado;
    private float mediaFinal;
    private float frequencia;
    private String observacao;

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

    public int getQuantidadeAulasSemanais() {
        return quantidadeAulasSemanais;
    }

    public void setQuantidadeAulasSemanais(final int quantidadeAulasSemanais) {
        this.quantidadeAulasSemanais = quantidadeAulasSemanais;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(final int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(final int semestre) {
        this.semestre = semestre;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(final boolean aprovado) {
        this.aprovado = aprovado;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(final float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public float getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(final float frequencia) {
        this.frequencia = frequencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(final String observacao) {
        this.observacao = observacao;
    }

}
