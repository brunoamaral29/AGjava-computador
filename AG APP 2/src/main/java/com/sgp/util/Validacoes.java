package com.sgp.util;

public class Validacoes {

    private Validacoes() {
    }

    public static boolean marcaValida(String marca) {
        return !(marca == null || marca.trim().isEmpty() || marca.matches(".*\\d+.*"));
    }

    public static String mensagemErroMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            return "Erro: A marca não pode estar vazia!";
        } else if (marca.matches(".*\\d+.*")) {
            return "Erro: A marca não pode conter números!";
        }
        return "";
    }

    public static boolean processadorValido(String processador) {
        return !(processador == null || processador.trim().isEmpty());
    }

    public static String mensagemErroProcessador(String processador) {
        if (processador == null || processador.trim().isEmpty()) {
            return "Erro: O processador não pode estar vazio!";
        }
        return "";
    }

    public static boolean memoriaRamValida(int memoriaRam) {
        return memoriaRam >= 1 && memoriaRam <= 512;
    }

    public static String mensagemErroMemoriaRam(int memoriaRam) {
        if (memoriaRam < 1) {
            return "Erro: A memória RAM deve ser de pelo menos 1 GB!";
        } else if (memoriaRam > 512) {
            return "Erro: Valor de memória RAM inválido!";
        }
        return "";
    }

    public static boolean preçoValido(double preço) {
        return preço >= 0.0 && preço <= 100000.0;
    }

    public static String mensagemErroPreço(double preço) {
        if (preço < 0.0) {
            return "Erro: O preço não pode ser negativo!";
        } else if (preço > 100000.0) {
            return "Erro: Preço inválido!";
        }
        return "";
    }
}