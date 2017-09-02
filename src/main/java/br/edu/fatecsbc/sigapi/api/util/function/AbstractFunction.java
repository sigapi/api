package br.edu.fatecsbc.sigapi.api.util.function;

import java.util.function.Function;

abstract class AbstractFunction<T, V>
    implements Function<T, V> {

    protected abstract V doApply(final T input);

    @Override
    public final V apply(final T t) {

        if (t == null) {
            return null;
        }

        return doApply(t);
    }

}
