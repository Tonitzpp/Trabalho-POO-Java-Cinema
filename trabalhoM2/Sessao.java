package trabalhoM2;

import java.util.ArrayList;

public class Sessao {
    private boolean estadoDaSessao;
    private int horario;
    private Filme filme; // parte de agregação
    private Sala sala;   // parte de agregação
    private ArrayList<Ingresso> ingressosDisponiveis; // parte de composição

    public Sessao(Filme filme, Sala sala, int horario) {
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
        this.estadoDaSessao = false;

        ingressosDisponiveis = new ArrayList<>();

        // Criação interna dos ingressos
        for (int i = 0; i < sala.getnAssentos(); i++) {
            ingressosDisponiveis.add(
                    new Ingresso(Ingresso.EnumTipoIngresso.ingressoInteiro,
                            Ingresso.EnumCategoriaIngresso.ingressoFisico)
            );
        }
    }

    public void registrarFilme() {
        System.out.println("Filme registrado: " + filme.getTitulo());
    }

    public int cadeirasDisponiveis() {
        return ingressosDisponiveis.size();
    }

    public boolean venderIngresso(Ingresso.EnumTipoIngresso tipo, Ingresso.EnumCategoriaIngresso categoria) {
        if (!estadoDaSessao && !ingressosDisponiveis.isEmpty()) {
            Ingresso ingresso = ingressosDisponiveis.remove(0);
            ingresso.setTipo(tipo);
            ingresso.setCategoria(categoria);
            System.out.println("Ingresso vendido: " + tipo + " / " + categoria);
            return true;
        } else {
            System.out.println("Venda não realizada: sessão encerrada ou ingressos esgotados.");
            return false;
        }
    }

    public void iniciarSessao() {
        if (!estadoDaSessao) {
            estadoDaSessao = true;
            System.out.println("Sessão iniciada.");
        }
    }

    public void finalizarSessao() {
        if (estadoDaSessao) {
            estadoDaSessao = false;
            System.out.println("Sessão finalizada.");
        }
    }

    public boolean getEstadoDaSessao() {
        return estadoDaSessao;
    }

    public int getHorario() {
        return horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public Sala getSala() {
        return sala;
    }
}
