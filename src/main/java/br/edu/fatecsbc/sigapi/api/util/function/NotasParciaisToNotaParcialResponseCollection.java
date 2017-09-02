package br.edu.fatecsbc.sigapi.api.util.function;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import br.edu.fatecsbc.sigapi.api.dto.response.NotaParcialResponse;
import br.edu.fatecsbc.sigapi.conector.dto.NotasParciais;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroNotaParcial;

public class NotasParciaisToNotaParcialResponseCollection
    extends AbstractFunction<NotasParciais, Collection<NotaParcialResponse>> {

    @Override
    protected Collection<NotaParcialResponse> doApply(final NotasParciais input) {

        final Collection<RegistroNotaParcial> registros = input.getRegistros();
        if (registros != null) {
            return registros.stream().map(new RegistroNotaParcialToNotaParcialResponse()).collect(Collectors.toList());
        }

        return Collections.emptyList();

    }

}
