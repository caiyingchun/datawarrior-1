/*
 * Copyright 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland
 *
 * This file is part of DataWarrior.
 * 
 * DataWarrior is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * DataWarrior is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with DataWarrior.
 * If not, see http://www.gnu.org/licenses/.
 *
 * @author Thomas Sander
 */

package com.actelion.research.datawarrior.task.view;

import com.actelion.research.datawarrior.DEMainPane;
import com.actelion.research.datawarrior.task.AbstractViewTask;
import com.actelion.research.table.view.CompoundTableView;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class DETaskSelectView extends AbstractViewTask {
	public static final String TASK_NAME = "Select View";

	public DETaskSelectView(Frame parent, DEMainPane mainPane, CompoundTableView view) {
		super(parent, mainPane, view);
		}

	@Override
	public boolean isViewTaskWithoutConfiguration() {
		return true;
		}

    @Override
    public boolean allowsSelectedView() { return false; }

    @Override
	public JComponent createInnerDialogContent() {
		return null;
		}

	@Override
	public String getTaskName() {
		return TASK_NAME;
		}

	@Override
	public boolean isRedundant(Properties previousConfiguration, Properties currentConfiguration) {
		return true;
		}

	@Override
	public void runTask(Properties configuration) {
		String viewName = getConfiguredViewName(configuration);
		getMainPane().selectDockable(getMainPane().getDockable(viewName));
		}
	}
