package br.edu.fatecsbc.sigapi.api.dto.response;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class CalendarioProvaResponse {

    private String siglaDisciplina;
    private String nomeDisciplina;
    private final Map<String, Date> avaliacoes = new HashMap<>();

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

    public Map<String, Date> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacao(final String descricao, final Date data) {

        if (StringUtils.isNotBlank(descricao)) {
            avaliacoes.put(descricao, data);
        }

    }

}
