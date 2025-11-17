package com.example.myapplication.EmpresaClass;


import static com.example.myapplication.EmpresaClass.FuncionariosActivity.txtFuncionarioBase;
import static com.example.myapplication.EmpresaClass.SalarioBaseActivity.txtReceberSalarioBase;


public class Funcionario {

    public static String nome = "Rafael";
    public static float salario_base = 0;
    public static float bonus = 0;
    public static int horas_extras = 0;

    public Funcionario(String nome, float salario_base, int horas_extras, float bonus) {
        this.nome = nome;
        this.salario_base = salario_base;
        this.horas_extras = horas_extras;
        this.bonus = bonus;
    }
    public static float FuncionarioBase() {
        txtFuncionarioBase.setText("Salário do Funcionário "+nome+": "+salario_base);
        return salario_base;
    }
    public static float receber_salario(){
        salario_base = Float.parseFloat(txtReceberSalarioBase.getText().toString());
        return salario_base;
    }
    public static float calcular_salario() {
        txtFuncionarioBase.setText("Salário do funcionario "+nome+": "+salario_base);
        return salario_base;
    }
}