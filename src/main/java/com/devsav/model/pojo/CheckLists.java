package com.devsav.model.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "check_list")
public class CheckLists {
    public CheckLists() {
    }

    @XmlElement(name = "check")
    private List<CheckList> checks = new LinkedList<>();

    public void setChecks(List<CheckList> checks) {
        this.checks = checks;
    }
}
