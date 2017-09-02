package br.edu.fatecsbc.sigapi.api.dto.response;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class NotaParcialResponse {

    private String siglaDisciplina;
    private String nomeDisciplina;
    private final Map<String, Float> avaliacoes = new HashMap<>();
    private float mediaFinal;
    private int quantidadeFaltas;
    private float percentualFrequencia;

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

    public Map<String, Float> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacao(final String tipo, final float nota) {

        if (StringUtils.isNotBlank(tipo)) {
            avaliacoes.put(tipo, nota);
        }

    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(final float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public int getQuantidadeFaltas() {
        return quantidadeFaltas;
    }

    public void setQuantidadeFaltas(final int quantidadeFaltas) {
        this.quantidadeFaltas = quantidadeFaltas;
    }

    public float getPercentualFrequencia() {
        return percentualFrequencia;
    }

    public void setPercentualFrequencia(final float percentualFrequencia) {
        this.percentualFrequencia = percentualFrequencia;
    }

}
