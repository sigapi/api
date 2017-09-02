package br.edu.fatecsbc.sigapi.api.util.function;

import br.edu.fatecsbc.sigapi.api.dto.response.DadosDesempenhoResponse;
import br.edu.fatecsbc.sigapi.conector.dto.DadosDesempenho;

public class DadosDesempenhoToDadosDesempenhoResponse
    extends AbstractFunction<DadosDesempenho, DadosDesempenhoResponse> {

    @Override
    protected DadosDesempenhoResponse doApply(final DadosDesempenho input) {

        final DadosDesempenhoResponse response = new DadosDesempenhoResponse();
        response.setMaiorPrCurso(input.getMaiorPrCurso());
        response.setPp(input.getPp());
        response.setPr(input.getPr());

        return response;
    }

}
