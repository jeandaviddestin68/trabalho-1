import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<CaixaEletronica> listaCaixas = new ArrayList<>();
        CaixaEletronica caixa1 = new CaixaEletronica();
        Cartao cartaoJean = new Cartao();
        Cartao cartaoJd = new Cartao();

        // Criando o cartão
        cartaoJean.setId(1);
        cartaoJean.setNomeDententor("Jean David Destin");
        cartaoJean.setNumeroCartao("5179 0448 0405 0468");;
        cartaoJean.setAgencia(1234);;
        cartaoJean.setConta(1234);;
        cartaoJean.setDigito(3);;
        cartaoJean.setCvv(385);
        cartaoJean.setSaldo(12000000.54);
        cartaoJean.setValidade("10/2024");

        cartaoJd.setId(2);
        cartaoJd.setNomeDententor("JD Marvin");
        cartaoJd.setNumeroCartao("5179 0448 0405 0458");;
        cartaoJd.setAgencia(1234);;
        cartaoJd.setConta(1234);;
        cartaoJd.setDigito(3);;
        cartaoJd.setCvv(168);
        cartaoJd.setSaldo(120.54);
        cartaoJd.setValidade("10/2028");

        caixa1.id = 1;
        caixa1.setSaldo(100000.50f);
        caixa1.conta.add(cartaoJean);
        caixa1.conta.add(cartaoJd);
        listaCaixas.add(caixa1);

        // Validação da conta
        Scanner numero = new Scanner(System.in);
        System.out.println("Digite o numero do seu cartão:");
        String numero_cartao = numero.nextLine();

        List<Cartao> filtrados = listaCaixas.stream()
            .flatMap(caixa -> caixa.getCartao().stream())
            .filter(card -> card.getNumeroCartao().equals(numero_cartao))
            .collect(Collectors.toList());
        
        if (!filtrados.isEmpty()) {
            Scanner cvv = new Scanner(System.in);
            System.out.println("Digite o cvv do seu cartão para continuar:");
            int numeroCvv = cvv.nextInt();
            Cartao conta = filtrados.get(0);

            if (numeroCvv == conta.getCvv()) {
                System.out.println("Seja bem vindo o seu saldo é: R$ "+ conta.getSaldo());
                System.out.println("Deseja sacar um valor?");
            } else {
                System.out.println("Houve um erro entre em contato com o seu banco");
            }

            cvv.close();
        } else {
            System.out.println("Cartão não encontrado!");
        }
        
        numero.close();
    }
}
