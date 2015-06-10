/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pneditor.editor.commands;

import org.pneditor.petrinet.Arc;
import org.pneditor.petrinet.Transition;
import org.pneditor.util.Command;

/**
 *
 * @author nemec_000
 */
public class SetTransitionConditionCommand implements Command {
    
    private Transition transition;
    private String newCondition;
    private String oldCondition;
    
    public SetTransitionConditionCommand(Transition transition, String newCondition) {
        this.transition = transition;
        this.newCondition = newCondition;
    }
    
     public void execute() {
        oldCondition = transition.getCondition();
        transition.setCondition(newCondition);
    }

    public void undo() {
        transition.setCondition(oldCondition);
    }

    public void redo() {
        execute();
    }

    @Override
    public String toString() {
        return "Set transition condition";
    }
}
