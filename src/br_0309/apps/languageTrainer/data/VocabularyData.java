package br_0309.apps.languageTrainer.data;

import br_0309.apps.languageTrainer.LanguageTrainer;

public class VocabularyData extends ExcerciseData {

	private final String[] words1;
	private final String[] words2;
	private final String lang1;
	private final String lang2;
	private final boolean fromOne;
	private final int q;

	public VocabularyData(String[] words1, String[] words2, String[] langs) {
		this.words1 = words1;
		this.words2 = words2;
		lang1 = langs[0];
		lang2 = langs[1];
		fromOne = LanguageTrainer.random.nextBoolean();
		if (fromOne) {
			q = LanguageTrainer.random.nextInt(words1.length - 1);
		} else {
			q = LanguageTrainer.random.nextInt(words1.length - 1);
		}
	}

	public boolean isCorrect(String solution) {
		if (fromOne) {
			for (String s : words2) {
				if (s.equals(solution)) { return true; }
			}
		} else {
			for (String s : words1) {
				if (s.equals(solution)) { return true; }
			}
		}
		return false;
	}

	public String getQuestion() {
		if (fromOne) {
			return words1[q];
		} else {
			return words2[q];
		}
	}

	public String[] getSolutions() {
		if (fromOne) {
			return words2;
		} else {
			return words1;
		}
	}

	public String getFrom() {
		if (fromOne) {
			return lang1;
		} else {
			return lang2;
		}
	}

	public String getTo() {
		if (fromOne) {
			return lang2;
		} else {
			return lang1;
		}
	}

}
