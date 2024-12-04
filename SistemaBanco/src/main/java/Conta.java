import java.util.*;

public class Conta {
    int numero_conta;
    String titular_conta;
    double saldo;

    Scanner entrada = new Scanner(System.in);

    public Conta(String nome_titular, double saldo_inicial) {
        this.titular_conta = nome_titular;
        this.saldo = saldo_inicial;

        Random gerador_numero = new Random();
        numero_conta = gerador_numero.nextInt(1000);
    }

    public void VerSaldo() {
        System.out.println("O número da conta é: " + numero_conta);
        System.out.println("O nome do titular é: " + titular_conta);
        System.out.println("O saldo da conta é: " + saldo);
    }

    public void Saque(double valor_saque) {
        if (saldo >= valor_saque) {
            this.saldo = saldo - valor_saque;
            System.out.println("Seu saldo atual é de: " + saldo);
        } else {
            System.out.println("Seu saldo é insuficiente!");
        }
    }

    public void Deposito(double valor_deposito) {
        if (valor_deposito <= 0) {
            System.out.println("Depósito inválido");
        } else {
            this.saldo = saldo + valor_deposito;
            System.out.println("O seu depósito foi concluído");
            System.out.println("O seu saldo atual é " + saldo);
        }
    }

    public void Emprestimo(double valor_emprestimo) {
        if (valor_emprestimo <= saldo) {
            saldo += valor_emprestimo;
            System.out.println("Empréstimo aprovado!");
            System.out.println("Seu saldo atual é de: " + saldo);
        } else {
            System.out.println("O valor solicitado é maior que o saldo atual.");
        }
    }

    public void PagarBoleto(double valor_boleto) {
        if (saldo >= valor_boleto) {
            saldo -= valor_boleto;
            System.out.println("Pagamento do boleto realizado com sucesso.");
            System.out.println("Seu saldo atual é: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para pagar o boleto.");
        }
    }

    public void Iniciar() {
        int opcao;
        do {
            Exibir_menu();
            opcao = entrada.nextInt();
            Escolher_funcao(opcao);
        } while (opcao != 6);
    }

    public void Exibir_menu() {
        System.out.println("Bem vindo ao Banco Vouvi");
        System.out.println("Escolha a sua opção:");
        System.out.println("1 - Ver saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Solicitar Empréstimo");
        System.out.println("5 - Pagar Boleto");
        System.out.println("6 - Finalizar");
    }

    public void Escolher_funcao(int opcao) {
        double saque, deposito, emprestimo, boleto;

        switch (opcao) {
            case 1:
                VerSaldo();
                break;
            case 2:
                System.out.println("Digite o valor a ser sacado: ");
                saque = entrada.nextDouble();
                Saque(saque);
                break;
            case 3:
                System.out.println("Digite o valor a ser depositado: ");
                deposito = entrada.nextDouble();
                Deposito(deposito);
                break;
            case 4:
                System.out.println("Digite o valor do empréstimo solicitado: ");
                emprestimo = entrada.nextDouble();
                Emprestimo(emprestimo);
                break;
            case 5:
                System.out.println("Digite o valor do boleto a ser pago: ");
                boleto = entrada.nextDouble();
                PagarBoleto(boleto);
                break;
            case 6:
                System.out.println("Operação Finalizada");
                break;
            default:
                System.out.println("Digite uma opção válida");
        }
    }
}
