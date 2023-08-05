package project.main;

import project.classes.Menu;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        int option;
        int id, n;

        do {
            System.out.println("========== HOTEL DOS GATOS ==========");

            System.out.print(
                """
                \u001b[1;34m[ 1 ]\u001b[m Check In
                \u001b[1;34m[ 2 ]\u001b[m Buscar
                \u001b[1;34m[ 3 ]\u001b[m Editar
                \u001b[1;34m[ 4 ]\u001b[m Check Out
                \u001b[1;31m[ 0 ]\u001b[m Sair
                """
            );
            System.out.print("\u001b[1;32m>>> \u001b[m");
            option = input.nextInt();
            
            switch (option) {
                case 1 -> {
                    System.out.println("========== CHECK IN ==========");
                    System.out.print("Quantos gatos você quer cadastrar? ");
                    n = input.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.printf("--- Gato %d ---%n", i + 1);
                        System.out.print("ID: ");
                        int ID = input.nextInt();

                        input.nextLine();
                        System.out.print("Nome do gato: ");
                        String nomeGato = input.nextLine();

                        System.out.print("Nome do dono: ");
                        String nomeDono = input.nextLine();

                        try {
                            menu.checkIn(ID, nomeGato, nomeDono);
                        } catch (Exception e) {
                            System.out.println("\u001b[1;31mERRO: ID já cadastrado.\u001b[m");
                            i--;
                            Thread.sleep(800);
                        }
                    }
                    System.out.println("=============================");
                    for (int i = 0; i < menu.getCadastros().size(); i++) {
                        System.out.printf("---GATO %d---%n", i + 1);
                        System.out.println(menu.getCadastros().get(i));
                    }
                }

                case 2 -> {
                    System.out.println("========== BUSCA ==========");
                    System.out.print("Informe o ID a ser buscado: ");
                    id = input.nextInt();
                    int busca = menu.buscar(id);
                    if (busca != -1) {
                        System.out.println("\u001b[1;32mGato encontrado!\u001b[m\n");
                        Thread.sleep(800);

                        System.out.println(menu.getCadastros().get(busca));
                        Thread.sleep(800);
                    } else {
                        System.out.println("\u001b[1;31mGato não encontrado.\u001b[m\n");
                        Thread.sleep(800);
                    }
                }
                
                case 3 -> {
                    System.out.println("============ EDITAR ============");
                    System.out.print("ID: ");
                    id = input.nextInt();
                    int busca = menu.buscar(id);

                    if (busca != -1) {
                        int editOption = 0;
                        String newNomeGato = null;
                        String newNomeDono = null;
                        editLoop: while (true) {
                            System.out.print(
                                """
                                \u001b[1;34m[ 1 ]\u001b[m Editar nome Gato
                                \u001b[1;34m[ 2 ]\u001b[m Editar nome Dono
                                \u001b[1;31m[ 0 ]\u001b[m Sair
                                """
                            );

                            System.out.print("\u001b[1;32m>>>\u001b[m ");
                            
                            editOption = input.nextInt();
                            input.nextLine();

                            switch (editOption) {
                                case 1 -> {
                                    System.out.print("Novo Nome para o gato: ");
                                    newNomeGato = input.nextLine();
                                    menu.getCadastros().get(busca).setNomeGato(newNomeGato);
                                }

                                case 2 -> {
                                    System.out.print("Novo Nome para dono: ");
                                    newNomeDono = input.nextLine();
                                    menu.getCadastros().get(busca).setNomeDono(newNomeDono);
                                }

                                case 0 -> {
                                    System.out.println("Edição finalizada.");
                                    break editLoop;
                                }
                            }
                        }
                    }

                    else {
                        System.out.println("\u001b[1;31mErro: gato não encontrado para editar.\u001b[m");
                    }
                } 

                case 4 -> {
                    System.out.println("========== CHECK OUT ==========");
                    System.out.print("ID: ");
                    id = input.nextInt();
                    try {
                        menu.checkOut(id);
                        System.out.println("\u001b[1;32mCheck out realizado com sucesso!\u001b[m");
                        Thread.sleep(800);
                    } catch (Exception e) {
                        System.out.println("\u001b[1;31mERRO: ID inexistente.\u001b[m");
                        Thread.sleep(800);
                    }
                    System.out.println("=============================");
                }

                case 0 -> System.out.println("Volte sempre! :D");

                default -> {
                    System.out.println("\u001b[1;31mOpção inválida.\u001b[m");
                    Thread.sleep(800);
                }
            }
        } while (option != 0);

        Thread.sleep(1000);

        input.close();
    }
}