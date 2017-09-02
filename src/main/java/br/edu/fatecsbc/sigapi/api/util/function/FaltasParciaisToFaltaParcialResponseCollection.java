package br.edu.fatecsbc.sigapi.api.util.function;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import br.edu.fatecsbc.sigapi.api.dto.response.FaltaParcialResponse;
import br.edu.fatecsbc.sigapi.conector.dto.FaltasParciais;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroFaltaParcial;

public class FaltasParciaisToFaltaParcialResponseCollection
    extends AbstractFunction<FaltasParciais, Collection<FaltaParcialResponse>> {

    @Override
    protected Collection<FaltaParcialResponse> doApply(final FaltasParciais input) {

        final Collection<RegistroFaltaParcial> registros = input.getRegistros();
        if (registros != null) {
            return registros.stream().map(new RegistroFaltaParcialToFaltaParcialResponse())
                .collect(Collectors.toList());
        }

        return Collections.emptyList();

    }

}
