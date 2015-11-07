package br_0309.apps.languageTrainer.data;

import br_0309.apps.languageTrainer.util.SystemUtil;

public class ListStatistics {

	public int correct = 0;
	public int incorrect = 0;
	public int cheated = 0;
	public final String listName;
	public final String time = SystemUtil.getTimeAndDateFormatted();

	public ListStatistics(String listName) {
		this.listName = listName;
	}

}
