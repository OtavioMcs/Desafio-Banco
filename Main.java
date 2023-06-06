import java.util.Scanner;

public class DesafioBanco {

    public static void infoClient(String nome, String conta, double saldo){
        System.out.println("******************************************");
        System.out.println("Informações do Cliente");
        System.out.println("Nome:               " + nome);
        System.out.println("Tipo de Conta:      " + conta);
        System.out.println("Saldo inicial:      " + saldo);
        System.out.println("******************************************");
        return;
    }

    public static void mostraMenu(){
        int menuNumber;
        Scanner input = new Scanner(System.in);
        String menu = """
                Operações
                
                1 - Consultar Saldo
                2 - Receber valor
                3 - Transferir valor
                4 - Sair o/
                
                Digite a opção desejada.""";
        System.out.println(menu);
        return;
    }

    public static void limpa(){
        for (int i = 0; i < 7; i++) {
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome, conta;
        double saldo = 0, valor = 0;
        int menu = 0;

        System.out.println("Insira seu nome. ");
        nome = input.nextLine();
        System.out.println("Insira seu tipo de conta. ");
        conta = input.nextLine();
        System.out.println("Insira seu saldo inicial. ");
        saldo = input.nextDouble();

        limpa();

        infoClient(nome, conta, saldo);
        mostraMenu();
        menu = input.nextInt();

        while (menu != 4){
            switch (menu){
                case 1:
                    System.out.println("O seu saldo é " + saldo + "\n");
                    mostraMenu();
                    menu = input.nextInt();
                    break;

                case 2:
                    System.out.println("Qual o valor que será recebido? ");
                    valor = input.nextDouble();
                    if(valor <= 0){
                        while(!(valor != 0)) {
                            System.out.println("Número inválido, tente novamente.");
                            valor = input.nextDouble();
                        }
                    }
                    saldo += valor;
                    System.out.println("Saldo atualizado para " + saldo + "\n");
                    mostraMenu();
                    menu = input.nextInt();
                    break;

                case 3:
                    System.out.println("Qual o valor que será transferido? ");
                    valor = input.nextDouble();
                    if(valor > saldo){
                        while(valor > saldo) {
                            System.out.println("O valor a ser transferido não disponível para tal atividade. Tente novamente. ");
                            valor = input.nextDouble();
                        }
                    }
                    saldo -= valor;
                    System.out.println("Saldo atualizado para " + saldo + "\n");
                    mostraMenu();
                    menu = input.nextInt();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente. \n");
                    mostraMenu();
                    menu = input.nextInt();
            }

        }
        System.out.println("Programa Finalizado! Obrigado, " + nome + "!");
    }
}
