import java.util.Scanner;

interface Notificacao {
  void enviar(String mensagem);
}

class NotificacaoEmailImpl implements Notificacao {
  @Override
  public void enviar(String mensagem) {
    System.out.println("Email enviado: %s".formatted(mensagem));
  }
}

class NotificacaoSMSImpl implements Notificacao {
  @Override
  public void enviar(String mensagem) {
    System.out.println("SMS enviado: %s".formatted(mensagem));
  }
}

public class Principal {
  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      String[] entradas = scanner.nextLine().split(", ");
  
      String tipoNotificacao = entradas[0];
      String mensagem = entradas[1];
  
      Notificacao notificacao;
      switch (tipoNotificacao) {
        case "email":
          notificacao = new NotificacaoEmailImpl();
          break;
        case "sms":
          notificacao = new NotificacaoSMSImpl();
          break;
        default:
          System.out.println("Tipo de notificacao invalido.");
          return;
      }
      notificacao.enviar(mensagem);
    }
  }
}
