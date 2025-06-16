package trabalhoM2;

public class Ingresso {
    // enum é um conjunto fixo e limitado de valores constantes
    public enum EnumTipoIngresso {
        ingressoInteiro,
        ingressoMeia
    }

    public enum EnumCategoriaIngresso {
        ingressoFisico,
        ingressoDigital
    }

    private EnumTipoIngresso tipo;
    private EnumCategoriaIngresso categoria;

    public Ingresso(EnumTipoIngresso tipo, EnumCategoriaIngresso categoria) {
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public EnumTipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoIngresso tipo) {
        this.tipo = tipo;
    }

    public EnumCategoriaIngresso getCategoria() {
        return categoria;
    }

    public void setCategoria(EnumCategoriaIngresso categoria) {
        this.categoria = categoria;
    }

}