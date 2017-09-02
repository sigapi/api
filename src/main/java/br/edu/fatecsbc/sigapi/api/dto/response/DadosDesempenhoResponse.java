package br.edu.fatecsbc.sigapi.api.dto.response;

public class DadosDesempenhoResponse {

    private float pp;
    private float pr;
    private float maiorPrCurso;

    public float getPp() {
        return pp;
    }

    public void setPp(final float pp) {
        this.pp = pp;
    }

    public float getPr() {
        return pr;
    }

    public void setPr(final float pr) {
        this.pr = pr;
    }

    public float getMaiorPrCurso() {
        return maiorPrCurso;
    }

    public void setMaiorPrCurso(final float maiorPrCurso) {
        this.maiorPrCurso = maiorPrCurso;
    }

}
