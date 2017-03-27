package br.com.wymaze.david.studynow.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by davispc10 on 24/03/17.
 */

public class Rotina extends SugarRecord {
  private String time1, time2;
  private Integer seg, ter, qua, qui, sex, sab, dom;
  private String descricao;

    public Rotina() {

    }

    public Rotina(String time1, String time2, Integer seg, Integer ter, Integer qua, Integer qui, Integer sex, Integer sab, Integer dom, String descricao) {
        this.time1 = time1;
        this.time2 = time2;
        this.seg = seg;
        this.ter = ter;
        this.qua = qua;
        this.qui = qui;
        this.sex = sex;
        this.sab = sab;
        this.dom = dom;
        this.descricao = descricao;
    }

    public List<Materia> getMaterias() {
        return Materia.find(Materia.class, "id = ?", String.valueOf(getId()));
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }
}
