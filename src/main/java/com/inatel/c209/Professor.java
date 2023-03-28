package com.inatel.c209;

import java.util.Objects;
public class Professor {
    private String nome;
    private String horarioDeAtendimento;
    private String periodo;
    private String sala;
    private String predio;

    public Professor(String nome, String horarioDeAtendimento, String periodo, String sala, String predio) {
        this.nome = nome;
        this.horarioDeAtendimento = horarioDeAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorarioDeAtendimento() {
        return horarioDeAtendimento;
    }

    public void setHorarioDeAtendimento(String horarioDeAtendimento) {
        this.horarioDeAtendimento = horarioDeAtendimento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(nome, professor.nome) && Objects.equals(horarioDeAtendimento, professor.horarioDeAtendimento) && Objects.equals(periodo, professor.periodo) && Objects.equals(sala, professor.sala) && Objects.equals(predio, professor.predio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, horarioDeAtendimento, periodo, sala, predio);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", horarioDeAtendimento='" + horarioDeAtendimento + '\'' +
                ", periodo='" + periodo + '\'' +
                ", sala='" + sala + '\'' +
                ", predio='" + predio + '\'' +
                '}';
    }
}
