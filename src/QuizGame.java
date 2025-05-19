import java.util.*;

public class QuizGame {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String jogarNovamente = "S";

    while (jogarNovamente.equals("S")) {
      boolean isLetraCerta = false;
      boolean isSimOuNao;
      int pontuacao = 0;
      int count = 0;
      String respostaUsuario = "";

      // Criando perguntas e respostas usando List
      List<List<String>> perguntas = new ArrayList<>();
      perguntas.add(Arrays.asList("O que significa a sigla HTML?", "HyperText Markup Language", "HighText Machine Language", "Hyperlink and Text Management Language", "Home Tool Markup Language"));
      perguntas.add(Arrays.asList("Qual destes é um framework JavaScript para front-end?", "React", "Django", "Laravel", "Spring"));
      perguntas.add(Arrays.asList("Qual linguagem é mais comumente usada para desenvolvimento de aplicativos Android nativos?", "Kotlin", "Swift", "JavaScript", "Ruby"));
      perguntas.add(Arrays.asList("O que faz a função `len()` em Python?", "Retorna o tamanho de um objeto", "Concatena duas strings", "Cria uma lista vazia", "Converte um número em string"));
      perguntas.add(Arrays.asList("Qual destas é uma característica do paradigma de programação orientada a objetos?", "Encapsulamento", "Programação Funcional", "Recursividade", "Programação Lógica"));

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
          System.out.print("Digite a letra da resposta correta: ");
          respostaUsuario = validaLetra(scan.next());
          for(int j = 0; j < letras.length; j++) {
            if(respostaUsuario.equals(letras[j])) {
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
        if (count >= 2) {
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