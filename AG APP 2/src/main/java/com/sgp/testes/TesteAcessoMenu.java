package com.sgp.testes;

import java.util.Scanner;

import com.sgp.modelos.Computador;
import com.sgp.util.Validacoes;

public class TesteAcessoMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Computador computador = new Computador("Samsung", "AMD Ryzen 5", 16, 3200.0);
        int opcao;

        do {
            imprimirMenu();
            opcao = recebeOp(scanner);

            switch (opcao) {
                case 1:
                    System.out.println(computador.toString());
                    break;
                case 2:
                    alterarMarca(computador, scanner);
                    break;
                case 3:
                    alterarProcessador(computador, scanner);
                    break;
                case 4:
                    alterarMemoriaRam(computador, scanner);
                    break;
                case 5:
                    alterarPreço(computador, scanner);
                    break;
                case 6:
                    computador.exibirEspecificacoes();
                    break;
                case 7:
                    verificarUpgrade(computador, scanner);
                    break;
                case 0:
                    System.out.println("Programa finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void imprimirMenu() {
        System.out.println("\n=== Menu de Acesso - Computador ===");
        System.out.println("1. Mostrar dados do computador");
        System.out.println("2. Alterar marca");
        System.out.println("3. Alterar processador");
        System.out.println("4. Alterar memória RAM");
        System.out.println("5. Alterar preço");
        System.out.println("6. Exibir especificações detalhadas");
        System.out.println("7. Verificar necessidade de upgrade de RAM");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static int recebeOp(Scanner scanner) {
        int opcao;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um número válido!");
            opcao = -1;
        }
        return opcao;
    }

    public static void alterarMarca(Computador computador, Scanner scanner) {
        System.out.print("Digite a nova marca: ");
        String novaMarca = scanner.nextLine();
        if (Validacoes.marcaValida(novaMarca)) {
            computador.setMarca(novaMarca);
            System.out.println("Marca alterada com sucesso!");
        } else {
            System.out.println(Validacoes.mensagemErroMarca(novaMarca));
        }
    }

    public static void alterarProcessador(Computador computador, Scanner scanner) {
        System.out.print("Digite o novo processador: ");
        String novoProcessador = scanner.nextLine();
        if (Validacoes.processadorValido(novoProcessador)) {
            computador.setProcessador(novoProcessador);
            System.out.println("Processador alterado com sucesso!");
        } else {
            System.out.println(Validacoes.mensagemErroProcessador(novoProcessador));
        }
    }

    public static void alterarMemoriaRam(Computador computador, Scanner scanner) {
        System.out.print("Digite a nova memória RAM (em GB): ");
        try {
            int novaRam = Integer.parseInt(scanner.nextLine());
            if (Validacoes.memoriaRamValida(novaRam)) {
                computador.setMemoriaRam(novaRam);
                System.out.println("Memória RAM alterada com sucesso!");
            } else {
                System.out.println(Validacoes.mensagemErroMemoriaRam(novaRam));
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Por favor, digite um número inteiro válido!");
        }
    }

    public static void alterarPreço(Computador computador, Scanner scanner) {
        System.out.print("Digite o novo preço (ex: 3200.00): ");
        try {
            double novoPreço = Double.parseDouble(scanner.nextLine());
            if (Validacoes.preçoValido(novoPreço)) {
                computador.setPreço(novoPreço);
                System.out.println("Preço alterado com sucesso!");
            } else {
                System.out.println(Validacoes.mensagemErroPreço(novoPreço));
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Por favor, digite um número válido para o preço!");
        }
    }

    public static void verificarUpgrade(Computador computador, Scanner scanner) {
        System.out.print("Digite a memória RAM mínima desejada (em GB): ");
        try {
            int ramMinima = Integer.parseInt(scanner.nextLine());
            if (computador.precisaUpgrade(ramMinima)) {
                System.out.println("O computador precisa de upgrade! RAM atual: " +
                        computador.getMemoriaRam() + " GB, mínimo desejado: " + ramMinima + " GB.");
            } else {
                System.out.println("O computador não precisa de upgrade. RAM atual: " +
                        computador.getMemoriaRam() + " GB é suficiente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Por favor, digite um número inteiro válido!");
        }
    }
}