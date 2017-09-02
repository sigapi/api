package br.edu.fatecsbc.sigapi.api.util.function;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import br.edu.fatecsbc.sigapi.api.dto.response.HistoricoResponse;
import br.edu.fatecsbc.sigapi.conector.dto.Historico;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroHistorico;

public class HistoricoToHistoricoResponseCollection
    extends AbstractFunction<Historico, Collection<HistoricoResponse>> {

    @Override
    protected Collection<HistoricoResponse> doApply(final Historico input) {

        final Collection<RegistroHistorico> registros = input.getRegistros();
        if (registros != null) {
            return registros.stream().map(new RegistroHistoricoToHistoricoResponse()).collect(Collectors.toList());
        }

        return Collections.emptyList();

    }

}
