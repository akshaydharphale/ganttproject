/*
GanttProject is an opensource project management tool. License: GPL3
Copyright (C) 2011 GanttProject Team

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 3
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
package net.sourceforge.ganttproject.action.resource;

import javax.swing.AbstractAction;

import net.sourceforge.ganttproject.GanttProject;
import net.sourceforge.ganttproject.ResourceTreeTable;
import net.sourceforge.ganttproject.action.resource.ResourceDeleteAction;
import net.sourceforge.ganttproject.action.resource.ResourceNewAction;
import net.sourceforge.ganttproject.gui.UIFacade;
import net.sourceforge.ganttproject.resource.AssignmentContext;
import net.sourceforge.ganttproject.resource.ResourceContext;
import net.sourceforge.ganttproject.resource.HumanResourceManager;

public class ResourceActionSet {
    private final ResourceNewAction myResourceNewAction;

    private final ResourceDeleteAction myResourceDeleteAction;

    private final ResourcePropertiesAction myResourcePropertiesAction;

    private final ResourceMoveUpAction myResourceMoveUpAction;

    private final ResourceMoveDownAction myResourceMoveDownAction;

    private final ResourceSendMailAction myResourceSendMailAction;

    private final ResourceImportAction myResourceImportAction;

    private final AssignmentDeleteAction myAssignmentDelete;

    private AbstractAction[] myActions;

    public ResourceActionSet(ResourceContext resourceContext, AssignmentContext assignmentContext, GanttProject projectFrame, UIFacade uiFacade, ResourceTreeTable table) {
        HumanResourceManager manager = projectFrame.getHumanResourceManager();
        myResourceNewAction = new ResourceNewAction(manager, projectFrame.getRoleManager(), uiFacade);
        myResourceDeleteAction = new ResourceDeleteAction(manager, resourceContext, projectFrame, uiFacade);
        myResourcePropertiesAction = new ResourcePropertiesAction(projectFrame, resourceContext, uiFacade);
        myResourceMoveUpAction = new ResourceMoveUpAction(table);
        myResourceMoveDownAction = new ResourceMoveDownAction(table);
        myResourceSendMailAction = new ResourceSendMailAction(table);
        myResourceImportAction = new ResourceImportAction(manager, projectFrame.getTaskManager(), projectFrame
                .getRoleManager(), projectFrame);
        myAssignmentDelete = new AssignmentDeleteAction(assignmentContext, uiFacade);
    }

    public AbstractAction[] getActions() {
        if (myActions == null) {
            myActions = new AbstractAction[] { myResourceNewAction, myResourcePropertiesAction };
        }
        return myActions;
    }

    public ResourceNewAction getResourceNewAction() {
        return myResourceNewAction;
    }

    public ResourceDeleteAction getResourceDeleteAction() {
        return myResourceDeleteAction;
    }

    public ResourcePropertiesAction getResourcePropertiesAction() {
        return myResourcePropertiesAction;
    }

    public ResourceMoveUpAction getResourceMoveUpAction() {
        return myResourceMoveUpAction;
    }

    public ResourceMoveDownAction getResourceMoveDownAction() {
        return myResourceMoveDownAction;
    }

    public ResourceSendMailAction getResourceSendMailAction() {
        return myResourceSendMailAction;
    }

    public ResourceImportAction getResourceImportAction() {
        return myResourceImportAction;
    }

    public AssignmentDeleteAction getAssignmentDelete() {
        return myAssignmentDelete;
    }
}
