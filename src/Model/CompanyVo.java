/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Martin3
 */
public class CompanyVo {
    private String name;
    private Integer id;

    public CompanyVo (String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public Integer getCodigo() {
        return id;
    }

    @Override
    public String toString(){
      return name;
    }
}
