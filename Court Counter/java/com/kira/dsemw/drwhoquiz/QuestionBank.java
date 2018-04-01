package com.kira.dsemw.drwhoquiz;

/**
 * Created by dsemw on 31-03-2018.
 */

public class QuestionBank {
    private String textQuestions[] = {
            "1. Which aspect of ‘Cyber Bill’ should be ‘impossible’?",
            "2. What does Missy say about the mass Cyber-conversion?",
            "3. Which line, from The End of Time, does the Doctor quote?",
            "4. What does Heather call herself?",
            "5. 'People get the Cybermen wrong - there’s no evil plan… Just…’ What?",
            "6. What are Missy’s final words to the Doctor?",
            "7. How does the First Doctor describe ‘the whole thing’?",
            "8. Which Revenge of the Cybermen planet does the Doctor mention?",
            "9. What is Nardole going to name after the Doctor?",
            "10. Missy says the Master deserves… what?"
    };
    private String multipleChoice[][] = {
            {"Her beating heart", "Her tear", "Her compassion", "Her curly hair"},
            {"'Exciting,isn't it?'", "'Beautiful,isn't it?'", "'Glorious,isn't it?'", "'Awsome,isn't it?'"},
            {"‘Is this death?’", "I don’t want to go…", "‘It was always going to end this way…’", "'I don't want to die"},
            {"The Girl Who Waited", "The Immortal", "The Pilot", "The Driver"},
            {"An emotionless drive for sameness", "Parallel evolution", "Grim, machine-like inevitability", "Walking Zombie"},
            {"But no, sorry. Just… no", "We had fun though, didn’t we?", "Thanks for trying", "It was a great run"},
            {"Ridiculous!", "Preposterous!", "Quite out of the question!", "Blimey"},
            {"Pluto", "Voga", "Zeta Minor", "Alzarius"},
            {"A goat", "A pig", "A cow", "A cat"},
            {"‘A little me time…’", "‘A place to change in private.’", "My Best…", "A gift"}

    };
    private String nCorrectAnswers[] = {"Her tear", "'Exciting,isn't it?'", "I don’t want to go…", "The Pilot", "Parallel evolution", "Thanks for trying", "Ridiculous!", "Voga", "A pig", "My Best…"};

    public int getLength() {
        return textQuestions.length;
    }

    public String getQuestion(int n) {
        return textQuestions[n];
    }

    public String getChoice(int i, int j) {
        return multipleChoice[i][j - 1];
    }

    public String getCorrectAnswer(int a) {
        return nCorrectAnswers[a];
    }
}
