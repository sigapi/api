package br.edu.fatecsbc.sigapi.api.util.function;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import br.edu.fatecsbc.sigapi.api.dto.response.CalendarioProvaResponse;
import br.edu.fatecsbc.sigapi.conector.dto.CalendarioProvas;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroCalendarioProva;

public class CalendarioProvasToCalendarioProvaResponseCollection
    extends AbstractFunction<CalendarioProvas, Collection<CalendarioProvaResponse>> {

    @Override
    protected Collection<CalendarioProvaResponse> doApply(final CalendarioProvas input) {

        final Collection<RegistroCalendarioProva> registros = input.getRegistros();
        if (registros != null) {
            return registros.stream().map(new RegistroCalendarioProvaToCalendarioProvaResponse())
                .collect(Collectors.toList());
        }

        return Collections.emptyList();

    }

}
