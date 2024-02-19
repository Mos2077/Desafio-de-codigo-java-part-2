import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Aluno {
    private String nome;
    private String id;

    public Aluno(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}

class RegistroAluno {
    private List<Aluno> alunosRegistrados;

    public RegistroAluno() {
        this.alunosRegistrados = new ArrayList<>();
        this.alunosRegistrados.add(new Aluno("João", "123"));
    }

    public String adicionarAluno(Aluno aluno) {
        if (alunoJaRegistrado(aluno)) {
            return "Aluno ja registrado.";
        } else {
            this.alunosRegistrados.add(aluno);
            return aluno.getNome() + " adicionado.";
        }
    }

    private boolean alunoJaRegistrado(Aluno aluno) {
        return alunosRegistrados.stream().anyMatch(a -> a.getId().equals(aluno.getId()));
    }
}

class MensagemHandler {
    public static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroAluno registroAluno = new RegistroAluno();

        String input = scanner.nextLine();
        String[] dadosAluno = input.split(", ");
        Aluno aluno = new Aluno(dadosAluno[0], dadosAluno[1]);

        String mensagem = registroAluno.adicionarAluno(aluno);
        MensagemHandler.exibirMensagem(mensagem);

        scanner.close();
    }
}
