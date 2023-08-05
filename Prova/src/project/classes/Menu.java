package project.classes;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Gato> cadastros = new ArrayList<>();

    public int buscar(int ID) {
        for (int i = 0; i < cadastros.size(); i++) {
            if (cadastros.get(i).getID() == ID) {
                return i;
            }
        }

        return -1;
    }

    public void checkIn(int ID, String nomeGato, String nomeDono) throws Exception {
        if (buscar(ID) != -1)
            throw new Exception();

        else
            cadastros.add(new Gato(ID, nomeGato, nomeDono));
    }

    public void checkOut(int ID) throws Exception {
        int busca = buscar(ID);
        if (busca == -1)
            throw new Exception("\u001b[1;31mNão é possível deletar um cadastro inexistente.\u001b[m");

        else
            cadastros.remove(busca);
    }

    public List<Gato> getCadastros() {
        return cadastros;
    }

    /* Por questões de especialização de classe, o código abaixo foi ocultado.

    public void checkIn() throws Exception {
        System.out.print("Informe o ID da conta do gato: ");
        int id = input.nextInt();

        System.out.print("Informe o nome do gato: ");
        String nomeGato = input.nextLine();

        System.out.print("Informe o nome do dono do gato: ");
        String nomeDono = input.nextLine();

        for (Gato gato : cadastros) {
            if (gato.getID() == id) {
                throw new Exception("\u001b[1;31mERRO: Gato já cadastrado.\u001b[m");
            } else {
                cadastros.add(new Gato(id, nomeGato, nomeDono));
            }
        }
    }
    */
}
