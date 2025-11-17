package com.example.myapplication.EmpresaClass;

import static com.example.myapplication.EmpresaClass.FuncionariosActivity.txtDesenvolvedor;
import static com.example.myapplication.EmpresaClass.HorasExtrasActivity.txtHoras;

public class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String nome, float salario_base, int horas_extras) {
        super(nome, salario_base, horas_extras, bonus);
    }
    public static float receber_horas(){
        horas_extras = Integer.parseInt(txtHoras.getText().toString());
        return horas_extras;
    }
    public static float Desenvolvedor() {
        txtDesenvolvedor.setText("Salário do Desenvolvedor "+nome+": "+(salario_base+(horas_extras*50)));
        return salario_base+(horas_extras*50);
    }
}