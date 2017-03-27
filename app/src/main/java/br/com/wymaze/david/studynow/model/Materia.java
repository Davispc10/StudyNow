package br.com.wymaze.david.studynow.model;

import com.orm.SugarRecord;

/**
 * Created by davispc10 on 26/03/17.
 */

public class Materia extends SugarRecord {
    private Long id;
    private Rotina rotina;
    private String descricao;

    public Materia(Long id, String descricao, Rotina rotina) {
        this.descricao = descricao;
        this.id = id;
        this.rotina = rotina;
    }

    public Materia() {

    }
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
