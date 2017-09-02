package br.edu.fatecsbc.sigapi.api.util.function;

import java.util.Collection;

import br.edu.fatecsbc.sigapi.api.dto.response.NotaParcialResponse;
import br.edu.fatecsbc.sigapi.conector.dto.AvaliacaoParcial;
import br.edu.fatecsbc.sigapi.conector.dto.Disciplina;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroNotaParcial;

public class RegistroNotaParcialToNotaParcialResponse
    extends AbstractFunction<RegistroNotaParcial, NotaParcialResponse> {

    @Override
    protected NotaParcialResponse doApply(final RegistroNotaParcial input) {

        final NotaParcialResponse response = new NotaParcialResponse();
        response.setMediaFinal(input.getMediaFinal());
        response.setPercentualFrequencia(input.getPercentualFrequencia());
        response.setQuantidadeFaltas(input.getQuantidadeFaltas());

        final Disciplina disciplina = input.getDisciplina();
        response.setSiglaDisciplina(disciplina.getSigla());
        response.setNomeDisciplina(disciplina.getNome());

        final Collection<AvaliacaoParcial> avaliacoes = input.getAvaliacoes();
        if (avaliacoes != null) {
            avaliacoes.stream().forEach(a -> response.addAvaliacao(a.getTipo(), a.getNota()));
        }

        return response;

    }

}
