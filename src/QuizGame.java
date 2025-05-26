import java.util.*;

public class QuizGame {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String jogarNovamente = "S";

    List<List<String>> perguntas = GerenciadorDePerguntas.getTodasAsPerguntas();

    while (jogarNovamente.equals("S")) {
      boolean isLetraCerta;
      boolean isSimOuNao;
      int pontuacao = 0;
      int count = 0;
      String respostaUsuario;

      List<Integer> indices = new ArrayList<>();
      for (int i = 0; i < perguntas.size(); i++) {
        indices.add(i);
      }
      Collections.shuffle(indices); // Embaralha a ordem das perguntas

      System.out.println("-----------------------------------");
      System.out.println("Bem-Vindo ao Perguntas e Respostas!");
      System.out.println("-----------------------------------");

      for (int i = 0; i < perguntas.size(); i++) {
        int perguntaIndex = indices.get(i); // Pega uma pergunta aleatória sem repetição
        List<String> pergunta = perguntas.get(perguntaIndex);

        System.out.println((i + 1) + " - " + pergunta.getFirst());

        List<String> alternativas = new ArrayList<>(pergunta.subList(1, pergunta.size()));
        Collections.shuffle(alternativas); // Embaralha as alternativas

        String[] letras = {"A", "B", "C", "D"};
        String respostaCorreta = "";

        for (int j = 0; j < 4; j++) {
          System.out.println(letras[j] + ") " + alternativas.get(j));
          if (alternativas.get(j).equals(pergunta.get(1))) { // Verifica qual é a resposta correta
            respostaCorreta = letras[j];
          }
        }
        do {
          isLetraCerta = false;
          System.out.print("Digite a letra da resposta correta: ");
          respostaUsuario = validaLetra(scan.next());
            for (String letra : letras) {
                if (respostaUsuario.equals(letra)) {
                    isLetraCerta = true;
                    break;
                }
            }
          if(!isLetraCerta) {
            System.out.println("Opção inválida. Digite uma opção válida");
          }
        } while (!isLetraCerta);

        if (respostaUsuario.equals(respostaCorreta)) {
          System.out.println("Certa a resposta!!!!!");
          pontuacao++;
        } else {
          System.out.println("Errou!! A resposta correta era: " + respostaCorreta);
        }

        System.out.println("-------------------------------------------");
        count++;
        if (count >= 5) {
          System.out.println("Fim de Jogo!");
          break;
        }
      }

      System.out.println("Sua pontuação foi de: " + pontuacao + " pontos");

      do {
        System.out.println("Deseja jogar novamente? (s/n)");

        jogarNovamente = validaLetra(scan.next());

         isSimOuNao = jogarNovamente.equals("S") || jogarNovamente.equals("N");
         if (!isSimOuNao) {
           System.out.println("Você não digitou S ou N");
         }
      } while (!isSimOuNao);
    }
    scan.close();
  }
  public static String validaLetra(String letra) {
    return String.valueOf(letra.toUpperCase().charAt(0));
  }
}