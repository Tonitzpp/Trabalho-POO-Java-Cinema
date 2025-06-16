package trabalhoM2;

public class Filme {
    public enum EnumGeneroFilme {
        acao,
        aventura,
        suspense,
        comedia,
        drama
    }
    private String titulo;
    private int duracao;
    private EnumGeneroFilme genero;

    public Filme(String titulo, int duracao, EnumGeneroFilme genero) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public EnumGeneroFilme getGenero() {
        return genero;
    }

    public void setGenero(EnumGeneroFilme genero) {
        this.genero = genero;
    }
}
