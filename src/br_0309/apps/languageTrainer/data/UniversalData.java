package br_0309.apps.languageTrainer.data;

import java.io.File;
import java.util.ArrayList;

public class UniversalData {

	public ArrayList<File> profileLocations;

	public void load() {
		// TODO: Implement loading of universal data
	}

	public void save() {
		// TODO: Implement saving of universal data
	}

	public void addLocation(File file) {
		File folder;
		if (file.isDirectory()) {
			folder = file;
		} else {
			folder = file.getParentFile();
			if (folder == null) {
				return;
			}
		}
		if (!folder.exists()) {
			return;
		}
		for (File f : profileLocations) {
			if (f.equals(folder)) {
				return;
			}
		}
		profileLocations.add(folder);
	}

}
