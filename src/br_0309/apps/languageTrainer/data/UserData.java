package br_0309.apps.languageTrainer.data;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.Reference;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

public class UserData implements Serializable {

    public static final Properties DEFAULT_PROPERTIES = getDefaults();
    private static final long serialVersionUID = 2362898497407984692L;
    public ArrayList<Statistics> stats = new ArrayList<>();
    public Properties properties;
    public File file;

    /**
     * Creates a UserData object with only the defaults
     */
    public UserData() {
        properties = new Properties(DEFAULT_PROPERTIES);
    }

    /**
     * Creates a UserData object from a file
     */
    public UserData(File file) {
        this.file = file;
        load();
    }

    /**
     * Returns all the default values
     */
    private static Properties getDefaults() {
        Properties p = new Properties();
        p.setProperty(Reference.PROPERTY_LANGUAGE, LanguageHandler.getBestLocale().getLanguage());
        p.setProperty(Reference.PROPERTY_LANGUAGE_REGION, LanguageHandler.getBestLocale().getCountry());
        p.setProperty(Reference.PROPERTY_SOUND_CORRECT, Reference.SOUNDS_CORRECT[0]);
        p.setProperty(Reference.PROPERTY_SOUND_INCORRECT, Reference.SOUNDS_INCORRECT[0]);
        p.setProperty(Reference.PROPERTY_SOUND_FINISHED, Reference.SOUNDS_FINISHED[0]);
        p.setProperty(Reference.PROPERTY_PLAY_SOUNDS, "true");
        p.setProperty(Reference.PROPERTY_THEME, Reference.THEMES[0]);
        return p;
    }

    /**
     * Saves to a file
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void save() {
        ObjectOutputStream out = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                properties = new Properties(getDefaults());
            }
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(properties);
            out.writeObject(stats);
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

    /**
     * Loads from a file
     */
    @SuppressWarnings("unchecked")
    public void load() {
        ObjectInputStream in = null;
        try {
            if (!file.exists()) {
                save();
                return;
            }
            in = new ObjectInputStream(new FileInputStream(file));

            properties = (Properties) in.readObject();
            stats = (ArrayList<Statistics>) in.readObject();
        } catch (EOFException e) {
            System.out.println("No data in file. Saving defaults.");
            save();
            load();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                // XXX: Find out why in.close causes NPE
                // e.printStackTrace();
            }
            // Fill in default properties to prevent updates braking profiles
            Properties defaults = getDefaults();
            if (properties == null) {
                properties = new Properties(getDefaults());
            }
            // For each, set property and value
            defaults.entrySet().stream().filter(entry -> !properties.containsKey(entry.getKey()))
                    .forEach(entry -> properties.setProperty(entry.getKey().toString(), entry.getValue().toString()));
        }
    }

    /**
     * Returns the language the user chose, or best suited
     */
    public Locale getLanguage() {
        return new Locale(properties.getProperty(Reference.PROPERTY_LANGUAGE),
                          properties.getProperty(Reference.PROPERTY_LANGUAGE_REGION));
    }

    /**
     * Sets the language. Sets this to the active language. <b>Does not
     * save.</b>
     */
    public void setLanguage(Locale locale) {
        properties.setProperty(Reference.PROPERTY_LANGUAGE, locale.getLanguage());
        properties.setProperty(Reference.PROPERTY_LANGUAGE_REGION, locale.getCountry());
        LanguageHandler.setDisplayLanguage(locale);
    }

    /**
     * Adds all Statistics in list
     */
    public void putStats(ArrayList<Statistics> list) {
        stats.addAll(list);
        save();
    }

    /**
     * @return if sounds should be played
     */
    @SuppressWarnings("BooleanMethodNameMustStartWithQuestion")
    public boolean getPlaySounds() {
        return Boolean.parseBoolean(properties.getProperty(Reference.PROPERTY_PLAY_SOUNDS));
    }

    /**
     * Sets the value of playSounds. <b>Does not save.</b>
     */
    public void setPlaySounds(boolean value) {
        properties.setProperty(Reference.PROPERTY_PLAY_SOUNDS, Boolean.toString(value));
    }

    /**
     * @return the theme the user chose, or default
     */
    public String getTheme() {
        return properties.getProperty(Reference.PROPERTY_THEME);
    }

    /**
     * Sets the theme. <b>Does not save.</b>
     */
    public void setTheme(String theme) {
        properties.setProperty(Reference.PROPERTY_THEME, theme);
    }

    /**
     * @return the selected sound for correct answers
     */
    public String getSoundCorrect() {
        return properties.getProperty(Reference.PROPERTY_SOUND_CORRECT);
    }

    /**
     * Sets the correct sound. <b>Does not save.</b>
     */
    public void setSoundCorrect(String sound) {
        properties.setProperty(Reference.PROPERTY_SOUND_CORRECT, sound);
    }

    /**
     * @return the selected sound for incorrect answers
     */
    public String getSoundIncorrect() {
        return properties.getProperty(Reference.PROPERTY_SOUND_INCORRECT);
    }

    /**
     * Sets the incorrect sound. <b>Does not save.</b>
     */
    public void setSoundIncorrect(String sound) {
        properties.setProperty(Reference.PROPERTY_SOUND_INCORRECT, sound);
    }

    /**
     * @return the sound for a finished exercise
     */
    public String getSoundFinished() {
        return properties.getProperty(Reference.PROPERTY_SOUND_FINISHED);
    }

    /**
     * Sets the finished sound. <b>Does not save.</b>
     */
    public void setSoundFinished(String sound) {
        properties.setProperty(Reference.PROPERTY_SOUND_FINISHED, sound);
    }

}
