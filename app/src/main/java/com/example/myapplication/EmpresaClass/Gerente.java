package com.example.myapplication.EmpresaClass;

import static com.example.myapplication.EmpresaClass.BonusGerenteActivity.txtBonus;
import static com.example.myapplication.EmpresaClass.FuncionariosActivity.txtGerente;

public class Gerente extends Funcionario {
    public Gerente(String nome, float salario_base, float bonus) {
        super(nome, salario_base, horas_extras, bonus);
    }
    public static float receber_bonus(){
        bonus = Float.parseFloat(txtBonus.getText().toString());
        return bonus;
    }
    public static float Gerente() {
        txtGerente.setText("Salário do Gerente "+nome+": "+(salario_base+bonus));
        return salario_base+bonus;
    }
}