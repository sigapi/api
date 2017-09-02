package br.edu.fatecsbc.sigapi.api.util.function;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.text.WordUtils;

import br.edu.fatecsbc.sigapi.api.dto.response.DadosCadastraisResponse;
import br.edu.fatecsbc.sigapi.conector.dto.DadosCadastrais;
import br.edu.fatecsbc.sigapi.conector.dto.Email;
import br.edu.fatecsbc.sigapi.conector.dto.TipoEmail;

public class DadosCadastraisToDadosCadastraisResponse
    extends AbstractFunction<DadosCadastrais, DadosCadastraisResponse> {

    @Override
    protected DadosCadastraisResponse doApply(final DadosCadastrais input) {

        final DadosCadastraisResponse response = new DadosCadastraisResponse();
        response.setFoto(input.getFoto());
        response.setInstituicao(input.getInstituicao());
        response.setCurso(input.getCurso());
        response.setNome(input.getNome());
        response.setRa(input.getRa());
        response.setTurno(WordUtils.capitalizeFully(input.getTurno().name()));

        final List<Email> emails = input.getEmails();
        if (!emails.isEmpty()) {

            response.setEmailEtec(getEmail(emails, TipoEmail.ETEC));
            response.setEmailFatec(getEmail(emails, TipoEmail.FATEC));
            response.setEmailPreferencial(getEmail(emails, TipoEmail.PREFERENCIAL));
            response.setEmailWebsai(getEmail(emails, TipoEmail.WEBSAI));

            // @formatter:off
            final Collection<String> outrosEmails = emails.stream()
                .filter(e -> e.getTiposEmail().isEmpty())
                .map(Email::getEndereco)
                .collect(Collectors.toList());
            // @formatter:on

            response.setOutrosEmails(outrosEmails);

        }

        return response;
    }

    private static final String getEmail(final List<Email> emails, final TipoEmail tipo) {

        // @formatter:off
        final Optional<Email> optional = emails.stream()
            .filter(e -> e.getTiposEmail().contains(tipo))
            .findFirst();
        // @formatter:on

        if (optional.isPresent()) {
            return optional.get().getEndereco();
        }

        return null;

    }

}
