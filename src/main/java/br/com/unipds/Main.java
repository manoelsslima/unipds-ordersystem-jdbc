package br.com.unipds;

import br.com.unipds.model.User;
import br.com.unipds.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        String email = "manoel@teste.com";
        String nome = "Manoel";
        userRepository.save(new User(nome, email));
    }
}
