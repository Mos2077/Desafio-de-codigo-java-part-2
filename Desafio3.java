import java.util.Scanner;

/** Classe base para descontos (aberto para extensões) */
class Discount {
  public double calculateDiscount(double originalValue) {
    return originalValue; // No default discount
  }
}

/** Classe derivada para desconto de estudante (10%). */
final class StudentDiscount extends Discount {
  @Override
  public double calculateDiscount(double originalValue) {
    return originalValue * 0.90; // 10% de desconto
  }
}

/** Classe derivada para desconto de afiliado (15%). */
final class MembershipDiscount extends Discount {
  @Override
  public double calculateDiscount(double originalValue) {
    return originalValue * 0.85; // 15% de desconto
  }
}

public class Main {
  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      String discountType = scanner.next();
      double originalValue = scanner.nextDouble();
  
      // Aplicação OCP: Criando uma instância com base no tipo de desconto fornecido
      Discount discount;
      if ("student".equals(discountType)) {
          discount = new StudentDiscount();
      } else if ("membership".equals(discountType)) {
          discount = new MembershipDiscount();
      } else {
          discount = new Discount();
      }
  
      double discountValue = discount.calculateDiscount(originalValue);
      System.out.printf("%.2f", discountValue);
    }
  }
}
