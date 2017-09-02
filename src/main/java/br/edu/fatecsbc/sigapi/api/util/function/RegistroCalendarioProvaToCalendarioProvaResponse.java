package br.edu.fatecsbc.sigapi.api.util.function;

import java.util.Collection;

import br.edu.fatecsbc.sigapi.api.dto.response.CalendarioProvaResponse;
import br.edu.fatecsbc.sigapi.conector.dto.AvaliacaoCalendarioProva;
import br.edu.fatecsbc.sigapi.conector.dto.Disciplina;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroCalendarioProva;

class RegistroCalendarioProvaToCalendarioProvaResponse
    extends AbstractFunction<RegistroCalendarioProva, CalendarioProvaResponse> {

    @Override
    protected CalendarioProvaResponse doApply(final RegistroCalendarioProva input) {

        final CalendarioProvaResponse response = new CalendarioProvaResponse();

        final Disciplina disciplina = input.getDisciplina();
        response.setNomeDisciplina(disciplina.getNome());
        response.setSiglaDisciplina(disciplina.getSigla());

        final Collection<AvaliacaoCalendarioProva> avaliacoes = input.getAvaliacoes();
        if (avaliacoes != null) {
            avaliacoes.stream().forEach(a -> response.addAvaliacao(a.getDescricao(), a.getData()));
        }

        return response;

    }

}
