package br_0309.apps.languageTrainer.data;

import br_0309.apps.languageTrainer.Reference;

import java.io.*;
import java.util.ArrayList;

public class UniversalData {

    public ArrayList<File> profileLocations;
    public ArrayList<File> exerciseLocations;

    @SuppressWarnings("unchecked")
    public void load() {
        File file = new File(Reference.DEFAULT_SAVE_DIR + File.separator + "settings.dat"); if (! file.exists()) {
            System.out.println("File does not exist");
            profileLocations = new ArrayList<>();
            exerciseLocations = new ArrayList<>();
            save();
            return;
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            profileLocations = (ArrayList<File>) in.readObject();
            exerciseLocations = (ArrayList<File>) in.readObject();
            System.out.println("Universal data loaded");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        for (File f : profileLocations) {
            System.out.println(f.getAbsolutePath());
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void save() {
        File file = new File(Reference.DEFAULT_SAVE_DIR + File.separator + "settings.dat"); if (! file.exists()) {
            profileLocations = new ArrayList<>();
            exerciseLocations = new ArrayList<>();
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
            out.writeObject(exerciseLocations);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void addProfileLocation(File file) {
        File folder;
        if (file.isDirectory()) {
            folder = file;
        } else {
            folder = file.getParentFile();
            if (folder == null) {
                return;
            }
        } if (! folder.exists()) {
            return;
        }
        for (File f : profileLocations) {
            if (f.equals(folder)) {
                return;
            }
        }
        profileLocations.add(folder);
        save();
    }

    public void addExerciseLocation(File file) {
        File folder;
        if (file.isDirectory()) {
            folder = file;
        } else {
            folder = file.getParentFile();
            if (folder == null) {
                return;
            }
        } if (! folder.exists()) {
            return;
        }
        if (exerciseLocations == null) {
            exerciseLocations = new ArrayList<>();
        }
        for (File f : exerciseLocations) {
            if (f.equals(folder)) {
                return;
            }
        }
        exerciseLocations.add(folder);
        save();
    }

}
