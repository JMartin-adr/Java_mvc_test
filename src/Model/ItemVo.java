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
public class ItemVo {
    
    private String NoPart;
    private String Description;
    private String CodeSAT;
    private Integer IdEmpresa;

    public String getNoPart() {
        return NoPart;
    }
    public void setNoPart(String NoPart) {
        this.NoPart = NoPart;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCodeSAT() {
        return CodeSAT;
    }
    public void setCodeSAT(String CodeSAT) {
        this.CodeSAT = CodeSAT;
    }
    
    public Integer getIdEmpresa() {
        return IdEmpresa;
    }
    public void setIdEmpresa(Integer IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }
}
