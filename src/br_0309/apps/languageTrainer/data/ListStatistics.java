package br_0309.apps.languageTrainer.data;

import java.io.Serializable;

import br_0309.apps.languageTrainer.util.SystemUtil;

public class ListStatistics implements Serializable {

	private static final long serialVersionUID = -2484107990886936920L;
	public int correct = 0;
	public int incorrect = 0;
	public int cheated = 0;
	public final String listName;
	public final boolean listType;
	public final String[] langCodes;
	public final String time = SystemUtil.getTimeAndDateFormatted();

	/**
	 * @param listType
	 *            true: translation. false: verbs
	 */
	public ListStatistics(String listName, boolean listType, String[] langCodes) {
		this.listName = listName;
		this.listType = listType;
		this.langCodes = langCodes;
	}

}
