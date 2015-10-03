package br_0309.apps.languageTrainer.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br_0309.apps.languageTrainer.Reference;

public class UniversalData {

	public ArrayList<File> profileLocations;

	@SuppressWarnings("unchecked")
	public void load() {
		File file = new File(Reference.DEFAULT_SAVE_DIR + "settings.dat");
		if (!file.exists()) {
			profileLocations = new ArrayList<File>();
			save();
			return;
		}
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			profileLocations = (ArrayList<File>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void save() {
		File file = new File(Reference.DEFAULT_SAVE_DIR + "settings.dat");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(profileLocations);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
