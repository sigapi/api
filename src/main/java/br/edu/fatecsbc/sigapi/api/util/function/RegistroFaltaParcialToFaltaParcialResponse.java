package br.edu.fatecsbc.sigapi.api.util.function;

import br.edu.fatecsbc.sigapi.api.dto.response.FaltaParcialResponse;
import br.edu.fatecsbc.sigapi.conector.dto.Disciplina;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroFaltaParcial;

public class RegistroFaltaParcialToFaltaParcialResponse
    extends AbstractFunction<RegistroFaltaParcial, FaltaParcialResponse> {

    @Override
    protected FaltaParcialResponse doApply(final RegistroFaltaParcial input) {

        final FaltaParcialResponse response = new FaltaParcialResponse();
        response.setQuantidadeAusencias(input.getQuantidadeAusencias());
        response.setQuantidadePresencas(input.getQuantidadePresencas());

        final Disciplina disciplina = input.getDisciplina();
        response.setNomeDisciplina(disciplina.getNome());
        response.setSiglaDisciplina(disciplina.getSigla());

        return response;
    }

}
