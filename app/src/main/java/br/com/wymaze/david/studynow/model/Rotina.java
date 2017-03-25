package br.com.wymaze.david.studynow.model;

import com.orm.SugarRecord;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by davispc10 on 24/03/17.
 */

public class Rotina extends SugarRecord {
  private Date hora;
  private Integer seg, ter, qua, qui, sex, sab, dom;
  private ArrayList<String> materia;
  private String descricao;

    public Rotina() {

    }

  public Rotina(Date hora, Integer seg, Integer ter, Integer qua, Integer qui, Integer sex, Integer sab, Integer dom, ArrayList<String> materia, String descricao) {
        this.hora = hora;
        this.seg = seg;
        this.ter = ter;
        this.qua = qua;
        this.qui = qui;
        this.sex = sex;
        this.sab = sab;
        this.dom = dom;
        this.materia = materia;
        this.descricao = descricao;
  }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Integer getSeg() {
        return seg;
    }

    public void setSeg(Integer seg) {
        this.seg = seg;
    }

    public Integer getTer() {
        return ter;
    }

    public void setTer(Integer ter) {
        this.ter = ter;
    }

    public Integer getQua() {
        return qua;
    }

    public void setQua(Integer qua) {
        this.qua = qua;
    }

    public Integer getQui() {
        return qui;
    }

    public void setQui(Integer qui) {
        this.qui = qui;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSab() {
        return sab;
    }

    public void setSab(Integer sab) {
        this.sab = sab;
    }

    public Integer getDom() {
        return dom;
    }

    public void setDom(Integer dom) {
        this.dom = dom;
    }

    public ArrayList<String> getMateria() {
        return materia;
    }

    public void setMateria(ArrayList<String> materia) {
        this.materia = materia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
