package br.com.calcularmedia;

public class DomainNota {

    // Ciência Humanas e suas Tecnologias
    private double notaCHT;
    // Ciências da Natureza e suas Tecnologias
    private double notaCNT;
    // Linguagens, Códigos e suas Tecnologias
    private double notaLCT;
    // Matemática e suas Tecnologias
    private double notaMT;
    // Redação
    private double notaR;
    // Média das notas
    private double media;

    public DomainNota(double notaCHT, double notaCNT, double notaLCT, double notaMT, double notaR) throws Exception {

        this.notaCHT = notaCHT;
        this.notaCNT = notaCNT;
        this.notaLCT = notaLCT;
        this.notaMT = notaMT;
        this.notaR = notaR;
    }

    private boolean verificarVazio() {
        if(this.notaCHT == 0 && this.notaCNT == 0 && this.notaLCT == 0 && this.notaMT == 0 && this.notaR == 0) {
            return true;
        }
        return false;
    }

    public double calcularNotas() throws Exception {
        if(this.notaCHT == 0 && this.notaCNT == 0 && this.notaLCT == 0 && this.notaMT == 0 && this.notaR == 0) return 0;

        if(validaNotas()) {
            throw  new Exception("NOTA INVALIDA");
        }

        double resultado = ((this.notaCHT + this.notaCNT + this.notaLCT + this.notaMT + this.notaR) / 5 );
        if(resultado > 1000 || resultado < 0){
            throw new Exception("RESULTADO INVALIDO");
        }
        return resultado;
    }

    public boolean validaNotas() {

        if(this.notaCHT < 0 || this.notaCNT < 0 || this.notaLCT < 0 || this.notaMT < 0 || this.notaR < 0) {
            this.setMedia(0);
            return true;
        }else if(this.notaCHT > 1000 || this.notaCNT > 1000 || this.notaLCT > 1000 || this.notaMT > 1000 || this.notaR > 1000){
            this.setMedia(0);
            return true;
        }
        return false;
    }

    public double getNotaCHT() {
        return notaCHT;
    }

    public void setNotaCHT(double notaCHT) {
        this.notaCHT = notaCHT;
    }

    public double getNotaCNT() {
        return notaCNT;
    }

    public void setNotaCNT(double notaCNT) {
        this.notaCNT = notaCNT;
    }

    public double getNotaLCT() {
        return notaLCT;
    }

    public void setNotaLCT(double notaLCT) {
        this.notaLCT = notaLCT;
    }

    public double getNotaMT() {
        return notaMT;
    }

    public void setNotaMT(double notaMT) {
        this.notaMT = notaMT;
    }

    public double getNotaR() {
        return notaR;
    }

    public void setNotaR(double notaR) {
        this.notaR = notaR;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
