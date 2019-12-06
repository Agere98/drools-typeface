package pl.put.poznan;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.ClassLoaderUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) throws FileNotFoundException {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kContainer.getKieBase();
        KieSession session = kieBase.newKieSession();

        Gson gson = new Gson();

        InputStream is = Main.class.getResourceAsStream("/typeface_questions.json");
        JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(is)));

        Question[] questions = gson.fromJson(reader, Question[].class);
         for (Question q : questions) {
             session.insert(q);
         }

        session.fireUntilHalt();
        session.dispose();
    }

    public static class Question {
        public String content;
        public String subject;
        public String[] possibleAnswers;
        public String type;

        public String getSubject() {
            return subject;
        }

        public Question(String cont, String subj) {
            content = cont;
            subject = subj;
            possibleAnswers = new String[]{"yes", "no"};
            type = "single";
        }

        public Question(String cont, String subj, String[] posans) {
            content = cont;
            subject = subj;
            possibleAnswers = posans;
            type = "single";
        }

        public Question(String cont, String subj, String[] posans, String tp) {
            content = cont;
            subject = subj;
            possibleAnswers = posans;
            type = tp;
        }

        @Override
        public String toString() {
            return content;
        }
    }
    public static class Answer {
        public String subject;
        public String answer;

        public String getAnswer() {
            return answer;
        }

        public Answer(String subj, String ans) {
            subject = subj;
            answer = ans;
        }
    }

}