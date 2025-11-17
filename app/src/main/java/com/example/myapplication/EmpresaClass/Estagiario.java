package com.example.myapplication.EmpresaClass;

import static com.example.myapplication.EmpresaClass.FuncionariosActivity.txtEstagiario;

public class Estagiario extends Funcionario {
    public Estagiario(String nome, float salario_base) {
        super(nome, salario_base, horas_extras, bonus);
    }
    public static float Estagiario() {
        txtEstagiario.setText("Salário do Estagiário "+nome+": "+((salario_base*0.8)));
        return (float) (salario_base*0.8);
    }
}