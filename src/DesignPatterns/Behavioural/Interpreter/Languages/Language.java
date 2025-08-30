package DesignPatterns.Behavioural.Interpreter.Languages;

public abstract class Language {
    private ENUM_LANGUAGE language;

    public Language(ENUM_LANGUAGE language) {
        this.language = language;
    }

    public String translate(String sentence) {
        String str = seperateWords(sentence);
        return str;
    }

    private String seperateWords(String sentence) {
        System.out.println("seperateWords Sentence: " + sentence);
        String[] arr = sentence.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(translateWord(arr[i]));
            if (i < arr.length - 1) {
                str.append(" ");
            }
        }
        System.out.println("translated sentence: " + str.toString());
        return str.toString();
    }

    private String translateWord(String word) {
        System.out.println("translateWord input: " + word);
        String translatedWord = convertLanguage(word);
        System.out.println("translateWord output: " + translatedWord);
        return translatedWord;
    }

    private String convertLanguage(String birdWord) {
        String adjunctLetter = language.getAdjunct().substring(0, 1); // "g" veya "c"

        // Regex pattern: Dile Ait Ek + ünlü harf
        // ga, ge, gi, go, gu, gü, gö, gı (Karga Dili İçin)
        // ca, ce, ci, co, cu, cü, cö, cı (Kuş Dili için)
        String pattern = adjunctLetter + "[aeiouüöıAEIOUÜÖI]";

        String result = birdWord.replaceAll(pattern, "");

        System.out.println("Converting: " + birdWord + " → " + result + " (removing pattern: " + pattern + ")");
        return result;
    }
}
