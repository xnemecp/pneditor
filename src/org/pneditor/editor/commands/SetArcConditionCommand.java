/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pneditor.editor.commands;

import org.pneditor.petrinet.Arc;
import org.pneditor.util.Command;

/**
 *
 * @author nemec_000
 */
public class SetArcConditionCommand implements Command {
    
    private Arc arc;
    private String newCondition;
    private String oldCondition;
    
    public SetArcConditionCommand(Arc arc, String newCondition) {
        this.arc = arc;
        this.newCondition = newCondition;
    }
    
     public void execute() {
        oldCondition = arc.getCondition();
        arc.setCondition(newCondition);
    }

    public void undo() {
        arc.setCondition(oldCondition);
    }

    public void redo() {
        execute();
    }

    @Override
    public String toString() {
        return "Set arc condition";
    }
}
