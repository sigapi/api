package br.edu.fatecsbc.sigapi.api.dto.response;

import java.util.Collection;

public class DadosCadastraisResponse {

    private String nome;
    private String foto;
    private String ra;
    private String instituicao;
    private String curso;
    private String turno;
    private String emailFatec;
    private String emailEtec;
    private String emailWebsai;
    private String emailPreferencial;
    private Collection<String> outrosEmails;

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(final String foto) {
        this.foto = foto;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(final String ra) {
        this.ra = ra;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(final String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(final String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(final String turno) {
        this.turno = turno;
    }

    public String getEmailFatec() {
        return emailFatec;
    }

    public void setEmailFatec(final String emailFatec) {
        this.emailFatec = emailFatec;
    }

    public String getEmailEtec() {
        return emailEtec;
    }

    public void setEmailEtec(final String emailEtec) {
        this.emailEtec = emailEtec;
    }

    public String getEmailWebsai() {
        return emailWebsai;
    }

    public void setEmailWebsai(final String emailWebsai) {
        this.emailWebsai = emailWebsai;
    }

    public String getEmailPreferencial() {
        return emailPreferencial;
    }

    public void setEmailPreferencial(final String emailPreferencial) {
        this.emailPreferencial = emailPreferencial;
    }

    public Collection<String> getOutrosEmails() {
        return outrosEmails;
    }

    public void setOutrosEmails(final Collection<String> outrosEmails) {
        this.outrosEmails = outrosEmails;
    }

}
