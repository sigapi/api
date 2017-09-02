package br.edu.fatecsbc.sigapi.api.util.function;

import br.edu.fatecsbc.sigapi.api.dto.response.HistoricoResponse;
import br.edu.fatecsbc.sigapi.conector.dto.Disciplina;
import br.edu.fatecsbc.sigapi.conector.dto.Periodo;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroHistorico;

class RegistroHistoricoToHistoricoResponse
    extends AbstractFunction<RegistroHistorico, HistoricoResponse> {

    @Override
    protected HistoricoResponse doApply(final RegistroHistorico input) {

        final HistoricoResponse response = new HistoricoResponse();
        response.setMediaFinal(input.getMediaFinal());
        response.setAprovado(input.isAprovado());
        response.setFrequencia(input.getFrequencia());
        response.setObservacao(input.getObservacao());
        response.setQuantidadeAulasSemanais(input.getQuantidadeAulasSemanais());

        final Periodo periodo = input.getPeriodo();
        response.setAno(periodo.getAno());
        response.setSemestre(periodo.getSemestre());

        final Disciplina disciplina = input.getDisciplina();
        response.setSiglaDisciplina(disciplina.getSigla());
        response.setNomeDisciplina(disciplina.getNome());

        return response;

    }

}
