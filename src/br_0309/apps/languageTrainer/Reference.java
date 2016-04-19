package br_0309.apps.languageTrainer;

import br_0309.apps.languageTrainer.util.SystemUtil;

import java.util.Locale;

@SuppressWarnings("HardcodedFileSeparator")
public class Reference {

    public static final String FXML_MENU = "/br_0309/apps/languageTrainer/scenes/Menu.fxml";
    public static final String FXML_PROFILE_SELECT = "/br_0309/apps/languageTrainer/scenes/ProfileSelect.fxml";
    public static final String FXML_PROFILE_NEW = "/br_0309/apps/languageTrainer/scenes/ProfileNew.fxml";
    public static final  String FXML_TRANSLATION = "/br_0309/apps/languageTrainer/scenes/Translate.fxml";
    public static final String FXML_SETTINGS = "/br_0309/apps/languageTrainer/scenes/Settings.fxml";
    public static final String FXML_CREATE_TRANSLATION = "/br_0309/apps/languageTrainer/scenes/CreateTranslationList.fxml";
    public static final String FXML_LANGUAGE_ADD = "/br_0309/apps/languageTrainer/scenes/LanguageAdd.fxml";
    public static final String FXML_STATISTICS = "/br_0309/apps/languageTrainer/scenes/Statistics.fxml";
    public static final String FXML_ABOUT = "/br_0309/apps/languageTrainer/scenes/About.fxml";
    public static final String FXML_RESOURCES = "/br_0309/apps/languageTrainer/scenes/Resources.fxml";
    public static final String FXML_VERB_ENGLISH = "/br_0309/apps/languageTrainer/scenes/VerbEnglish.fxml";
    public static final String FXML_VERB_GERMAN = "/br_0309/apps/languageTrainer/scenes/VerbGerman.fxml";
    public static final String FXML_VERB_FRENCH = "/br_0309/apps/languageTrainer/scenes/VerbFrench.fxml";
    public static final String FXML_VERBS = "/br_0309/apps/languageTrainer/scenes/Verbs.fxml";
    public static final String FXML_CREATE_VERBS = "/br_0309/apps/languageTrainer/scenes/CreateVerbList.fxml";

    public static final String[] THEMES = {"/stylesheets/default.css", "/stylesheets/dark.css", "/stylesheets/blue.css"};

    public static final String BUNDLE_LOC = "lang/Locale";

    public static final String PROPERTY_LANGUAGE = "lang";
    public static final String PROPERTY_LANGUAGE_REGION = "region";
    public static final String PROPERTY_SOUND_CORRECT = "correct";
    public static final String PROPERTY_SOUND_INCORRECT = "incorrect";
    public static final String PROPERTY_SOUND_FINISHED = "finished";
    public static final String PROPERTY_PLAY_SOUNDS = "pSounds";
    public static final String PROPERTY_THEME = "theme";
    public static final String PROPERTY_RECENTLY_USED_CHARACTERS = "charsRecentlyUsed";

    public static String DEFAULT_SAVE_DIR;
    public static String DEFAULT_EXERCISE_DIR;
    public static final String DEFAULT_PROFILE_DIR = SystemUtil.getUserHome();

    static final String LOGO = "/icons/Logo.png";
    public static final String VERSION = "1.0";

    public static final String[] SOUNDS_CORRECT = {"/sounds/correct/correct.wav", "/sounds/correct/correct2.wav", "/sounds/correct/game-sound-correct-v2.wav",
                                                   "/sounds/correct/jingle-4.wav", "/sounds/correct/powerup-success.wav"};
    public static final String[] SOUNDS_INCORRECT = {"/sounds/incorrect/incorrect.wav", "/sounds/incorrect/misslyckad-bana-v5.wav",
                                                     "/sounds/incorrect/negative-beeps.wav", "/sounds/incorrect/negative.wav",
                                                     "/sounds/incorrect/negativebeep.wav", "/sounds/incorrect/sine-negative-beep.wav"};
    public static final String[] SOUNDS_FINISHED = {"/sounds/finished/3-men-cheering.wav", "/sounds/finished/applause-2.wav", "/sounds/finished/loop1.wav",
                                                    "/sounds/finished/melo4.wav", "/sounds/finished/sine-melody.wav", "/sounds/finished/sine-melody-2.wav",
                                                    "/sounds/finished/smallcrowd.wav", "/sounds/finished/summertime-stab.wav"};

    public static final String FLAG_DIR = "/icons/flags/";
    public static final char[] INVALID_FILE_CHARS = {'/', '\\', '?', '%', '*', ':', '|', '"', '<', '>', '.', ',', '&', '#'};

    public static final String COPYRIGHTS_BASE_NAME = "/lang/Copyright-";
    public static final String COPYRIGHTS_END = ".txt";

    public static final Locale SYSTEM_LOCALE = Locale.getDefault();
    public static final Locale[] VERB_LOCALES = {Locale.ENGLISH, Locale.GERMAN, Locale.FRENCH};

    public static final String URL_CREATIVE_COMMONS_ZERO = "https://creativecommons.org/publicdomain/zero/1.0/";
    public static final String URL_CREATIVE_COMMONS_ATTRIBUTION = "https://creativecommons.org/licenses/by/3.0/";
    public static final String URL_PUBLIC_DOMAIN = "https://en.wikipedia.org/wiki/Public_domain";
    public static final String URL_GEMEINFREIHEIT = "https://de.wikipedia.org/wiki/Gemeinfreiheit";

    public static final String CHARACTERS_LATIN = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    public static final String CHARACTERS_LATIN_EXTENDED = "ÀàÂâÆæÄäÅåÇçÉéÈèÊêËëÎîÏïÔôŒœÖöòóÙùÛûÜüŸÿÑñ¿¡";

}
