/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pneditor.editor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.JOptionPane;
import org.pneditor.editor.Root;
import org.pneditor.editor.commands.SetArcConditionCommand;
import org.pneditor.editor.commands.SetLabelCommand;
import org.pneditor.editor.commands.SetTransitionConditionCommand;
import org.pneditor.petrinet.Arc;
import org.pneditor.petrinet.Node;
import org.pneditor.petrinet.Transition;
import org.pneditor.util.GraphicsTools;

/**
 *
 * @author nemec_000
 */
public class SetTransitionConditionAction extends AbstractAction {
    
    private Root root;
    
    public SetTransitionConditionAction(Root root) {
        this.root = root;
        String name = "Set transition condition";
        putValue(NAME, name);
        putValue(SMALL_ICON, GraphicsTools.getIcon("pneditor/label.gif"));
        putValue(SHORT_DESCRIPTION, name);
        putValue(MNEMONIC_KEY, KeyEvent.VK_M);
//		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("M"));
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (root.getClickedElement() != null) {
            if (root.getClickedElement() instanceof Node) {
                
                Transition transition = (Transition) root.getClickedElement();
                String condition = transition.getCondition();
                String response = JOptionPane.showInputDialog(root.getParentFrame(), "Condition:", condition);
                if (response != null) {
                    condition = response;
                }

                if (transition.getCondition() != condition) {
                    root.getUndoManager().executeCommand(new SetTransitionConditionCommand(transition, condition));
                }
            }
        }
    }
    
}
