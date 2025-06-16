package trabalhoM2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- CINEMA UNIVALI (Simulação) ---");

        // 1. Criar salas
        Sala sala1 = new Sala(10, "CineMax", "Sala - VIP");
        Sala sala2 = new Sala(25, "2D", "Sala - 03");
        Sala sala3 = new Sala(20, "3D", "Sala - 01");
        Sala sala4 = new Sala(25, "2D", "Sala - 04");

        // 2. Criar filmes
        Filme filme1 = new Filme("Matrix", 136, Filme.EnumGeneroFilme.acao);
        Filme filme2 = new Filme("Oppenheimer", 180, Filme.EnumGeneroFilme.drama);
        Filme filme3 = new Filme("Quarteto - Fantástico", 136, Filme.EnumGeneroFilme.acao);

        // 3. Criar sessões
        ArrayList<Sessao> sessoes = new ArrayList<>();
        sessoes.add(new Sessao(filme1, sala1, 18));
        sessoes.add(new Sessao(filme2, sala2, 20));
        sessoes.add(new Sessao(filme2, sala3, 29));
        sessoes.add(new Sessao(filme3, sala4, 16));
        sessoes.add(new Sessao(filme3, sala3, 17));

        // 4. Ver sessões do dia
        System.out.println("\nSessões do dia:");
        for (int i = 0; i < sessoes.size(); i++) {
            Sessao s = sessoes.get(i);
            System.out.println(i + " - " + s.getFilme().getTitulo()
                    + " (" + s.getHorario() + "h)"
                    + " - Sala: " + s.getSala().getLocalizacao()
                    + " - Estado: " + (s.getEstadoDaSessao() ? "Em andamento" : "Não iniciada"));
        }

        // 5. Vender ingressos em sessões ainda não iniciadas
        System.out.println("\nVendendo ingressos:");
        sessoes.get(0).venderIngresso(Ingresso.EnumTipoIngresso.ingressoInteiro, Ingresso.EnumCategoriaIngresso.ingressoFisico);
        sessoes.get(0).venderIngresso(Ingresso.EnumTipoIngresso.ingressoMeia, Ingresso.EnumCategoriaIngresso.ingressoDigital);
        sessoes.get(1).venderIngresso(Ingresso.EnumTipoIngresso.ingressoMeia, Ingresso.EnumCategoriaIngresso.ingressoFisico);
        sessoes.get(2).venderIngresso(Ingresso.EnumTipoIngresso.ingressoInteiro, Ingresso.EnumCategoriaIngresso.ingressoDigital);

        // 6. Consultar cadeiras disponíveis
        System.out.println("\nConsultando cadeiras disponíveis:");
        for (int i = 0; i < sessoes.size(); i++) {
            System.out.println("Sessão " + i + ": " + sessoes.get(i).cadeirasDisponiveis() + " lugares livres.");
        }

        // 7. Iniciar sessões
        System.out.println("\nIniciando sessões:");
        sessoes.get(0).iniciarSessao();
        sessoes.get(1).iniciarSessao();
        sessoes.get(2).iniciarSessao();


        // 8. Tentar vender mais ingressos (sessões em andamento)
        System.out.println("\nTentando vender após início das sessões:");
        sessoes.get(0).venderIngresso(Ingresso.EnumTipoIngresso.ingressoInteiro, Ingresso.EnumCategoriaIngresso.ingressoFisico);

        // 9. Finalizar sessões
        System.out.println("\nFinalizando sessões:");
        sessoes.get(0).finalizarSessao();
        sessoes.get(1).finalizarSessao();
        sessoes.get(2).finalizarSessao();

        // 10. Estado final
        System.out.println("\nEstado final das sessões:");
        for (int i = 0; i < sessoes.size(); i++) {
            Sessao s = sessoes.get(i);
            System.out.println(i + " - " + s.getFilme().getTitulo()
                    + " - Estado: " + (s.getEstadoDaSessao() ? "Em andamento" : "Encerrada")
                    + " - Cadeiras livres: " + s.cadeirasDisponiveis());
        }
    }
}
